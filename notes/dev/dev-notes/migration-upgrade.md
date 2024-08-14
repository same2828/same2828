# Table of Contents

- [Table of Contents](#table-of-contents)
- [Methodology/Steps](#methodologysteps)
  - [1. Remove All UNNECESSARY Dependencies](#1-remove-all-unnecessary-dependencies)
  - [2. Upgrade All Dependencies to LAST Minor/Patch version for LAST Major version](#2-upgrade-all-dependencies-to-last-minorpatch-version-for-last-major-version)
  - [3. Upgrade to NEXT Major version to Fix Vulnerabilities](#3-upgrade-to-next-major-version-to-fix-vulnerabilities)

# Methodology/Steps

## 1. Remove All UNNECESSARY Dependencies

Use "trial and error" to determine which dependencies are NOT needed

Steps:

1. Comment out/delete dependency
2. Ensure successful build
3. Ensure all tests pass
4. Ensure application can be run/ran locally
5. Test with Postman collection
6. Repeat Steps 1-5

## 2. Upgrade All Dependencies to LAST Minor/Patch version for LAST Major version

E.g. Upgrade `2.23.2` to `2.25.4`

Steps:

1. Upgrade to LAST Minor/Patch version for LAST Major version
2. Ensure successful build
3. Ensure all tests pass
4. Ensure application can be run/ran locally
5. Test with Postman collection
6. If errors occur, increment EVEN SLOWER using PATCH versions
   - `2.23.2` to `2.23.3`
   - Then `2.23.3` to `2.23.4`
   - Then `2.23.4` to `2.24.0`

Notes:

- We want to "lift and shift" WITHOUT modifying code
  - AVOID modifying code if possible (since we are unfamiliar of the existing code's function/purpose [unless explicitly stated on the docs to replace method `a` with method `b`])
  - E.g. Avoid changing `.withServiceRef()` to `.withService()` (WITHOUT first consulting/referencing docs on difference between the two)
- If you must modify code, reference/use the docs to DETERMINE what was function/purpose of the existing code and if new code MAINTAINS THE SAME functionality/purpose

```re
3.3.1
3.3.0
3.2.1
3.2.0
3.1.3
3.1.2
3.1.1
3.1.0
3.0.2
3.0.1
3.0.0
2.25.4
2.25.3
2.25.2
2.25.1
2.25.0
2.24.3
2.24.2
2.24.1
2.24.0
2.23.4
2.23.3
2.23.2
2.23.1
2.23.0
```

## 3. Upgrade to NEXT Major version to Fix Vulnerabilities

Upgrade to NEXT Major version, and then move incrementally via Minor/Patch versions to fix vulnerabilities

- Upgrade `2.25.4` to `3.0.0`
- Then `3.0.0` to `3.0.2`
- Then `3.0.2` to `3.1.0`
