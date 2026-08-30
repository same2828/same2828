# Merging `master` into `dev`: A Comprehensive Guide

## Scenario

- `master` has new commits that are not in `dev`.
- `dev` has **many** commits ahead of (or diverged from) `master`.
- Rebasing `dev` onto `master` would force you to resolve the _same conflicts repeatedly_, once per `dev` commit.
- Squashing all of `dev` into a single commit is **not acceptable** (we want to preserve history).

Below are all the practical strategies, from simplest to most advanced, with trade-offs.

## 1. `git merge` (the standard approach)

Create a merge commit that brings `master`'s changes into `dev`.

```bash
git checkout dev
git fetch origin
git merge origin/master
# resolve conflicts ONCE
git commit            # finalises the merge commit
```

### Pros

- Resolve conflicts **only once** (vs once per commit in a rebase).
- Preserves the full history of both branches.
- Reversible with `git merge --abort` while in progress.
- Easy to review: one merge commit with a clear two-parent ancestry.

### Cons

- Adds a merge commit to `dev`'s history (some teams dislike these).
- History becomes non-linear.

### Variations

- `git merge --no-ff origin/master` — always create a merge commit even when fast-forward is possible (useful for visibility).
- `git merge --ff-only origin/master` — refuse to merge unless it can fast-forward (won't apply in this scenario since `dev` has diverged).
- `git merge -X ours origin/master` — auto-resolve conflicting hunks by keeping `dev`'s version. See section 1a.
- `git merge -X theirs origin/master` — auto-resolve conflicting hunks by keeping `master`'s version. See section 1a.
- `git merge -s ours origin/master` — record a merge but discard `master`'s changes entirely. See section 1a.

## 1a. `-X ours` vs `-X theirs` vs `-s ours` — strategies in detail

These three flags look similar but behave very differently. Mixing them up is one of the easiest ways to silently lose work, so it's worth being precise.

First, the vocabulary. Git's recursive (or `ort`) merge strategy can take **strategy options** via `-X` _and_ you can swap the whole **strategy** itself via `-s`. They live at different layers:

- `-s <strategy>` — chooses the algorithm Git uses to combine the trees.
- `-X <option>` — passes an option _into_ the default recursive/ort strategy.

"Ours" and "theirs" mean different things in each context:

| Form                                | Layer                   | What it does to conflicting **hunks** | What it does to **non-conflicting** changes from the other side       |
| ----------------------------------- | ----------------------- | ------------------------------------- | --------------------------------------------------------------------- |
| `git merge -X ours origin/master`   | option to recursive/ort | Keeps `dev`'s version of the hunk     | **Still merges them in** — you get `master`'s non-conflicting changes |
| `git merge -X theirs origin/master` | option to recursive/ort | Keeps `master`'s version of the hunk  | **Still merges them in** — you get `master`'s non-conflicting changes |
| `git merge -s ours origin/master`   | whole strategy          | N/A — no real merge happens           | **Discards them all** — tree is identical to `dev` pre-merge          |

Key intuition: `-X` is "auto-resolve conflicts in this direction, but otherwise do a real merge." `-s ours` is "pretend we merged, but actually keep our tree exactly as it is."

There is **no `-s theirs`** strategy in core Git. The equivalent effect ("throw away my branch, take theirs entirely, but record it as a merge") has to be faked — see the recipe at the end of this section.

### `git merge -X ours origin/master`

- Performs a normal three-way merge.
- For every hunk where both sides changed the same lines, **keeps `dev`'s version** (drops `master`'s).
- For every hunk where only `master` changed, **takes `master`'s change.**
- For every file `master` added that `dev` didn't touch, **adds it.**

When to use it:

- `dev` is the source of truth for a few hot files, but you still want everything else `master` introduced.
- Doing a defensive merge where you'd rather not let `master` overwrite your in-flight work.

Risks:

- Silent. You won't see what `master` tried to change in the conflicting hunks; those changes are simply dropped. Run `git log -p origin/master ^dev -- <conflicting files>` afterwards to see what you discarded.
- Often masks a real semantic conflict. Two sides edited the same lines for a reason — picking one without reading the other is a guess.

### `git merge -X theirs origin/master`

- Mirror of `-X ours`. Conflicting hunks resolve in **`master`'s favour**.
- Non-conflicting changes from both sides are merged normally.

When to use it:

- You're catching `dev` up to `master` and you accept that, where they collide, `master` wins.
- Useful for long-lived feature branches that have drifted far from `master` and you've decided `master`'s direction is canonical.

Risks:

- Symmetric to `-X ours`: `dev`'s conflicting changes are silently dropped.
- Easy to confuse with `-s theirs` (which doesn't exist) or with `--theirs` during conflict resolution (`git checkout --theirs <file>`), which is yet another thing.

### `git merge -s ours origin/master`

- Does **not** perform a content merge.
- Records a merge commit with two parents (`dev` and `origin/master`), but the tree of the new commit is **identical to `dev`'s tree before the merge**. Every change `master` introduced is discarded.
- The merge ancestry is recorded, so future merges from `master` will believe those commits are already integrated and won't re-introduce them.

When to use it:

- You want to **tell Git "we have considered these `master` commits and are deliberately ignoring them"** — typically because `dev` reimplemented the same feature differently, or because the `master` work is being abandoned.
- Releasing a version where you want to mark obsolete branches as merged for bookkeeping without actually pulling code.

Risks:

- **You will lose `master`'s changes permanently from `dev`'s line of history.** They're still in `master`, but the merge commit lies about having incorporated them.
- Almost always the wrong answer if you actually want `master`'s improvements. People reach for it thinking it means "keep our side on conflicts" — that's `-X ours`, not `-s ours`.

### Side-by-side example

Suppose `dev` and `master` both touched `config.yml`:

```yaml
# common ancestor
timeout: 10
retries: 3
```

```yaml
# dev
timeout: 30 # changed by dev
retries: 3
debug: true # added by dev
```

```yaml
# master
timeout: 60 # changed by master
retries: 5 # changed by master (no conflict with dev)
region: us-east-1 # added by master
```

Results of merging `master` into `dev`:

| Command                             | `timeout`                      | `retries`                               | `debug` | `region`                             |
| ----------------------------------- | ------------------------------ | --------------------------------------- | ------- | ------------------------------------ |
| `git merge -X ours origin/master`   | `30` (dev wins conflict)       | `5` (no conflict, master's change kept) | `true`  | `us-east-1`                          |
| `git merge -X theirs origin/master` | `60` (master wins conflict)    | `5`                                     | `true`  | `us-east-1`                          |
| `git merge -s ours origin/master`   | `30`                           | `3`                                     | `true`  | _(missing — master's add discarded)_ |
| Plain `git merge`                   | conflict on `timeout` — manual | `5`                                     | `true`  | `us-east-1`                          |

Notice how `-X ours` and `-s ours` _both_ keep `dev`'s `timeout`, but only `-X ours` picks up the unrelated improvements (`retries: 5`, `region: us-east-1`).

### Faking "`-s theirs`"

If you genuinely want "take `master`'s tree wholesale but record it as a merge of `dev` and `master`":

```bash
git checkout dev
git merge -s ours --no-commit origin/master   # record ancestry, keep dev tree
git read-tree -u --reset origin/master         # overwrite working tree with master's
git commit                                     # finalise
```

This is rarely the right thing — usually you'd just `git reset --hard origin/master`, but that loses the merge ancestry. Use the recipe only when the ancestry matters.

### Recap

- `-X ours` / `-X theirs` — **real merge, with a tiebreaker for conflicts.** Safe-ish, but silently drops the losing side's conflicting hunks.
- `-s ours` — **fake merge, discards the other side entirely.** Use only when you genuinely want to mark `master`'s commits as "considered and rejected."
- There is no `-s theirs`. Use plain `git merge` (and resolve `dev`'s losses manually) or the recipe above.

## 1b. Other `-X` strategy options worth knowing

Beyond `ours`/`theirs`, the recursive/ort strategy takes several other options that often eliminate conflicts entirely. They can be combined (`-X ignore-space-change -X find-renames=80`).

| Option                        | What it does                                                                      | When to use                                                                                     |
| ----------------------------- | --------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `-X patience`                 | Uses the patience diff algorithm to compute the merge                             | Conflicts dominated by reshuffled blocks (function reorders); often produces cleaner hunks      |
| `-X diff-algorithm=histogram` | Uses the histogram diff algorithm                                                 | Generally the best modern algorithm; produces fewer spurious conflicts than the default `myers` |
| `-X ignore-space-change`      | Treats runs of whitespace as equivalent                                           | After someone reformatted indentation                                                           |
| `-X ignore-all-space`         | Ignores whitespace entirely when matching lines                                   | Same as above, more aggressive                                                                  |
| `-X ignore-space-at-eol`      | Ignores trailing whitespace differences                                           | Editors that strip/add trailing spaces                                                          |
| `-X ignore-cr-at-eol`         | Ignores CRLF vs LF at end of lines                                                | Cross-platform repos with line-ending churn                                                     |
| `-X renormalize`              | Re-applies `.gitattributes` text/eol normalization to both sides before comparing | After changing line-ending or text-conversion rules                                             |
| `-X find-renames[=n]`         | Sets rename-detection threshold (default ~50%)                                    | When files were renamed in `master` and edited in `dev`                                         |
| `-X no-renames`               | Disables rename detection entirely                                                | When rename detection is misfiring and producing nonsense merges                                |
| `-X subtree[=path]`           | Adjusts paths so a subtree from one side maps onto a directory of the other       | Subtree merges (rare)                                                                           |

`-X ignore-*-space` is particularly underused — many "real" conflicts in older repos are pure whitespace noise.

## 1c. Other `-s` strategies

Most people only know `recursive` (default before Git 2.34) and `ort` (default since Git 2.34). The others exist for niche cases:

| Strategy       | What it does                                                                                                                                           | When to use                                                                                                       |
| -------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------- |
| `-s ort`       | Default since Git 2.34. Same semantics as `recursive` but a from-scratch rewrite — faster, handles edge cases (rename/rename, directory rename) better | The default; you rarely need to specify it                                                                        |
| `-s recursive` | Older default. Three-way merge with virtual common ancestors when there are multiple merge bases                                                       | Only specify it if you hit an `ort` bug and need a fallback                                                       |
| `-s resolve`   | Older, simpler three-way merge. Doesn't construct virtual ancestors for criss-cross merges                                                             | Historical; almost never preferable                                                                               |
| `-s octopus`   | Default when merging **more than two** branches in one go                                                                                              | `git merge branch-a branch-b branch-c`. Refuses if any branch has conflicts — only works for clean trivial merges |
| `-s ours`      | Fake merge, discards the other side (covered above)                                                                                                    | Mark a branch as "considered and rejected"                                                                        |
| `-s subtree`   | Variant of recursive that auto-detects subtree relationships                                                                                           | Subtree-style integrations                                                                                        |

For the scenario in this document, the default `ort` is correct — you don't need `-s` at all.

## 1d. Controlling the merge commit: message, signing, and finalization

Section 1's variations change _what gets merged_. The flags below change _how the merge commit is created and recorded_. They don't affect conflict resolution, but they matter for history hygiene, audits, and automation.

### Fast-forward modes (the complete picture)

There are three, and `git merge` picks `--ff` unless told otherwise:

| Flag             | Behaviour                                                                 |
| ---------------- | ------------------------------------------------------------------------- |
| `--ff` (default) | Fast-forward if possible (no divergence), otherwise create a merge commit |
| `--no-ff`        | **Always** create a merge commit, even when a fast-forward was possible   |
| `--ff-only`      | Fast-forward if possible, otherwise **abort and do nothing**              |

In this document's scenario `dev` has diverged, so `--ff` and `--no-ff` behave identically (you always get a merge commit) and `--ff-only` always refuses. `--no-ff` matters mostly during _catch-up_ merges (section 14), where a fast-forward would otherwise be possible and you'd lose the "we synced here" marker. Make it the default if you prefer:

```bash
git config merge.ff false          # this repo: never fast-forward on merge
git config --global merge.ff false # everywhere
```

### Finalizing a conflicted merge

After resolving conflicts the document mostly finalizes with `git commit`. The modern, intent-revealing equivalent is:

```bash
git add <resolved files>
git merge --continue   # Git 2.12+; commits using the merge message Git already prepared
```

Both `git commit` and `git merge --continue` refuse while unmerged paths remain, so the practical difference is small — `--continue` simply makes it explicit that you're completing _this merge_ rather than making an unrelated commit.

### Merge message control

| Flag                 | Effect                                                                                   |
| -------------------- | ---------------------------------------------------------------------------------------- |
| `-m "<msg>"`         | Set the merge commit message directly (no editor)                                        |
| `-F <file>`          | Read the merge message from a file                                                       |
| `--edit` / `-e`      | Force the editor open even when a message was supplied or auto-generated                 |
| `--no-edit`          | Accept the auto-generated message without opening an editor (handy in scripts)           |
| `--log[=<n>]`        | Append the one-line summaries of up to `n` merged commits into the merge message         |
| `--no-log`           | Suppress that summary (the default)                                                      |
| `--cleanup=<mode>`   | How to clean up the message (`strip`, `whitespace`, `verbatim`, …)                       |
| `--into-name <name>` | Use `<name>` instead of the current branch in the auto message ("Merge … into `<name>`") |

`--log` is underused: it embeds _what_ you merged into the merge commit message, so `git log` of just the merge commits tells a story without `--graph` gymnastics.

### Signing and verification

| Flag                         | Effect                                                                                     |
| ---------------------------- | ------------------------------------------------------------------------------------------ |
| `-S[<keyid>]` / `--gpg-sign` | GPG-sign the merge commit                                                                  |
| `--no-gpg-sign`              | Don't sign, even if `commit.gpgSign = true`                                                |
| `--signoff`                  | Add a `Signed-off-by` trailer (DCO workflows)                                              |
| `--verify-signatures`        | **Refuse the merge** unless the tip commit being merged carries a valid, trusted signature |
| `--no-verify-signatures`     | Skip that check (default)                                                                  |

`--verify-signatures` is a real safety control when merging from untrusted or semi-trusted remotes — the merge-time analogue of branch protection.

### Other useful flags

| Flag                          | Effect                                                                                                                                                                                  |
| ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `--no-commit`                 | Do the merge and stage the result, but stop before committing (inspect / test first — see section 10)                                                                                   |
| `--commit`                    | Override a configured `--no-commit` and commit normally                                                                                                                                 |
| `--squash`                    | Stage the merged result as working changes with **no merge commit and no second parent** — see section 9                                                                                |
| `--autostash`                 | Stash a dirty working tree before the merge and re-apply it after, so you don't need a clean tree (Git 2.27+)                                                                           |
| `--no-verify`                 | Skip the `pre-merge-commit` and `commit-msg` hooks                                                                                                                                      |
| `--stat` / `-n` (`--no-stat`) | Show / suppress a diffstat at the end of the merge                                                                                                                                      |
| `--allow-unrelated-histories` | Permit merging two branches that share **no common ancestor** (e.g. grafting a separate repo's history). Refused by default since Git 2.9 to catch accidental merges of the wrong thing |
| `-q` / `-v`                   | Quiet / verbose                                                                                                                                                                         |

`--autostash` is the one most people wish they'd known about: it removes the "please commit or stash your changes before you merge" friction for a quick catch-up merge.

## 2. `git rebase` (and why it hurts here)

```bash
git checkout dev
git rebase origin/master
```

Git replays each `dev` commit on top of `master`. If the same area of code is touched by many `dev` commits, you may have to resolve **the same conflict repeatedly**.

### Pros

- Produces a clean, linear history.
- No merge commit.

### Cons

- Conflict-resolution fatigue — exactly the problem described.
- Rewrites `dev`'s commit SHAs (bad if `dev` is shared/pushed).
- Force-push required after rebase (`git push --force-with-lease`).

This is the option you specifically want to avoid — unless you combine it with `rerere` (section 5) or `git imerge` (section 7).

## 3. `git pull --rebase` / `git pull` (convenience wrappers)

If `master` is your upstream, `git pull` is just a `fetch` + `merge` (or `+rebase`):

```bash
git checkout dev
git pull --no-rebase origin master   # merge style
git pull --rebase origin master      # rebase style
```

Same trade-offs as sections 1 and 2 respectively. No new behaviour, just shorter to type.

## 4. Cherry-pick (when you only want some commits)

If `dev` only needs _some_ changes from `master`:

```bash
git checkout dev
git cherry-pick <commit-sha>...<commit-sha>
```

### Pros

- Surgical — bring in only what you need.
- No merge commit.

### Cons

- Duplicates commits (new SHAs on `dev`), which can cause confusion later when `dev` eventually merges back to `master`.
- Tedious for many commits.
- Doesn't establish a merge ancestry, so `git` won't realise these changes are already present in future merges.

Not recommended as the **primary** strategy here, but useful for hotfixes.

## 5. `git rerere` — Reuse Recorded Resolution

This is the configuration you remembered. `rerere` ("reuse recorded resolution") asks Git to **memorise how you resolved a conflict** and replay that resolution automatically the next time the _same_ conflict appears.

It is the single biggest win when you must rebase a long-lived branch with repeated conflicts.

### Enable globally

```bash
git config --global rerere.enabled true
```

Optionally, also let Git stage cleanly-resolved files automatically:

```bash
git config --global rerere.autoUpdate true
```

Equivalent `~/.gitconfig` snippet:

```ini
[rerere]
    enabled = true
    autoUpdate = true
```

### Enable for the current repository only

If you don't want `rerere` running in every repo on your machine (sensible — recorded resolutions don't always transfer well between projects), enable it just for this checkout. Run these from the repo root:

```bash
git config --local rerere.enabled true
git config --local rerere.autoUpdate true   # optional
```

`--local` is the default when no scope flag is given, so this is equivalent:

```bash
git config rerere.enabled true
git config rerere.autoUpdate true
```

Both write to `.git/config` inside the current repository. To confirm:

```bash
git config --local --get rerere.enabled
git config --show-origin --get rerere.enabled    # shows which file the value came from
```

The resulting `.git/config` will contain:

```ini
[rerere]
    enabled = true
    autoUpdate = true
```

Scope precedence (highest wins): `--local` (`.git/config`) > `--global` (`~/.gitconfig`) > `--system` (`/etc/gitconfig`). So a per-repo `rerere.enabled = false` will override a global `true`, which is useful if you want `rerere` on by default but disabled for one tricky repo.

> Note: `.git/config` is **not** tracked by Git, so per-repo settings stay on your machine and aren't shared with collaborators (same as the rerere cache itself — see drawback #2 below). If you want every clone of the repo to have `rerere` on, you'd need a setup script or a `make bootstrap` target — Git has no built-in mechanism to ship config with a repo.

### How to use it

Once enabled, it works transparently:

```bash
git checkout dev
git rebase origin/master
# resolve a conflict — rerere records the resolution
git add <files>
git rebase --continue

# next time the SAME conflict appears (during this or a later rebase),
# rerere replays your resolution automatically.
```

You can inspect or clear recorded resolutions:

```bash
git rerere status      # files with active recorded resolutions
git rerere diff        # what rerere would do
git rerere forget <path>  # discard a specific recorded resolution
```

### Drawbacks of `rerere`

1. **It silently re-applies resolutions.** If you resolved a conflict _wrong_ the first time, `rerere` will quietly repeat the wrong resolution every time. You may not notice.
2. **Local only by default.** Recorded resolutions live in `.git/rr-cache/` and are **not shared** with teammates. Each developer must build up their own cache, or you must script syncing the cache.
3. **Matches by conflict content, not by intent.** If a different conflict happens to _look_ the same, `rerere` will apply the old resolution — potentially incorrectly. Two unrelated changes that produce identical conflict markers will be resolved identically.
4. **Hides conflicts you should review.** Because resolutions are auto-applied, you may merge without realising a conflict occurred. Some teams find this masks important review opportunities.
5. **`autoUpdate = true` stages files for you.** Convenient, but means you can `git rebase --continue` without ever seeing what was resolved. Many practitioners enable `rerere.enabled` but leave `autoUpdate` off, so they still get a chance to `git diff --cached` before continuing.
6. **Doesn't help with non-conflict problems.** If a rebased commit applies cleanly but produces broken code (semantic conflict), `rerere` won't catch it.
7. **Cache grows over time.** Rarely a real problem, but `.git/rr-cache/` accumulates entries; prune with `git rerere gc` or by adjusting `gc.rerereResolved` / `gc.rerereUnresolved`.

### Mitigations

- Review what `rerere` did: `git rerere diff` before `git rebase --continue`.
- Run your test suite after the rebase completes — semantic conflicts are still your responsibility.
- For team-wide sharing, commit `.git/rr-cache/` contents to a side repo or sync via a script; there is no built-in mechanism.

## 6. Rebase with `--rerere-autoupdate`

A one-off way to combine `rerere` with a rebase without globally enabling `autoUpdate`:

```bash
git rebase --rerere-autoupdate origin/master
```

Useful when you trust `rerere` for this specific rebase but want manual control normally.

## 7. `git imerge` — Incremental Merge

`git imerge` (third-party, by Michael Haggerty) is purpose-built for _exactly_ the scenario described: rebasing or merging across many commits where conflicts repeat.

Install (Homebrew):

```bash
brew install git-imerge
```

Usage:

```bash
git checkout dev
git imerge rebase origin/master
# resolve conflicts one pairwise step at a time;
# imerge isolates each conflict to the SMALLEST commit pair that caused it,
# so you never re-resolve the same conflict.
git imerge finish
```

### Pros

- Designed to minimise duplicated conflict resolution.
- Can be paused and resumed across days.
- Produces either a linear rebase or a merge commit (your choice with `imerge finish --goal`).

### Cons

- Extra dependency, not in core Git.
- Learning curve.
- Less familiar to teammates reviewing the result.

This is arguably the **best technical fit** for the scenario, but the operational cost of introducing a new tool may not be worth it for a one-off merge.

## 8. Merge with manual conflict-driver assistance

For conflicts that follow a pattern (e.g. version bumps in `package.json`, generated files, append-only logs), configure a custom merge driver in `.gitattributes` + `.git/config`.

### Built-in `union` driver — keep both sides

For files where you almost always want to **concatenate** both sides' changes (CHANGELOG.md, .gitignore, dependency manifests where order doesn't matter):

```gitattributes
# .gitattributes
CHANGELOG.md merge=union
.gitignore merge=union
```

No `.git/config` entry required — `union` is built in. Conflicts in these files will just merge both sides' lines in order.

### "Always keep ours" driver

For generated files (lockfiles, schema snapshots) where you'd rather regenerate after the merge:

```gitattributes
# .gitattributes
package-lock.json merge=ours
schema.generated.ts merge=ours
```

```ini
# .git/config
[merge "ours"]
    name = "Always keep ours during merge"
    driver = true
```

(Note: the literal driver name `ours` here is a custom one you define — it's not the built-in `-s ours` strategy.)

### Custom driver — run a script

```ini
# .git/config
[merge "npm-lock"]
    name = "Regenerate package-lock.json after merge"
    driver = "true && npm install --package-lock-only"
```

The `driver` value is a shell command; `%O`, `%A`, `%B` expand to ancestor/ours/theirs file paths if needed.

`.gitattributes` _is_ tracked by Git, so it propagates to collaborators — but the `[merge "name"]` block in `.git/config` is **per-clone**. Document setup steps in your README, or ship the config via a bootstrap script.

## 8a. Conflict-resolution tools and tips

Whatever strategy you pick from section 1, when conflicts do appear these tools speed up resolving them.

### Better conflict markers: `diff3` / `zdiff3`

By default, Git shows two-way conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`). Add the common ancestor as a third column:

```bash
git config --global merge.conflictStyle zdiff3   # Git 2.35+, preferred
git config --global merge.conflictStyle diff3    # older Git
```

Now conflicts show what _both_ sides changed _from_, which usually makes the right resolution obvious:

```
<<<<<<< HEAD
timeout: 30
||||||| merged common ancestors
timeout: 10
=======
timeout: 60
>>>>>>> origin/master
```

`zdiff3` additionally compresses common lines inside the conflict region, producing smaller, more focused markers. It is essentially a free upgrade — turn it on once and forget it.

### Per-file `--ours` / `--theirs`

During an unresolved conflict, you can pick a winner for a specific file without editing it:

```bash
git checkout --ours path/to/file       # keep dev's whole file
git checkout --theirs path/to/file     # take master's whole file
git add path/to/file
```

Or with Git 2.23+:

```bash
git restore --source=HEAD --staged --worktree path/to/file
git restore --source=MERGE_HEAD --staged --worktree path/to/file
```

This is the right escape hatch for binary files or fully-regenerated files; it's a poor choice for source files because it takes the whole file, not just conflicting hunks.

### `git mergetool`

Launches a configured visual merge tool on each unresolved file:

```bash
git mergetool
```

Configure once:

```bash
git config --global merge.tool vimdiff       # or kdiff3, meld, opendiff, vscode, etc.
git config --global mergetool.keepBackup false
```

For VS Code:

```bash
git config --global merge.tool vscode
git config --global mergetool.vscode.cmd 'code --wait $MERGED'
```

### Inspecting what's conflicting

```bash
git status                 # which files have conflicts
git diff --name-only --diff-filter=U   # script-friendly list of unmerged files
git diff                   # combined diff showing conflict regions
git log --merge -p <file>  # commits on each side that touched the file
```

## 9. `git merge --squash` (squash the _incoming_ commits)

```bash
git checkout dev
git merge --squash origin/master
git commit
```

This collapses `master`'s incoming commits into a single set of staged changes on `dev`, which you then record as **one ordinary commit** — there is no merge commit and **no second parent**.

The user explicitly ruled out squashing `dev` itself, but note the asymmetry: `--squash` here squashes the _incoming_ `master` commits, not `dev`. Even so, for this scenario it's the wrong tool:

- It loses `master`'s commit granularity.
- It records **no merge ancestry** (no second parent), so Git never learns that `master`'s commits are integrated — future merges from `master` will re-introduce the same conflicts. Same ancestry problem as cherry-pick (section 4).

When it _is_ legitimate: importing a noisy upstream or vendored change where you genuinely want a single "bumped X to v2" commit and never plan to merge that source again. For keeping `dev` in sync with an active `master`, **avoid it.**

## 10. Previewing a merge before committing

Before running an actual merge, you can see what it would do.

### What commits would come in / go out

```bash
git fetch origin
git log --oneline dev..origin/master       # what master has that dev lacks
git log --oneline origin/master..dev       # what dev has that master lacks
git log --left-right --graph --oneline dev...origin/master   # both, side by side
```

### What files would change

```bash
git diff dev...origin/master               # three-dot: changes on master since the merge base
git diff --stat dev...origin/master        # summary
```

### Find the common ancestor (merge base)

```bash
git merge-base dev origin/master
git merge-base --is-ancestor origin/master dev && echo "already merged"
```

### Trial merge without committing

```bash
git merge --no-commit --no-ff origin/master
# inspect, run tests, then either:
git commit                  # accept
git merge --abort           # discard
```

### Trial merge in a worktree (zero risk to current checkout)

```bash
git worktree add ../learn-merge-test dev
cd ../learn-merge-test
git merge origin/master
# experiment freely; delete when done:
cd -
git worktree remove ../learn-merge-test --force
```

This is the safest way to "see what would happen" when you're nervous about a big merge.

## 11. Aborting and undoing a merge

### Mid-merge (haven't committed yet)

```bash
git merge --abort           # restore pre-merge state, including the working tree
git merge --quit            # stop merging but leave the working tree as-is
git reset --merge           # equivalent to --abort in most cases; also handles --merge-style resets
```

### Just committed locally (not pushed)

```bash
git reset --hard ORIG_HEAD  # ORIG_HEAD is set by merge to the pre-merge tip of the current branch
# or
git reset --hard HEAD~1     # if the merge is the most recent commit
```

`ORIG_HEAD` is set automatically before any operation that moves `HEAD` substantially (merge, rebase, pull, reset), so it's the safest "undo" anchor right after a merge.

### Already pushed / shared

Don't rewrite history. Revert instead:

```bash
git revert -m 1 <merge-commit-sha>
```

`-m 1` says "treat parent 1 (the branch we were on, i.e. `dev`) as the mainline; undo all changes brought in from the other parent (`master`)." `-m 2` would do the opposite.

Caveat: once you revert a merge, you cannot simply re-merge `master` later — Git thinks those commits are already integrated. To re-introduce them you need to either revert the revert (`git revert <revert-sha>`) or cherry-pick the originals. This is the classic "How To Revert A Faulty Merge" gotcha (see `git help revert` and Linus's note on the topic).

### Safety net before any destructive operation

Always create a backup branch first:

```bash
git branch dev-backup-$(date +%Y%m%d)
git rebase origin/master            # or whatever risky operation
# if it goes wrong:
git reset --hard dev-backup-20260519
```

Backup branches are free, take a second to make, and have saved more weekends than `git reflog`. Combine with `git reflog` (which keeps a 90-day log of HEAD movements by default) for a belt-and-braces recovery story.

## 12. `git replay` (Git 2.44+)

A newer plumbing-style command that replays commits from one branch onto another without updating any refs — output is a list of new commit SHAs, which you then move refs to manually.

```bash
git replay --onto origin/master dev~..dev
```

### Pros

- Doesn't touch your working tree or branch refs — safer to experiment with.
- Can replay across multiple branches in one invocation (useful for batch operations).
- No conflict resolution mid-flight — it stops on the first conflict and you handle the whole thing yourself.

### Cons

- Plumbing-level UX; less ergonomic than `rebase` for everyday use.
- Newer, so teammates may not be familiar with the output.

For the scenario in this document, `git replay` is **not** an improvement over `git rebase` + `rerere`. Mentioned for completeness.

## 13. Two-step integration branch workflow

For very high-stakes merges where you want to keep `dev` pristine until you're sure the merge works:

```bash
git checkout -b dev-integration dev
git merge origin/master              # resolve conflicts here
# run full test suite, deploy to staging, etc.

# only when satisfied:
git checkout dev
git merge --ff-only dev-integration  # fast-forward dev onto the verified merge
git branch -d dev-integration
```

### Pros

- `dev` is never in a broken intermediate state visible to others.
- The integration branch can be force-pushed, rewritten, abandoned.
- Easy to open a PR for the merge itself for team review before it lands on `dev`.

### Cons

- An extra branch to manage.
- The merge commit's parent will be `dev-integration`'s state, not directly `dev` — this is normally fine but worth noting if branch naming matters in tooling.

## 14. After the first merge: keeping `dev` in sync as `master` advances

You've merged `origin/master` into `dev` once. A week later `master` has 5 new commits. What now?

### Short answer: merge again.

Run `git merge origin/master` a second time, a third time, every time. Each subsequent merge only has to integrate the _new_ commits since the last merge and only surfaces conflicts caused by those new commits. The work you did in the first merge is permanently recorded in the first merge commit and is not replayed.

### Why this works

After the first merge, the merge base between `dev` and `master` advances to (roughly) `master`'s tip _at the time of that merge_. The next merge diffs only the 5 new commits against whatever `dev` has done since — not the entire history of either branch.

Timeline:

```
              A---B---C---D---E              <- origin/master (5 new commits since M1)
            /         \
  ...---X---Y---M1---Z---W                  <- dev (Z, W added after M1)
```

- `M1` is the first merge. Its second parent is `B`.
- A second `git merge origin/master` introduces only `C`, `D`, `E`.
- You resolve conflicts only where `Z`/`W` collide with `C`/`D`/`E`.

Result:

```
              A---B---C---D---E
            /         \       \
  ...---X---Y---M1---Z---W---M2             <- dev
```

### Do NOT rebase after you've merged

`git rebase origin/master` at this point will:

- Try to replay every commit on `dev` since the original divergence (`Y`, `M1`, `Z`, `W`) onto `master`'s tip.
- Choke on `M1` because rebase drops merge commits by default (and even with `--rebase-merges` the result is fragile).
- Re-surface every conflict you already resolved in `M1`, because those resolutions live _inside_ `M1` and rebase is trying to recreate `Z` and `W` directly on top of `master`.

In other words: the moment you choose "merge", you've committed to merging from then on. Switching to rebase later costs you everything the first merge bought you. This is the single most common way teams end up re-resolving the same conflicts twice.

If you absolutely need a linear `dev` at some later point, keep catching up via merges, then squash-merge or rebase-merge `dev` into `master` when the feature finally lands — by then `dev` collapses to one commit (or one linear sequence) anyway, and the messy intermediate merge commits stay buried in `dev`'s history.

### `rerere` is still helpful, but does less

If you enabled `rerere` (section 5), any conflict pattern that _re-occurs_ in the second merge gets replayed automatically. This is rare for merge-based catch-up — each merge sees genuinely new diffs against the freshly advanced merge base, so the same textual conflict rarely shows up twice. `rerere` shines mostly during rebases, where the same conflict really does keep coming back.

### How often to merge

| Cadence                                   | Trade-off                                                              |
| ----------------------------------------- | ---------------------------------------------------------------------- |
| Daily / after every `master` change       | Tiny merges, almost never conflicts; high routine overhead             |
| Weekly                                    | Sweet spot for most active teams                                       |
| Only before opening a PR back to `master` | Cheap upfront, but the final integration merge becomes the painful one |

Small, frequent merges are cheaper than rare large ones — each one only has to deal with a thin slice of `master`'s changes, and your test suite catches semantic breakage early rather than all at once.

### Checking whether `master` has moved since your last merge

```bash
git fetch origin
git log --oneline HEAD..origin/master              # incoming commits
git rev-list --count HEAD..origin/master           # just the count
git merge-base --is-ancestor origin/master HEAD && echo "already up to date"
```

If the count is 0, you're up to date. If it's small, the merge will be cheap — do it now rather than letting it grow.

### What if I haven't touched `dev` since the last merge?

Then the second merge is a **fast-forward**: `dev` simply moves forward to `master`'s tip with no merge commit. Nothing to resolve. If you'd rather always have an explicit merge commit (so the catch-ups stay visible in `git log --graph`), use `git merge --no-ff origin/master`.

## Recommendation for the scenario

Given:

- `dev` has many commits.
- You want to preserve those commits.
- You want to avoid resolving the same conflict repeatedly.

**Preferred order:**

1. **`git merge origin/master` into `dev`** (section 1). Resolves conflicts once, preserves all history, simple. Accept the merge commit as the cost.
2. If you must keep `dev` linear, enable **`rerere`** (section 5) and then **`git rebase`** (section 2). Resolve each unique conflict once; `rerere` handles the repeats. Be aware of the drawbacks above.
3. If the rebase is genuinely huge and painful, reach for **`git imerge`** (section 7).

In most real teams, **(1) is the right answer** — the merge commit is a small price for a one-shot conflict resolution and a clear ancestry record.

## Quick reference

| Goal                                                          | Command                                                               |
| ------------------------------------------------------------- | --------------------------------------------------------------------- |
| Standard merge                                                | `git merge origin/master`                                             |
| Catch up `dev` after `master` advances again (see section 14) | `git merge origin/master` (again — never rebase after merging)        |
| Check whether `master` has new commits since last merge       | `git log --oneline HEAD..origin/master`                               |
| Merge keeping our side on conflicts                           | `git merge -X ours origin/master`                                     |
| Merge ignoring whitespace noise                               | `git merge -X ignore-space-change origin/master`                      |
| Always create a merge commit (no fast-forward)                | `git merge --no-ff origin/master`                                     |
| Merge a dirty working tree (stash + reapply)                  | `git merge --autostash origin/master`                                 |
| Squash the _incoming_ commits (no merge commit)               | `git merge --squash origin/master`                                    |
| Refuse the merge unless the tip is signed                     | `git merge --verify-signatures origin/master`                         |
| Merge histories with no common ancestor                       | `git merge --allow-unrelated-histories <ref>`                         |
| Linear history, accept many conflicts                         | `git rebase origin/master`                                            |
| Linear history, replay recorded fixes                         | `git config rerere.enabled true` then rebase                          |
| Surgical inclusion                                            | `git cherry-pick <sha>`                                               |
| Smart incremental rebase                                      | `git imerge rebase origin/master`                                     |
| Better conflict markers                                       | `git config --global merge.conflictStyle zdiff3`                      |
| Visual conflict resolution                                    | `git mergetool`                                                       |
| Preview merge without committing                              | `git merge --no-commit --no-ff origin/master`                         |
| Preview in an isolated worktree                               | `git worktree add ../tmp dev && cd ../tmp && git merge origin/master` |
| List incoming commits                                         | `git log --oneline dev..origin/master`                                |
| Abort an in-progress merge/rebase                             | `git merge --abort` / `git rebase --abort` / `git imerge remove`      |
| Undo a local merge commit                                     | `git reset --hard ORIG_HEAD`                                          |
| Undo a pushed merge commit                                    | `git revert -m 1 <merge-sha>`                                         |
| Safety: snapshot before risky ops                             | `git branch dev-backup-$(date +%Y%m%d)`                               |
