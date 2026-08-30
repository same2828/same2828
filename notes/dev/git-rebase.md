# Table of Contents

- [Table of Contents](#table-of-contents)
- [A Comprehensive Guide to `git rebase`](#a-comprehensive-guide-to-git-rebase)
  - [1. The mental model](#1-the-mental-model)
  - [2. Rebase vs. merge](#2-rebase-vs-merge)
  - [3. `ours` and `theirs` - and why rebase swaps them](#3-ours-and-theirs---and-why-rebase-swaps-them)
    - [3.1 In a merge (intuitive)](#31-in-a-merge-intuitive)
    - [3.2 In a rebase (reversed)](#32-in-a-rebase-reversed)
    - [3.3 Why](#33-why)
    - [3.4 The one-line summary](#34-the-one-line-summary)
    - [3.5 Combined reference table](#35-combined-reference-table)
    - [3.6 Never guess - verify at runtime](#36-never-guess---verify-at-runtime)
  - [4. Conflict resolution mechanics](#4-conflict-resolution-mechanics)
    - [4.1 The index has three stages](#41-the-index-has-three-stages)
    - [4.2 Conflict status codes](#42-conflict-status-codes)
    - [4.3 The resolution loop](#43-the-resolution-loop)
    - [4.4 Restoring the conflict markers](#44-restoring-the-conflict-markers)
    - [4.5 `git rerere` - resolve once, reuse forever](#45-git-rerere---resolve-once-reuse-forever)
    - [4.6 Merge tools](#46-merge-tools)
  - [5. Specifying which files to overwrite](#5-specifying-which-files-to-overwrite)
    - [5.1 Per file: `git checkout --ours` / `--theirs`](#51-per-file-git-checkout---ours----theirs)
    - [5.2 Bulk selection by pathspec](#52-bulk-selection-by-pathspec)
    - [5.3 Taking a whole file from a side, conflicted or not](#53-taking-a-whole-file-from-a-side-conflicted-or-not)
    - [5.4 Per hunk, for the whole rebase: `-X ours` / `-X theirs`](#54-per-hunk-for-the-whole-rebase--x-ours---x-theirs)
    - [5.5 Per pattern, permanently: `.gitattributes` merge drivers](#55-per-pattern-permanently-gitattributes-merge-drivers)
    - [5.6 Decision guide](#56-decision-guide)
  - [6. Replaying a `feature` branch onto `master`](#6-replaying-a-feature-branch-onto-master)
    - [6.1 The standard case](#61-the-standard-case)
    - [6.2 `--onto`: the precise form](#62---onto-the-precise-form)
      - [Case A: feature branched off another feature](#case-a-feature-branched-off-another-feature)
      - [Case B: drop the first N commits](#case-b-drop-the-first-n-commits)
      - [Case C: excise a commit from the middle](#case-c-excise-a-commit-from-the-middle)
      - [Case D: the branch point is gone (upstream was itself rebased)](#case-d-the-branch-point-is-gone-upstream-was-itself-rebased)
    - [6.3 `--keep-base`: update the merge base only](#63---keep-base-update-the-merge-base-only)
    - [6.4 Interactive rebase: rebuilding the branch's contents](#64-interactive-rebase-rebuilding-the-branchs-contents)
    - [6.5 Preserving merge commits](#65-preserving-merge-commits)
    - [6.6 Stacked branches: `--update-refs`](#66-stacked-branches---update-refs)
    - [6.7 Validating every commit in the replay](#67-validating-every-commit-in-the-replay)
    - [6.8 Reconstructing a branch when rebase is the wrong tool](#68-reconstructing-a-branch-when-rebase-is-the-wrong-tool)
    - [6.9 Verify the replay was faithful](#69-verify-the-replay-was-faithful)
    - [6.10 Publishing a rebased branch](#610-publishing-a-rebased-branch)
  - [7. `git rebase` and `--`](#7-git-rebase-and---)
    - [7.1 What `--` does in `git rebase`](#71-what----does-in-git-rebase)
    - [7.2 Where `--` genuinely matters during a rebase](#72-where----genuinely-matters-during-a-rebase)
    - [7.3 `--` inside `--exec` commands](#73----inside---exec-commands)
    - [7.4 `--`-prefixed long options: the full rebase surface](#74----prefixed-long-options-the-full-rebase-surface)
  - [8. Recovery, safety, and undo](#8-recovery-safety-and-undo)
    - [8.1 Mid-rebase](#81-mid-rebase)
    - [8.2 After a completed rebase you regret](#82-after-a-completed-rebase-you-regret)
    - [8.3 Prophylaxis](#83-prophylaxis)
    - [8.4 Dirty working tree](#84-dirty-working-tree)
    - [8.5 Recovering _from_ someone else's rebase](#85-recovering-from-someone-elses-rebase)
  - [9. Recommended configuration](#9-recommended-configuration)
  - [10. Quick reference](#10-quick-reference)
    - [`ours` vs `theirs` in `git rebase` and `git merge`](#ours-vs-theirs-in-git-rebase-and-git-merge)
    - [During a conflict](#during-a-conflict)
    - [Replaying onto master](#replaying-onto-master)
    - [The reversal, one more time](#the-reversal-one-more-time)
  - [12. Gotchas](#12-gotchas)

# A Comprehensive Guide to `git rebase`

## 1. The mental model

`git rebase` does **not** move commits. It **replays** them: it takes each commit on your
branch, extracts it as a change, and applies that change on top of a new base, producing
**brand new commits with new SHAs**.

```
Before:                              After `git rebase master`:

      A---B---C  feature                            A'--B'--C'  feature
      /                                             /
D---E---F---G  master                 D---E---F---G  master
```

`A'`, `B'`, `C'` are _new objects_. `A`, `B`, `C` still exist (unreferenced) until garbage
collection. This single fact explains almost everything else in this guide:

- Rebasing rewrites history → never rebase commits others have pulled (the "golden rule").
- New SHAs → you must force-push a rebased branch.
- Author date is preserved; **committer date is reset to now**.
- Each commit is replayed independently → **you can hit the same conflict repeatedly**,
  once per commit.

The core three-step loop:

```bash
git rebase master        # start
# ...conflict...
git add <resolved-files> # mark resolved (NOT `git commit`)
git rebase --continue    # proceed to next commit
```

Escape hatches at any point: `--abort` (restore original state), `--skip` (drop the current
commit), `--quit` (stop rebasing but keep the current HEAD where it is).

## 2. Rebase vs. merge

|                         | `git merge master`                           | `git rebase master`               |
| ----------------------- | -------------------------------------------- | --------------------------------- |
| History shape           | Preserves branch topology, adds merge commit | Linear, no merge commit           |
| Commit identity         | Original commits untouched                   | Commits rewritten (new SHAs)      |
| Conflict frequency      | Resolved **once**, for the whole branch      | Potentially **once per commit**   |
| Safe on shared branches | Yes                                          | No                                |
| Force-push needed       | No                                           | Yes                               |
| Bisectability           | Merge commits can obscure regressions        | Clean linear history bisects well |
| `ours` / `theirs`       | Intuitive                                    | **Reversed** (see §3)             |

**Rule of thumb:** rebase _your own_ unpublished work to keep it current and tidy; merge
when integrating shared branches or when the branch has already been reviewed/published.

## 3. `ours` and `theirs` - and why rebase swaps them

### 3.1 In a merge (intuitive)

```bash
git switch feature
git merge master
```

- **`ours`** = `HEAD` = **`feature`** - the branch you are standing on.
- **`theirs`** = **`master`** - the branch being merged in.

"Ours is mine" holds. Everyone's intuition is satisfied.

### 3.2 In a rebase (reversed)

```bash
git switch feature
git rebase master
```

- **`ours`** = **`master`** (the new base, plus any of your commits already replayed).
- **`theirs`** = **your `feature` commit currently being replayed**.

Straight from `git help rebase`:

> Note that a rebase merge works by replaying each commit from the working branch on top of
> the `<upstream>` branch. Because of this, when a merge conflict happens, the side reported
> as **ours** is the so-far rebased series, starting with `<upstream>`, and **theirs** is the
> working branch. **In other words, the sides are swapped.**

### 3.3 Why

Rebase is implemented as a sequence of cherry-picks. Git first checks out the new base
(`master`) - so `HEAD` _is_ `master` - then cherry-picks each of your commits onto it. In a
cherry-pick, `ours` is always `HEAD` and `theirs` is the commit being applied. Nothing is
inconsistent; git's definition ("ours = HEAD") never changes. What changes is that during a
rebase **`HEAD` is not your branch**.

### 3.4 The one-line summary

> **During a rebase, `theirs` is _your_ work.**

Empirically confirmed - rebasing `feature` (containing the line `feat`) onto `master`
(containing the line `master`):

```console
$ git ls-files -u
100644 7898192... 1    f.txt      # stage 1 = common ancestor
100644 2f22499... 2    f.txt      # stage 2 = "ours"
100644 dc04ba8... 3    f.txt      # stage 3 = "theirs"

$ git show :2:f.txt     # ours
a
master                  # <- upstream / master

$ git show :3:f.txt     # theirs
a
feat                    # <- MY feature commit

$ git log -1 --format='%h %s' REBASE_HEAD
12245af feat            # <- the commit being replayed = "theirs"

$ git log -1 --format='%h %s' HEAD
fa055cb master          # <- the rebased-so-far tip = "ours"
```

### 3.5 Combined reference table

| Operation                              | `HEAD` during conflict | `ours` (stage 2)  | `theirs` (stage 3)    |
| -------------------------------------- | ---------------------- | ----------------- | --------------------- |
| `git merge X` (on `feature`)           | `feature`              | `feature` (yours) | `X`                   |
| `git cherry-pick X` (on `feature`)     | `feature`              | `feature` (yours) | `X`                   |
| `git revert X` (on `feature`)          | `feature`              | `feature` (yours) | reverse of `X`        |
| **`git rebase master`** (on `feature`) | `master` + replayed    | **`master`**      | **`feature` (yours)** |
| `git rebase --onto A B feature`        | `A` + replayed         | **`A`**           | **`feature` (yours)** |
| `git stash pop`                        | working tree           | working tree      | stashed changes       |

### 3.6 Never guess - verify at runtime

Two reliable, zero-ambiguity checks while stopped mid-rebase:

```bash
git log -1 --oneline REBASE_HEAD   # the commit being replayed == "theirs"
git log -1 --oneline HEAD          # the base being replayed onto == "ours"
```

Or make the conflict markers label themselves:

```bash
git config --global merge.conflictStyle zdiff3   # git >= 2.35 (else: diff3)
```

With `zdiff3` you get a three-way marker showing the common ancestor, which makes the
direction obvious without any memorising:

```diff
<<<<<<< HEAD                      # ours = master (the new base)
timeout = 30
||||||| parent of 12245af (feat)  # the common ancestor
timeout = 10
=======
timeout = 60
>>>>>>> 12245af (feat)            # theirs = YOUR commit
```

Note the label after `>>>>>>>` is the actual commit subject - that alone tells you which
side is yours.

## 4. Conflict resolution mechanics

### 4.1 The index has three stages

When a path conflicts, git stores three versions in the index instead of one:

| Stage | Meaning                | Access             |
| ----- | ---------------------- | ------------------ |
| 1     | Common ancestor (base) | `git show :1:path` |
| 2     | `ours`                 | `git show :2:path` |
| 3     | `theirs`               | `git show :3:path` |

Useful inspection commands:

```bash
git status --short                          # UU / AA / DU / UD markers
git diff --name-only --diff-filter=U        # just the conflicted paths
git ls-files -u                             # raw stage entries
git diff                                    # combined diff of conflicts
git diff --ours                             # working tree vs. ours
git diff --theirs                           # working tree vs. theirs
git diff --base                             # working tree vs. ancestor
git log --merge -p -- path                  # commits touching the conflict
git rebase --show-current-patch             # full patch of the stuck commit
```

### 4.2 Conflict status codes

| Code | Meaning                                           |
| ---- | ------------------------------------------------- |
| `UU` | both modified                                     |
| `AA` | both added                                        |
| `AU` | added by us (upstream), deleted-ish on their side |
| `UA` | added by them (your commit)                       |
| `DU` | deleted by us (upstream), modified by you         |
| `UD` | modified by us (upstream), deleted by you         |

`DU`/`UD` are common when upstream deleted or renamed a file your commit touches. Resolve
with `git rm <file>` (accept the deletion) or `git add <file>` (keep it).

### 4.3 The resolution loop

```bash
git rebase master
# conflict on commit 2 of 5
$EDITOR conflicted-file            # or use --ours/--theirs, see §5
git add conflicted-file            # stage 2/3 collapse into stage 0 = resolved
git rebase --continue              # git opens the commit message editor
```

Key points:

- **Do not `git commit`** during a rebase. `git add` + `git rebase --continue` is the
  contract. (`git commit` works but bypasses the sequencer's message/authorship handling.)
- `git rebase --continue` refuses to proceed while unmerged paths remain.
- If your resolution ends up making the commit a **no-op** (e.g. you took `ours` entirely),
  git tells you the commit is now empty; use `git rebase --skip` to drop it.
- Use `git rebase --continue --no-edit`? Not a thing - instead set
  `GIT_EDITOR=true git rebase --continue` to accept the message unchanged.

### 4.4 Restoring the conflict markers

Overwrote or mangled a conflicted file and want to start that file over?

```bash
git checkout --merge -- path      # regenerate conflict markers from the index
git checkout --conflict=zdiff3 -- path   # regenerate with ancestor context
```

### 4.5 `git rerere` - resolve once, reuse forever

The single highest-leverage setting for anyone who rebases long-lived branches. It records
your conflict resolutions and replays them automatically when the _same_ conflict recurs -
which happens constantly during rebases (once per commit) and across repeated rebases of
the same branch.

```bash
git config --global rerere.enabled true
git config --global rerere.autoUpdate true   # also stage the reused resolution
```

Management:

```bash
git rerere status     # paths rerere is tracking in the current conflict
git rerere diff       # what rerere would apply
git rerere forget <path>   # discard a bad recorded resolution
```

### 4.6 Merge tools

```bash
git mergetool                        # launch configured tool on all conflicts
git mergetool -- path                # just one path
git mergetool --tool=vimdiff
git config --global merge.tool <name>
```

Git passes these environment variables to the tool - **these are the real, documented
variables** (see §7):

| Variable  | Contents                                            |
| --------- | --------------------------------------------------- |
| `$BASE`   | temp file with stage 1 (common ancestor)            |
| `$LOCAL`  | temp file with stage 2 (**`ours`**)                 |
| `$REMOTE` | temp file with stage 3 (**`theirs`**)               |
| `$MERGED` | the path in the working tree to write the result to |
| `$BACKUP` | `.orig` backup file                                 |

During a rebase, `$LOCAL` is upstream and `$REMOTE` is **your commit**. Most GUI merge tools
label the `$LOCAL` pane "Local"/"Mine" - which is _wrong_ during a rebase. Trust the
variable semantics, not the pane label.

## 5. Specifying which files to overwrite

There are four levels at which you can declare a winner: whole-rebase, per-file,
per-hunk, and per-pattern.

### 5.1 Per file: `git checkout --ours` / `--theirs`

This takes the entire stage-2 or stage-3 blob and writes it to the working tree, discarding
any attempted merge.

```bash
# Keep upstream/master's version of the file entirely:
git checkout --ours -- path/to/file
git add path/to/file

# Keep MY feature commit's version of the file entirely:
git checkout --theirs -- path/to/file
git add path/to/file
```

`git restore` (git ≥ 2.23) is the modern equivalent:

```bash
git restore --ours   --worktree -- path/to/file
git restore --theirs --worktree -- path/to/file
```

> ⚠️ Remember the reversal: in a rebase, `--theirs` = **your** work, `--ours` = **master**.
> This is the #1 source of accidentally-destroyed work during rebases.

### 5.2 Bulk selection by pathspec

`--ours`/`--theirs` accept pathspecs and **quietly skip non-conflicted paths**, so broad
patterns are safe (verified):

```bash
git checkout --ours   -- .                      # all conflicts -> master wins
git checkout --theirs -- .                      # all conflicts -> my commit wins
git checkout --theirs -- 'src/**/*.ts'          # only my TS changes
git checkout --ours   -- 'package-lock.json' 'yarn.lock'
git add -A
```

Driven off the actual conflict list (handles spaces/unicode correctly):

```bash
git diff --name-only --diff-filter=U -z | xargs -0 git checkout --theirs --
git diff --name-only --diff-filter=U -z | xargs -0 git add
```

Mixed policy in one pass - a very common real-world shape:

```bash
git checkout --ours   -- db/schema.rb Gemfile.lock   # generated: take upstream
git checkout --theirs -- app/ lib/                    # my source: take mine
$EDITOR config/routes.rb                              # hand-merge the rest
git add -A && git rebase --continue
```

### 5.3 Taking a whole file from a side, conflicted or not

`--ours`/`--theirs` only work on paths that are _actually conflicted_ (they read index
stages). To pull a file from a side regardless of conflict state, name the commit:

```bash
git checkout REBASE_HEAD -- path   # exactly as it is in MY commit being replayed
git checkout HEAD        -- path   # exactly as it is on the rebased base (master side)
git checkout master      -- path   # exactly as it is on master
git rm path                        # resolve by deleting
```

`REBASE_HEAD` (git ≥ 2.12) is set for the duration of a stopped rebase and always points at
the commit being replayed. Verified: `git checkout REBASE_HEAD -- f.txt` yields the feature
version even when `--theirs` would be unavailable.

### 5.4 Per hunk, for the whole rebase: `-X ours` / `-X theirs`

`-X` (`--strategy-option`) is passed to the merge strategy (`ort`) and applies to **every**
commit in the rebase. Crucially, it is **not** the same as `git checkout --ours`:

|             | `git checkout --ours file`                                         | `git rebase -X ours`                                                                  |
| ----------- | ------------------------------------------------------------------ | ------------------------------------------------------------------------------------- |
| Scope       | One file, one conflict                                             | Every conflict in the whole rebase                                                    |
| Granularity | **Whole file** - the other side's non-conflicting changes are lost | **Conflicting hunks only** - non-conflicting changes from both sides are still merged |
| Applies to  | The current stop only                                              | Automatically, silently, throughout                                                   |

```bash
git rebase -X theirs master   # every conflicting hunk resolves to MY feature commits
git rebase -X ours   master   # every conflicting hunk resolves to master
```

Verified end-to-end: with `master` holding `master` and `feature` holding `feat` on the same
line, `git rebase -X theirs master` produces `feat`, and `-X ours` produces `master`.

Other useful `-X` options:

```bash
git rebase -X ignore-space-change master   # reindentation-only conflicts
git rebase -X renormalize master           # CRLF/LF line-ending churn
git rebase -X find-renames=40% master      # more aggressive rename detection
git rebase -X patience master              # better diffs on reordered blocks
```

> ⚠️ `-X ours`/`-X theirs` resolve conflicts **silently**. You get no notification that a
> real semantic conflict was steamrolled. Always run the test suite afterwards, and prefer
> `--exec` (§6.7) to enforce it. There is no `-s theirs` merge _strategy_ - only `-s ours`,
> which is a merge-only strategy and is not meaningful for rebase.

### 5.5 Per pattern, permanently: `.gitattributes` merge drivers

For files that should _always_ resolve the same way (lockfiles, generated code, changelogs),
declare it once rather than deciding on every rebase.

`.git/config` or `~/.gitconfig`:

```ini
[merge "keep-ours"]
    name = always keep the ours side
    driver = true                      ; `true` exits 0, leaving %A untouched
[merge "keep-theirs"]
    name = always keep the theirs side
    driver = cp -f %B %A
```

`.gitattributes`:

```gitattributes
package-lock.json   merge=keep-ours
db/schema.rb        merge=keep-ours
CHANGELOG.md        merge=union        # built-in: concatenate both sides
*.png               binary
*.generated.go      merge=keep-theirs
```

Custom merge driver placeholders:

| Token | Meaning                                                                    |
| ----- | -------------------------------------------------------------------------- |
| `%O`  | temp file: ancestor version                                                |
| `%A`  | temp file: **ours** - _and the file the driver must write its result into_ |
| `%B`  | temp file: **theirs**                                                      |
| `%L`  | conflict-marker size                                                       |
| `%P`  | the real pathname in the worktree                                          |

The **built-in** merge drivers are only `text`, `binary`, and `union` - `ours` is _not_
built in, so you must define it in config as shown above.

> ⚠️ The ours/theirs reversal applies here too. During a rebase, a `merge=keep-ours` driver
> keeps the **upstream** version, not yours.

### 5.6 Decision guide

| Situation                                       | Use                                     |
| ----------------------------------------------- | --------------------------------------- |
| One file, want it wholesale from one side       | `git checkout --ours\|--theirs -- file` |
| Want a file exactly as in my replayed commit    | `git checkout REBASE_HEAD -- file`      |
| Every conflict should go one way                | `git rebase -X ours\|theirs master`     |
| Whitespace/indentation-only conflicts           | `git rebase -X ignore-space-change`     |
| Same conflict keeps recurring across commits    | `rerere.enabled=true`                   |
| A specific file should _always_ resolve one way | `.gitattributes` merge driver           |
| Genuine semantic conflict                       | Edit by hand, then `git add`            |

## 6. Replaying a `feature` branch onto `master`

### 6.1 The standard case

`feature` branched off `master`; `master` has moved on.

```
      A---B---C  feature              →                A'--B'--C'  feature
      /                                                /
D---E---F---G  master                     D---E---F---G  master
```

```bash
git switch feature
git fetch origin
git rebase origin/master
```

Or in one shot, without switching first - the two-argument form checks out `<branch>` for
you before rebasing:

```bash
git rebase origin/master feature      # == git switch feature && git rebase origin/master
```

Then publish:

```bash
git push --force-with-lease --force-if-includes
```

### 6.2 `--onto`: the precise form

The full signature is:

```bash
git rebase --onto <newbase> <upstream> [<branch>]
```

Read it as: **take the commits in `<upstream>..<branch>` and replay them onto `<newbase>`.**

`<upstream>` is the _exclusive lower bound_ - it says "everything after this point", not
"where to put it". Preview exactly what will move before you run it:

```bash
git log --oneline <upstream>..<branch>
```

#### Case A: feature branched off another feature

```
D---E---F---G  master
      \
      H---I  other-feature
            \
            A---B---C  feature
```

Move only `A B C` onto `master`, leaving `H I` behind:

```bash
git rebase --onto master other-feature feature
```

Result:

```
D---E---F---G  master
      |        \
      |         A'--B'--C'  feature
      \
        H---I  other-feature
```

Plain `git rebase master feature` here would drag `H` and `I` along too.

#### Case B: drop the first N commits

```bash
git rebase --onto master feature~3 feature   # replay only the last 3 commits
```

#### Case C: excise a commit from the middle

```bash
git rebase --onto bad-commit~1 bad-commit feature
```

(Or use `git rebase -i` and delete the line - usually clearer.)

#### Case D: the branch point is gone (upstream was itself rebased)

Classic symptom: you branched off `master`, someone force-pushed a rewritten `master`, and
now a plain rebase replays hundreds of already-applied commits and conflicts endlessly.

```bash
# Find your true fork point using the reflog of master:
git merge-base --fork-point origin/master feature

# Then replay only your own commits onto the new master:
git rebase --onto origin/master $(git merge-base --fork-point origin/master feature) feature
```

If the reflog has expired, count your own commits explicitly:

```bash
git log --oneline --author="$(git config user.email)" origin/master..feature
git rebase --onto origin/master feature~5 feature
```

Git also handles many of these automatically: `--reapply-cherry-picks` /
`--no-reapply-cherry-picks` control whether commits already present upstream (by patch-id)
are dropped. The merge backend drops them by default.

### 6.3 `--keep-base`: update the merge base only

```bash
git rebase --keep-base master
```

Replays your commits onto the _original_ merge base rather than onto the tip of `master`.
This cleans up your branch (reword, squash, drop) **without** pulling in new upstream commits

- so review diffs stay stable and you avoid conflicts with unrelated upstream work.

Equivalent to `git rebase --onto $(git merge-base master HEAD) $(git merge-base master HEAD)`.

### 6.4 Interactive rebase: rebuilding the branch's contents

```bash
git rebase -i master              # edit all commits since diverging from master
git rebase -i --root              # including the very first commit
git rebase -i HEAD~5              # last 5 commits, no rebasing onto anything new
```

The todo list:

| Command                     | Short | Effect                                    |
| --------------------------- | ----- | ----------------------------------------- |
| `pick`                      | `p`   | use the commit as-is                      |
| `reword`                    | `r`   | use the commit, edit its message          |
| `edit`                      | `e`   | stop after applying, to amend the content |
| `squash`                    | `s`   | meld into previous, combine messages      |
| `fixup`                     | `f`   | meld into previous, discard this message  |
| `fixup -C`                  |       | meld into previous, keep _this_ message   |
| `drop`                      | `d`   | remove the commit                         |
| `exec`                      | `x`   | run a shell command at this point         |
| `break`                     | `b`   | stop here (like a breakpoint)             |
| `label` / `reset` / `merge` |       | topology control with `--rebase-merges`   |

Reordering lines reorders commits. Deleting a line drops the commit.

Autosquash workflow - the cleanest way to fix review comments:

```bash
git commit --fixup=<sha>            # or --squash=<sha>
git commit --fixup=amend:<sha>      # fixup that also rewrites the message
git rebase -i --autosquash master   # fixups auto-positioned and pre-marked
git config --global rebase.autoSquash true   # make it the default
```

### 6.5 Preserving merge commits

Default rebase flattens merges away. To keep the topology:

```bash
git rebase --rebase-merges master
git rebase --rebase-merges=rebase-cousins master   # also move non-descendants
```

### 6.6 Stacked branches: `--update-refs`

If `feature-b` is stacked on `feature-a`, rebasing `feature-a` normally strands `feature-b`
on the old commits. Git ≥ 2.38:

```bash
git rebase --update-refs master
git config --global rebase.updateRefs true
```

All branch refs pointing into the rebased range are moved to the corresponding new commits.

### 6.7 Validating every commit in the replay

Rebasing can produce intermediate commits that don't build, which breaks `git bisect` later.

```bash
git rebase --exec 'npm test' master
git rebase --exec 'cargo build && cargo test' master
git rebase -i --exec 'make -j8' master
```

Rebase stops at the first commit where the command exits non-zero, letting you fix it in
place (`git commit --amend`, then `git rebase --continue`).

### 6.8 Reconstructing a branch when rebase is the wrong tool

Sometimes replaying commit-by-commit is more pain than it's worth. Alternatives:

**Squash-rebuild** - collapse everything into one clean commit on a fresh base:

```bash
git switch -c feature-new master
git merge --squash feature
git commit -m "Feature X"
```

**Cherry-pick a range** - full control, and unlike rebase your original branch is untouched:

```bash
git switch -c feature-new master
git cherry-pick A^..C        # inclusive of A through C
git cherry-pick --strategy-option=theirs A^..C
```

Note the reversal flips back here: in a cherry-pick, `theirs` is the picked commit (still
"your feature work", conveniently), and `ours` is the branch you're on.

**Patch export/import** - survives history that's too tangled to replay:

```bash
git format-patch master..feature -o /tmp/patches
git switch -c feature-new master
git am --3way /tmp/patches/*.patch
git am --show-current-patch=diff    # inspect a failure
git am --skip / --abort / --continue
```

**Diff-and-apply** - a single flat reconstruction of the net change:

```bash
git diff master...feature > /tmp/feature.patch   # note the THREE dots
git switch -c feature-new master
git apply --3way /tmp/feature.patch
```

`master...feature` (three dots) diffs from the merge base - i.e. only _your_ changes.
`master..feature` (two dots) in `git diff` means the same as `master feature`, which
includes the inverse of upstream's changes. Getting this wrong is a classic footgun.

### 6.9 Verify the replay was faithful

After any rebase or reconstruction, confirm you changed only what you intended:

```bash
git range-diff master ORIG_HEAD HEAD        # diff-of-diffs, old series vs new
git range-diff @{u}...HEAD                  # shorthand form
git diff ORIG_HEAD HEAD                     # net tree difference; should often be empty
```

`git range-diff` is the definitive check: it pairs up old and new commits and shows exactly
how each patch changed during the replay. If a rebase was purely mechanical, every pair
should show `=`.

### 6.10 Publishing a rebased branch

```bash
git push --force-with-lease --force-if-includes origin feature
```

- `--force` - overwrites the remote unconditionally. Can silently destroy a colleague's push.
- `--force-with-lease` - refuses if the remote moved since your last fetch.
- `--force-if-includes` (git ≥ 2.30) - additionally requires that your local branch actually
  incorporates whatever you last fetched, closing the hole where a background `git fetch`
  refreshes the lease behind your back.

Use the last two together. Consider aliasing it:

```bash
git config --global alias.pushf 'push --force-with-lease --force-if-includes'
```

## 7. `git rebase` and `--`

In git generally, a bare `--` is the **end-of-options / disambiguation separator**. Its exact
role depends on the command, and `git rebase` is a special case worth stating precisely.

### 7.1 What `--` does in `git rebase`

`git rebase` is a `parse_options`-based builtin, so `--` **terminates option parsing only**.
Everything after it is still parsed as the positional arguments `[<upstream> [<branch>]]`.

**`git rebase` accepts no pathspec.** Verified:

```console
$ git rebase -- master
Rebasing (1/1)
Auto-merging f.txt
CONFLICT (content): Merge conflict in f.txt        # <- worked: `master` taken as <upstream>

$ git rebase master -- f.txt
fatal: no such branch/commit 'f.txt'               # <- NOT a pathspec; parsed as a revision
```

So `--` in `git rebase` has exactly one legitimate use: forcing a branch name that starts
with a dash, or one that would otherwise be mistaken for an option, to be read as a revision.

```bash
git rebase -- -weird-branch-name
git rebase --onto master -- --my-odd-branch
```

**You cannot rebase "just some files."** Rebase operates on whole commits. If you want to
replay only part of a commit's changes, use `git rebase -i` with `edit`, or
`git checkout <commit> -- <paths>`.

### 7.2 Where `--` genuinely matters during a rebase

The commands you run _while stopped_ in a rebase do take pathspecs, and `--` is what
separates revisions from paths:

```bash
git checkout --ours   -- src/config.ts     # `--ours` is a flag; `--` starts the pathspec
git checkout --theirs -- src/config.ts
git checkout REBASE_HEAD -- src/config.ts  # `REBASE_HEAD` is a rev, `src/...` is a path
git restore --theirs --worktree -- src/
git diff --name-only --diff-filter=U -- src/
git mergetool -- src/config.ts
```

This is not pedantry - it is a genuine correctness issue whenever a ref and a path share a
name. If you have both a branch called `config` and a file called `config`:

```bash
git checkout config          # AMBIGUOUS -> git errors, or picks the branch
git checkout -- config       # unambiguously: restore the FILE
git checkout config --       # unambiguously: switch to the BRANCH
```

The rule is universal: **`<revisions> -- <paths>`**.

### 7.3 `--` inside `--exec` commands

`--exec` takes a shell string, so any `--` inside it belongs to _your_ command, not to git:

```bash
git rebase --exec 'npm test -- --coverage' master
git rebase --exec 'cargo test -- --nocapture' master
git rebase --exec 'git diff --check HEAD^ -- .' master
```

Quote the whole thing so your shell doesn't split it before git sees it.

### 7.4 `--`-prefixed long options: the full rebase surface

The other reading of "`git rebase` with `--`" is simply its long options. Complete practical
list:

**Control flow**

| Option                 | Effect                                              |
| ---------------------- | --------------------------------------------------- |
| `--continue`           | Resume after resolving conflicts                    |
| `--abort`              | Abandon; restore the original branch and HEAD       |
| `--quit`               | Stop the rebase but keep HEAD where it currently is |
| `--skip`               | Drop the current commit and continue                |
| `--edit-todo`          | Edit the remaining todo list (interactive)          |
| `--show-current-patch` | Show the commit that is currently stuck             |

**Selecting what to replay**

| Option                                | Effect                                            |
| ------------------------------------- | ------------------------------------------------- |
| `--onto <newbase>`                    | Explicit destination (§6.2)                       |
| `--keep-base`                         | Replay onto the original merge base (§6.3)        |
| `--root`                              | Include the very first commit                     |
| `--fork-point` / `--no-fork-point`    | Use `master`'s reflog to find the real fork point |
| `--reapply-cherry-picks` / `--no-...` | Keep/drop commits already upstream by patch-id    |
| `--empty=drop\|keep\|stop`            | Policy for commits that become empty              |

**Conflict and merge behaviour**

| Option                        | Effect                                                    |
| ----------------------------- | --------------------------------------------------------- |
| `-m`, `--merge`               | Use the merge backend (default)                           |
| `-s`, `--strategy=<s>`        | Merge strategy (default `ort`)                            |
| `-X`, `--strategy-option=<o>` | `ours`, `theirs`, `ignore-space-change`, `renormalize`, … |
| `--rerere-autoupdate`         | Auto-stage rerere-reused resolutions                      |

**History shaping**

| Option                                  | Effect                                      |
| --------------------------------------- | ------------------------------------------- |
| `-i`, `--interactive`                   | Edit the todo list                          |
| `--autosquash` / `--no-autosquash`      | Reposition `fixup!`/`squash!` commits       |
| `--rebase-merges[=rebase-cousins]`      | Preserve merge topology                     |
| `--update-refs`                         | Move stacked branch refs along (git ≥ 2.38) |
| `--exec <cmd>`                          | Run `<cmd>` after each commit               |
| `--signoff`                             | Add `Signed-off-by:`                        |
| `-S[<keyid>]`, `--gpg-sign`             | GPG-sign the new commits                    |
| `--committer-date-is-author-date`       | Keep dates stable across the rewrite        |
| `--ignore-date` / `--reset-author-date` | Reset author dates to now                   |

**Convenience**

| Option                                           | Effect                                                               |
| ------------------------------------------------ | -------------------------------------------------------------------- |
| `--autostash` / `--no-autostash`                 | Stash and restore dirty worktree around the rebase                   |
| `--quiet` / `--verbose` / `--stat` / `--no-stat` | Output verbosity                                                     |
| `--dry-run`                                      | Not supported - use `git log --oneline <upstream>..<branch>` instead |

## 8. Recovery, safety, and undo

Rebasing is reversible. Nothing is deleted until `git gc` runs (default: unreachable objects
survive ~2 weeks).

### 8.1 Mid-rebase

```bash
git rebase --abort        # cleanest: full restore of the pre-rebase state
```

### 8.2 After a completed rebase you regret

```bash
git reset --hard ORIG_HEAD           # ORIG_HEAD is set by rebase to the old tip
```

If `ORIG_HEAD` has since been overwritten by another operation, use the reflog:

```bash
git reflog show feature
# feature@{0} rebase (finish): returning to refs/heads/feature
# feature@{1} rebase (pick): Add widget
# feature@{5} commit: Add widget          <- the pre-rebase tip
git reset --hard feature@{5}
# or: git branch feature-backup feature@{5}   (safer: keep both)
```

Reflog-based recovery for the whole repo:

```bash
git reflog                                   # HEAD's movement history
git reflog --date=iso                        # with timestamps
git fsck --lost-found --no-reflogs           # dangling commits if reflog is gone
```

### 8.3 Prophylaxis

```bash
git branch backup/feature-$(date +%Y%m%d)    # free, instant, zero-risk
git rebase master
# verify, then:
git branch -D backup/feature-20260827
```

For anything long or scary, this beats every recovery technique.

### 8.4 Dirty working tree

```bash
git rebase --autostash master
git config --global rebase.autoStash true
```

Note: if the autostash fails to reapply (because the rebase changed the same lines), git
leaves it in the stash - recover with `git stash list` / `git stash pop`.

### 8.5 Recovering _from_ someone else's rebase

Upstream force-pushed and your branch is now built on orphaned commits:

```bash
git fetch origin
git rebase --onto origin/master origin/master@{1} feature
```

`origin/master@{1}` is the remote-tracking ref's _previous_ value - i.e. the old base your
work sits on. This replays only your commits onto the new upstream. `--fork-point` (default
when `<upstream>` is a tracking branch and no `--onto` is given) automates the common form.

## 9. Recommended configuration

```bash
# Reuse conflict resolutions -- biggest single quality-of-life win
git config --global rerere.enabled true
git config --global rerere.autoUpdate true

# Show the common ancestor in conflict markers; makes ours/theirs self-evident
git config --global merge.conflictStyle zdiff3        # git >= 2.35, else diff3

# Rebase instead of merge on pull, but never silently rebase a dirty tree
git config --global pull.rebase true
git config --global rebase.autoStash true

# Auto-position fixup!/squash! commits
git config --global rebase.autoSquash true

# Keep stacked branches in sync (git >= 2.38)
git config --global rebase.updateRefs true

# Safer force-push
git config --global push.default simple
git config --global alias.pushf 'push --force-with-lease --force-if-includes'

# Handy aliases
git config --global alias.rc 'rebase --continue'
git config --global alias.ra 'rebase --abort'
git config --global alias.rs 'rebase --skip'
git config --global alias.conflicts 'diff --name-only --diff-filter=U'
git config --global alias.ours   'checkout --ours --'
git config --global alias.theirs 'checkout --theirs --'
```

## 10. Quick reference

### `ours` vs `theirs` in `git rebase` and `git merge`

| Context                                   | `ours` / `-X ours` | `theirs` / `-X theirs` |
| ----------------------------------------- | ------------------ | ---------------------- |
| `git merge origin/master` (on `feature`)  | feature            | master                 |
| `git rebase origin/master` (on `feature`) | master             | feature                |

### During a conflict

```bash
git status --short                        # what's conflicted
git diff --name-only --diff-filter=U      # conflicted paths only
git log -1 --oneline REBASE_HEAD          # which commit is being replayed = "theirs"
git log -1 --oneline HEAD                 # what it's landing on = "ours"
git show :1:file  :2:file  :3:file        # base / ours / theirs
git rebase --show-current-patch           # the full stuck patch

git checkout --ours   -- file && git add file   # take MASTER's version
git checkout --theirs -- file && git add file   # take MY version
git checkout REBASE_HEAD -- file && git add file # take MY version (always works)
git checkout --merge  -- file                    # restore conflict markers
git rm file                                      # resolve as deleted

git rebase --continue | --skip | --abort | --quit
```

### Replaying onto master

```bash
git rebase master                                  # standard
git rebase master feature                          # without switching first
git rebase --onto master other-feature feature     # only my commits
git rebase --onto master feature~3 feature         # only the last 3
git rebase --keep-base master                      # tidy up, don't pull upstream in
git rebase -i --autosquash master                  # interactive + fixups
git rebase --exec 'make test' master               # validate each commit
git rebase --rebase-merges master                  # keep merge topology
git rebase --update-refs master                    # move stacked branches too
git rebase -X theirs master                        # my side wins every conflict
git range-diff master ORIG_HEAD HEAD               # verify the replay
git push --force-with-lease --force-if-includes    # publish
```

### The reversal, one more time

```
merge:   ours = HEAD = my branch        theirs = the other branch
rebase:  ours = master (new base)       theirs = MY commit
                └── the surprising one ──┘
```

## 12. Gotchas

1. **The reversal will bite you.** `git checkout --theirs` during a rebase keeps _your_
   work. Before running it on anything important, confirm with
   `git log -1 --oneline REBASE_HEAD`.

2. **`-X ours` ≠ `git checkout --ours`.** The first resolves conflicting _hunks_ across the
   whole rebase; the second replaces a _whole file_ once. They frequently produce different
   results.

3. **The same conflict, N times.** Rebase replays commit-by-commit, so a conflict in a
   long-lived file recurs for each commit that touches it. Enable `rerere`.

4. **Never `git commit` mid-rebase.** Use `git add` + `git rebase --continue`.

5. **`--ours`/`--theirs` only work on conflicted paths.** For anything else use
   `git checkout <commit> -- <path>`.

6. **`git rebase` takes no pathspec.** `git rebase master -- file.txt` fails with
   `fatal: no such branch/commit 'file.txt'`.

7. **Three dots vs. two in `git diff`.** `git diff master...feature` = only your changes
   (from the merge base). `git diff master..feature` = includes the inverse of upstream's
   changes. For `git log` and `git rebase --onto`, `..` and `...` mean something different
   again - always sanity-check with `git log --oneline <range>`.

8. **`git pull` after a rebase re-merges your old commits.** Once you have rebased, the
   remote and local branches have diverged; `git pull` (merge) will resurrect the pre-rebase
   commits. Force-push instead, or set `pull.rebase true`.

9. **Force-pushing a shared branch.** Use `--force-with-lease --force-if-includes`, and tell
   whoever else is on the branch. Their recovery is `git rebase --onto origin/feature
origin/feature@{1} their-work`.

10. **`-X ours`/`-X theirs` resolve silently.** A steamrolled semantic conflict compiles
    fine and fails in production. Pair with `--exec 'make test'`.

11. **Committer dates change; author dates don't.** Tooling that sorts by commit date will
    see a rebased branch as brand new. `--committer-date-is-author-date` preserves the
    original ordering if that matters.

12. **Rebasing a branch that others have merged from** creates duplicate commits in the
    history and confuses everyone. This is the golden rule for a reason.

13. **Empty commits.** If upstream already contains your change, the replay produces an
    empty commit. The merge backend drops these by default; control it with `--empty=` and
    `--no-reapply-cherry-picks`.

14. **Submodules are not rebased.** A rebase updates the recorded submodule SHA like any
    other file; the submodule's own working tree is untouched. Run `git submodule update`
    afterwards.

15. **`git rebase --quit` is not `--abort`.** `--quit` leaves you on a partially-rebased
    HEAD with the branch ref possibly unmoved. Use `--abort` unless you specifically want to
    keep the intermediate state.
