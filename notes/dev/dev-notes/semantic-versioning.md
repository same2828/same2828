# Table of Contents

- [Table of Contents](#table-of-contents)
- [TLDR](#tldr)
- [Semantic Versioning Specification (SemVer)](#semantic-versioning-specification-semver)
- [Greek Alphabet](#greek-alphabet)

[Semantic Versioning Specification](https://semver.org/)

# TLDR

```
x.y.z
major.minor.patch

x.y.z-pre-release
major.minor.patch.pre-release
```

- `x = patch` = Bug fix
- `y = minor` = Functionality (backward compatible)
- `z = major` = Functionality (NOT backward compatible)
- `pre-release` = Contains only `[0-9A-Za-z-]`
  - E.g. `1.0.0-alpha < 1.0.0-alpha.beta < 1.0.0-beta`
- Start your initial development release at `0.1.0` and then increment the minor version for each subsequent release

# Semantic Versioning Specification (SemVer)

1. A normal version number MUST take the form X.Y.Z where X, Y, and Z are non-negative integers, and MUST NOT contain leading zeroes
   - `X` = MAJOR version
   - `Y` = MINOR version
   - `Z` = PATCH version
   - Each element MUST increase numerically
   - E.g. `1.9.0 -> 1.10.0 -> 1.11.0`
2. Once a versioned package has been released, the contents of that version MUST NOT be modified
   - Any modifications MUST be released as a new version
3. Major version zero (`0.y.z`) is for INITIAL development
   - Anything MAY change at any time
   - The public API SHOULD NOT be considered stable
4. Version `1.0.0` defines the public API
   - The way in which the version number is incremented after this release is dependent on this public API and how it changes
5. Patch version `Z` in `x.y.Z` (where `x > 0`) MUST be incremented if only backward compatible bug fixes are introduced
   - A bug fix is defined as an internal change that fixes incorrect behavior
6. Minor version `Y` in `x.Y.z` (where `x > 0`) MUST be incremented if new, backward compatible functionality is introduced to the public API
   - It MUST be incremented if any public API functionality is marked as deprecated
   - It MAY be incremented if substantial new functionality or improvements are introduced within the private code
   - It MAY include patch level changes
   - **Patch version MUST be reset to 0 when minor version is incremented**
7. Major version `X` in `X.y.z` (where `X > 0`) MUST be incremented if any backward INCOMPATIBLE changes are introduced to the public API
   - It MAY also include minor and patch level changes
   - Patch and minor versions MUST be reset to 0 when major version is incremented
8. A pre-release version MAY be denoted by appending a hyphen and a series of dot separated identifiers immediately following the patch version
   - Identifiers MUST comprise only ASCII alphanumerics and hyphens `[0-9A-Za-z-]`
   - Identifiers MUST NOT be empty
   - Numeric identifiers MUST NOT include leading zeroes
   - Pre-release versions have a LOWER precedence than the associated normal version
   - A pre-release version indicates that the version is unstable and might not satisfy the intended compatibility requirements as denoted by its associated normal version
   - Examples: `1.0.0-alpha, 1.0.0-alpha.1, 1.0.0-0.3.7, 1.0.0-x.7.z.92, 1.0.0-x-y-z.--`
9. Build metadata MAY be denoted by appending a plus sign and a series of dot separated identifiers immediately following the patch or pre-release version
   - Identifiers MUST comprise only ASCII alphanumerics and hyphens `[0-9A-Za-z-]`
   - Identifiers MUST NOT be empty
   - Build metadata MUST be ignored when determining version precedence
   - Thus two versions that differ only in the build metadata, have the same precedence
   - Examples: `1.0.0-alpha+001, 1.0.0+20130313144700, 1.0.0-beta+exp.sha.5114f85, 1.0.0+21AF26D3----117B344092BD`
10. Precedence refers to how versions are compared to each other when ordered
    - Precedence is determined by the first difference when comparing each of these identifiers from LEFT to RIGHT as follows:
      - Major, minor, and patch versions are always compared numerically
    - Example: `1.0.0 < 2.0.0 < 2.1.0 < 2.1.1`
    - When major, minor, and patch are equal, a pre-release version has lower precedence than a normal version:
      - Example: `1.0.0-alpha < 1.0.0`
    - Precedence for two pre-release versions with the same major, minor, and patch version MUST be determined by comparing each dot separated identifier from LEFT to RIGHT until a difference is found as follows:
      - Identifiers consisting of only digits are compared numerically
      - Identifiers with letters or hyphens are compared lexically in ASCII sort order
      - Numeric identifiers always have lower precedence than non-numeric identifiers
      - A larger set of pre-release fields has a higher precedence than a smaller set, if all of the preceding identifiers are equal
      - Example: `1.0.0-alpha < 1.0.0-alpha.1 < 1.0.0-alpha.beta < 1.0.0-beta < 1.0.0-beta.2 < 1.0.0-beta.11 < 1.0.0-rc.1 < 1.0.0`

Note:

- If you're changing the API every day you should either:
  - Be on version 0.y.z
  - Be on a separate development branch working on the next major version

# Greek Alphabet

| Name    | Letter | Letter |
| ------- | ------ | ------ |
| alpha   | Α      | α      |
| beta    | Β      | β      |
| gamma   | Γ      | γ      |
| delta   | Δ      | δ      |
| epsilon | Ε      | ε      |
| zeta    | Ζ      | ζ      |
| eta     | Η      | η      |
| theta   | Θ      | θ      |
| iota    | Ι      | ι      |
| kappa   | Κ      | κ      |
| lambda  | Λ      | λ      |
| mu      | Μ      | μ      |
| nu      | Ν      | ν      |
| xi      | Ξ      | ξ      |
| omikron | Ο      | ο      |
| pi      | Π      | π      |
| rho     | Ρ      | ρ      |
| sigma   | Σ      | σ      |
| tau     | Τ      | τ      |
| upsilon | Υ      | υ      |
| phi     | Φ      | φ      |
| chi     | Χ      | χ      |
| psi     | Ψ      | ψ      |
| omega   | Ω      | ω      |
