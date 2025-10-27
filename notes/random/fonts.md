# Table of Contents

- [Table of Contents](#table-of-contents)
- [Google Fonts](#google-fonts)
- [NerdFonts](#nerdfonts)
- [FontForge](#fontforge)
  - [Troubleshooting](#troubleshooting)
  - [Create Custom Font](#create-custom-font)
  - [Regular vs Bold Font Info](#regular-vs-bold-font-info)
    - [Regular](#regular)
    - [Bold](#bold)
- [RobotLGC](#robotlgc)
  - [New](#new)
  - [Old](#old)

# Google Fonts

[Google Fonts](https://fonts.google.com/?sort=popularity)

# NerdFonts

https://www.nerdfonts.com/font-downloads

https://github.com/ryanoasis/nerd-fonts/releases

# FontForge

[FontForge](https://fontforge.org/en-US/downloads/windows-dl/)

## Troubleshooting

If you cannot copy paste characters across fonts, just keep restarting `FontForge.app`

Potentially might need to create copy of the font > Generate Fonts...

## Create Custom Font

1. Download font from [NerdFonts Github](https://www.nerdfonts.com/font-downloads)
2. Open nerd font with FontForge
3. `File > Generate Fonts` > Create Copy (somehow original nerd font is read-only)
   - Do NOT tick any checkboxes (Validate Before Saving, Append a FONTLOG entry, Prepend timestamp)
   - Example: Make custom copies of `InconsolateLGC NF Mono`, `JetBrainsMonoNL Nerd Font Mono`
4. Open copied nerd font with FontForge
5. Copy and paste characters across nerd fonts as required
6. `Element > Font Info... > PS Names` > See below
7. `Element > Font Info > TTF Names` > Delete everything except for "Regular" + "Version"

## Regular vs Bold Font Info

`Element > Font Info... > PS Names`

Note: `Family Name` MUST BE THE SAME

Note: After changing `PS Names`, click `Change` when asked to `Change UniqueID` (this popup will appear automatically after pressing `OK`)

- `Fontname`: Cannot have spaces
- `Family Name`: Font name you will enter into VSCode
- `Name for Humans`: Make same as "Family Name"
- `Element > Font Info > TTF Names` > Remove everything except for "Regular" + "Version"

### Regular

```sh
Fontname: JetBrainsMonoNL
Family Name: JetBrainsMonoNL # <-- MUST BE THE SAME
Name for Humans: JetBrainsMonoNL Regular
```

### Bold

```sh
Fontname: JetBrainsMonoNLBold
Family Name: JetBrainsMonoNL # <-- MUST BE THE SAME
Name for Humans: JetBrainsMonoNL Bold
```

# RobotLGC

## New

Copied `character from JetBrainsMono
Center in Middle`Transform > Origin: Glyph Origin > Scale`
Scale: 137.5% x, 100% y

## Old

Trick is to double click on ligature and compare its margins/proportions to Inconsolata LGC's

Depending on character we sometimes choose to "Center In Width" AFTER transforming

- `()<>[]{}` brackets are EXCLUDED from "Center In Width"

Note: When choosing `Transform > Scale` > Do NOT tick "Transform Width" + "Round to Int" but select ALL other options (unless selecting "Scale Uniformly")

`Element > Font Info > PS Names`

- "Fontname": cannot have spaces
- "Family Name": is the name you will enter into VSCode
- "Name for Humans": Make same as "Family Name"

`Element > Font Info > TTF Names` > Remove everything except for "Regular" + "Version"

`File > Generate Fonts > TrueType (.tff)` > Choose a name for your font (this is NOT the name you will enter into VSCode)

To create "Regular" and "Bold" versions of font, make sure `Element > Font Info > Family Name` are the SAME

- Also create a Bold version using a pre-existing Bold version as base

RobotoLGC

- Base = `RobotoMono`
- Copied characters over from `InconsolataLGC`
  - Characters copied over in regex notation: `["#$%&'-/0=?@\_|]`
    - Note: The ` character is specilly made using Windows PowerToy's Screen Ruler to make top and bottom lengths equal
- Modification Process
  - Need to open `InconsolataLGC` using `File > Open` to enable Copy Paste Functionality
  - Right click on character in `RobotoMono` > `Clear`
  - Copy and Paste character from `InconsolataLGC`
  - Right click on character in `RobotoMono` > `Transform > Origin: Glyph Origin > Scale Uniformly`
    - Choose all options except for "Round to Int" (tbh not sure what this does)
    - Keep experimenting with values until you get one that scales character's width to be SAME WIDTH as existing characters
    - Always run this after transformations `Right Click > Center in Width`
    - Note: For Bold we Scale Uniformly by `200.6%` (include all options except for "Round to Int")
    - Note: You can also manually set width by `Right Click > Set Width...`

Naming Scheme

- "S" = Square Brackets [] (copied from Inconsolata LGC)
- "P" = Parentheses () (copied from Inconsolata LGC)
- "B" = Braces {} (copied from Inconsolata LGC)
- "EQ" = Equality <> (copied from Inconsolata LGC)
- "AT" = @ (copied from Roboto)

```
@ (for RobotoLGC)
Scale: 105% x, 120% y (Transform Width)
For Bold: Scale: 100% x 120% y
Move: -325 y

@ (for InconsolataLGC)
Scale: 105x, 110y
Keep scaling x until it is very close to boundaries
Keep moving y down until it matches original InconsolataLGC or RobotoLGC

!
Scale: 108% x, 100% y

-
Scale: 110% x, 100% y

=
Scale: 118% x, 100% y (copied from Inconsolata LGC)
For Bold:
- Transform width using `Set Width...` and scale by 200.6%
- Scale: 121.5% x, 100% y (do NOT select "Transform Width Too")
Move: -75y (for RobotoLGC)
Move: -25y (for InconsolataLGC)

"#$%'/0\_|
Scale Uniformly: 200.49% (Origin = Glyph Origin) (Transform Width) (copied from Inconsolata LGC)

_
For Bold: Scale: 97.5% or 98% x (after scaling uniformly up to match width of 1229)

`
Scale: 175% x, 100y
Move: 75 y
Used PowerToy's Screen Ruler to make top and bottom lengths equal

<>
Scale Uniformly: 200.49% (Origin = Glyph Origin) (Transform Width) (copied from Inconsolata LGC) (think we ended up using RobotoMono's)
```
