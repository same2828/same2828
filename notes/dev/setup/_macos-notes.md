# Table of Contents

- [Table of Contents](#table-of-contents)
- [Dev Setup](#dev-setup)
  - [Apps](#apps)
    - [iTerm2](#iterm2)
    - [Terminal](#terminal)
    - [Karabiner Elements](#karabiner-elements)
      - [Simple Modifications](#simple-modifications)
      - [Complex Modifications](#complex-modifications)
    - [LibreOffice](#libreoffice)
    - [Librewolf](#librewolf)
    - [Mounty](#mounty)
    - [Rectangle](#rectangle)
    - [Spotify](#spotify)
    - [VSCodium](#vscodium)
  - [External Display/Monitor](#external-displaymonitor)
  - [Finder](#finder)
    - [General + Toolbar](#general--toolbar)
    - [Increase Font Size](#increase-font-size)
    - [Windows Explorer Filename Sorting](#windows-explorer-filename-sorting)
  - [Keyboard](#keyboard)
    - [Prevent Accented Characters + Remove Input Menu from Menu Bar](#prevent-accented-characters--remove-input-menu-from-menu-bar)
    - [Disable Mail App Shortcut](#disable-mail-app-shortcut)
    - [Disable Option key shortcuts inserting special characters and diacritics](#disable-option-key-shortcuts-inserting-special-characters-and-diacritics)
    - [Keyboard Remap](#keyboard-remap)
  - [MacPorts](#macports)
  - [System Settings](#system-settings)
    - [Accessibility](#accessibility)
    - [Hot Corners](#hot-corners)
    - [Mouse](#mouse)
  - [Terminal Commands](#terminal-commands)
    - [System Settings](#system-settings-1)
    - [Dev Environment](#dev-environment)
      - [OhMyZsh](#ohmyzsh)
      - [Git](#git)
      - [SSH Keys](#ssh-keys)
  - [Web Browser Extensions](#web-browser-extensions)
- [Torrents](#torrents)
  - [Allow Unidentified Developers](#allow-unidentified-developers)
  - [Fix for "App is damaged and can't be opened. You should move it to the Trash" error](#fix-for-app-is-damaged-and-cant-be-opened-you-should-move-it-to-the-trash-error)
  - [Microsoft Office](#microsoft-office)
- [Shortcuts](#shortcuts)
  - [VSCode Shortcuts](#vscode-shortcuts)
- [Tips](#tips)
  - [Prevent Mac from Sleeping](#prevent-mac-from-sleeping)
  - [Move Window in Background Without Disrupting Foreground](#move-window-in-background-without-disrupting-foreground)
  - [Three Finger Window Drag](#three-finger-window-drag)
  - [Brightness](#brightness)
- [Random](#random)
  - [Automator AppleScript](#automator-applescript)
  - [Custom Icons (ICNS)](#custom-icons-icns)
  - [Apps to Check Out](#apps-to-check-out)
  - [Force Reload Chrome Tab](#force-reload-chrome-tab)
- [Clean Install](#clean-install)
- [Delete Apple Intelligence (Apple AI)](#delete-apple-intelligence-apple-ai)

# Dev Setup

## Apps

- [AppCleaner](https://freemacsoft.net/appcleaner/)
- [BetterDisplay](https://github.com/waydabber/BetterDisplay/releases)
- [Flux](https://justgetflux.com/) Note: `Menu Bar > Options` > Turn ON "Expanded daytime settings" > 2200K
- [IINA](https://github.com/iina/iina/releases)
- [Karabiner-Elements](https://github.com/pqrs-org/Karabiner-Elements/releases)
- [Keka](hhttps://github.com/aonez/Keka/releases)
- [LinearMouse](https://github.com/linearmouse/linearmouse/releases)
- [MiddleClick](https://github.com/artginzburg/MiddleClick-Sonoma)
- [Mounty](https://mounty.app/)
- [OpenMTP](https://github.com/ganeshrvel/openmtp/releases)
- [Rectangle](https://rectangleapp.com/)
- [Stats](https://github.com/exelban/stats/releases)
- [System Color Picker](https://sindresorhus.com/system-color-picker)

- Alfred
- App Cleaner & Uninstaller
- Moom
- PDF Expert
- Radio Silence
- SoundSource
- TextSniper

### iTerm2

- Settings > General > Appearance > Theme > Minimal
- Settings > Profiles > Create a NEW profile > Click on it > Other Actions... > Set as Default
- Settings > Profiles > ${customProfileName} > Keys > Key Mappings > Presets... > Select Natural Text Editing > Remove existing keymaps
- Settings > Profiles > ${customProfileName} > General > Working Directory > Select Reuse previous session's directory
- Import colors profile from `github/config/iterm2.json`
- Settings > Profiles > ${customProfileName} > Terminal > Turn OFF "Show mark indicators"
- Allow `Alt+C` option for `fzf`
  - Settings > Profiles > ${customProfileName} > Keys > General > Esc+

### Terminal

Settings > Profiles > MyProfile > Keyboard > Turn ON "Use Option as Meta Key" (Option + Backspace == Delete Whole Line)

Settings > Profiles > MyProfile > ANSI Colors > Change Blue to Cyan

Settings > Profiles > MyProfile > Window Size > Column = 90 && Rows = 22

| Command              | Description                                                                                                  |
| -------------------- | ------------------------------------------------------------------------------------------------------------ |
| `Option + Backspace` | Delete Word                                                                                                  |
| `Option + Delete`    | Delete Word Reverse                                                                                          |
| Command Editing      |                                                                                                              |
| `Ctrl + A`           | Go to the START of the command line                                                                          |
| `Ctrl + E`           | Go to the END of the command line                                                                            |
| `Ctrl + K`           | Delete from cursor to the END of the command line                                                            |
| `Ctrl + U`           | Delete from cursor to the START of the command line                                                          |
| `Ctrl + W`           | Delete from cursor to START of word (i.e. delete backwards one word)                                         |
| `Ctrl + Y`           | Paste word or text that was cut using one of the deletion shortcuts (such as the one above) after the cursor |
| `Ctrl + XX`          | Move between START of command line and current cursor position (and back again)                              |
| `Alt + B`            | Move backward one word (or go to START of word the cursor is currently on)                                   |
| `Alt + F`            | Move forward one word (or go to END of word the cursor is currently on)                                      |
| `Alt + D`            | Delete to END of word starting at cursor (whole word if cursor is at the beginning of word)                  |
| `Alt + C`            | Capitalize to END of word starting at cursor (whole word if cursor is at the beginning of word)              |
| `Alt + U`            | Make uppercase from cursor to END of word                                                                    |
| `Alt + L`            | Make lowercase from cursor to END of word                                                                    |
| `Alt + T`            | Swap current word with previous                                                                              |
| `Ctrl + F`           | Move forward one character                                                                                   |
| `Ctrl + B`           | Move backward one character                                                                                  |
| `Ctrl + D`           | Delete character under the cursor                                                                            |
| `Ctrl + H`           | Delete character before the cursor                                                                           |
| `Ctrl + T`           | Swap character under cursor with the previous one                                                            |
| Command Recall       |                                                                                                              |
| `Ctrl + R`           | Search the history backwards                                                                                 |
| `Ctrl + G`           | Escape from history searching mode                                                                           |
| `Ctrl + P`           | Previous command in history (i.e. walk back through the command history)                                     |
| `Ctrl + N`           | Next command in history (i.e. walk forward through the command history)                                      |
| `Alt + .`            | Use the last word of the previous command                                                                    |
| Command Control      |                                                                                                              |
| `Ctrl + L`           | Clear the screen                                                                                             |
| `Ctrl + S`           | Stops the output to the screen (for long running verbose command)                                            |
| `Ctrl + Q`           | Allow output to the screen (if previously stopped using command above)                                       |
| `Ctrl + C`           | Terminate the command                                                                                        |
| `Ctrl + Z`           | Suspend/stop the command                                                                                     |

### Karabiner Elements

- Note: After each macOS update, you may need to UNINSTALL and REINSTALL Karabiner Elements again
  - Uninstall using `Karabiner Elements > Settings > Uninstall` (do NOT use App Cleaner)
  - [Docs](https://karabiner-elements.pqrs.org/docs/help/troubleshooting/stopped-working-after-macos-update/)

#### Simple Modifications

```sh
# Settings > Simple Modifications > For all devices
f4 -> illumination_down
f5 -> illumination_up
pause -> play_or_pause

# Settings > Simple Modifications > For Ducky Keyboard
application -> right_control
keypad_enter -> return_or_enter
left_command -> left_control
left_control -> left_command
right_control -> right_command
```

#### Complex Modifications

```json
{
  "description": "Change print_screen to cmd+shift+5",
  "manipulators": [
    {
      "from": { "key_code": "print_screen" },
      "to": [
        {
          "key_code": "5",
          "modifiers": ["left_command", "left_shift"]
        }
      ],
      "type": "basic"
    }
  ]
}
```

```json
{
  "description": "Change scroll_lock to cmd+shift+7 (TextSniper)",
  "manipulators": [
    {
      "from": { "key_code": "scroll_lock" },
      "to": [
        {
          "key_code": "7",
          "modifiers": ["left_command", "left_shift"]
        }
      ],
      "type": "basic"
    }
  ]
}
```

### LibreOffice

```sh
brew install --cask libreoffice-still
```

- Open Blank Calc Spreadsheet > macOS Menu Bar > View > User Interface > Tabbed > Apply to All
- Open Blank Calc Spreadsheet > macOS Menu Bar > Tools > AutoCorrect Options > Options
  - Turn OFF Everything
    - Use replacement table
    - URL recognition
    - Replace dashes
    - Correct two initial capitals
    - Capitalize first letter of every sentence
    - Correct accidental usage of caps lock key
- Settings > Search for "Appearance" > Icon Theme > Colibre (SVG + dark)
- Drag and Drop Cell
  - Click on Cell > Shift + Click on Cell > Drag (using mouse, no shift)

Preferences > LibreOffice > Appearance > LibreOffice Themes > Dark (untick all boxes underneath)
Preferences > LibreOffice > Appearance > Customizations > Document Background > Should #1C1C1C by default
Preferences > LibreOffice > Appearance > Customizations > Font Color > #FFFFFF

Styles > Manage Styles > Right-click on Default > Edit Style... > Font > Family > Menlo
Styles > Manage Styles > Right-click on Default > Edit Style... > Font > Size > 12

### Librewolf

```sh
brew install --cask librewolf --no-quarantine
xattr -cr /Applications/LibreWolf.app
xattr -dr com.apple.quarantine /Applications/LibreWolf.app
xattr -cr "/Applications/PDF Expert.app" & codesign -fs - "/Applications/PDF Expert.app"
xattr -cr /Applications/PDF\ Expert.app & codesign -f -s - /Applications/PDF\ Expert.app
# brew reinstall librewolf --no-quarantine
```

Change Zoom Levels

- `URL Bar > about:config > zoom > toolkit.zoomManager.zoomValues > .25,.33,.5,.67,0.75,.8,.9,1,1.1,1.25,1.33,1.5,1.75,2,2.25,2.5,2.75,3,3.25,3.5,3.75,4,5`

Disable Hover Preview

`about:config > browser.tabs.hoverPreview.enabled = FALSE`

`about:config > browser.tabs.hoverPreview.showThumbnails = FALSE`

`about:config > browser.urlbar.update2.engineAliasRefresh  > Keep the selection on Boolean and click the plus sign button` (if the value isn't set to true automatically, double-click false to switch it to true)

Enable Performance Mode

- `Settings > General > Performance` > UNTICK "Use recommended performance settings" + Leave ON "Use hardware acceleration when available"

Enable DNS over HTTPS

- `about:preferences > Privacy & Security > DNS over HTTPS > Increased Protection > Cloudflare`

Turn off Ai Features

- `about:config > browser.ml.chat.enabled = FALSE`
- `about:config > browser.ml.enable = FALSE`
- `about:config > extensions.ml.enabled = FALSE`

Change Search Engine to Google Search Verbatim

- `about:config > browser.urlbar.update2.engineAliasRefresh  > Keep the selection on Boolean and click the plus sign (+) button` (if the value isn't set to true automatically, double-click false to switch it to true)
- `about:preferences > Search > Add Search Engine > https://www.google.com/search?q=%s&tbs=li%3A1`

```sh
https://www.google.com/search?q=%s&tbs=li:1
https://www.google.com/search?q=%s&tbs=li%3A1
https://www.google.com/search?q=%s&udm=14
https://www.google.com/search?q=%s&udm=14&tbs=li:1
https://www.google.com/search?q=%s&udm=14&tbs=li%3A1
```

### Mounty

```sh
# Mounty
brew install --cask macfuse
brew install gromgit/fuse/ntfs-3g-mac
# brew install --cask mounty # Chose to NOT do this and instead manually download and VirusTotal scan each new release
```

- [Enable System Extensions](https://www.youtube.com/watch?v=SL3FlgWQiS4)
  - Trigger Mounty system extension by inserting a NTFS usb/external hard drive and choosing to "re-mount" it
  - Shut down MacBook
  - Wait 10-30 seconds
  - Press and HOLD power key until it shows "Startup Options"
  - `Click on "Options" Logo > Continue > Click on User > Next > Enter password for user`
  - `Menu Bar > Utilities > Startup Security Utility > Unlock Disk > Security Policy > Reduced Security > Allow user management of kernel extensions from identified developers`
  - `Menu Bar > Apple logo > Restart`
  - Trigger Mounty system extension AGAIN by inserting a NTFS usb/external hard drive and choosing to "re-mount" it AGAIN
  - Restart MacBook to enable Mounty system extension

### Rectangle

Shortcuts

- DELETE Everything
- Left Half = `Control + Option + Left Arrow`
- Right Half = `Control + Option + Right Arrow`
- Top Left = `Control + Option + U`
- Top Right = `Control + Option + I`
- Bottom Left = `Control + Option + J`
- Bottom Right = `Control + Option + K`
- Maximise = `Control + Option + Up Arrow`
- Make Smaller = `Control + Option + -`
- Make Larger = `Control + Option + =`
- Center = `Control + Option + C`
- Restore = `Control + Option + Down Arrow`
- Next Display = `Control + Option + Command + Right Arrow`
- Previous Display = `Control + Option + Command + Left Arrow`

- [Rectangle](https://rectangleapp.com/)

### Spotify

SpotX > BlockTheSpot

[SpotX - Windows](https://github.com/SpotX-Official/SpotX)

[SpotX Bash - macOS](https://github.com/SpotX-Official/SpotX-Bash)

```sh
bash <(curl -sSL https://spotx-official.github.io/run.sh) --installmac -f -B
```

### VSCodium

[VSCodium](https://vscodium.com/#install)

```sh
brew install --cask vscodium
```

## External Display/Monitor

- Use [BetterDisplay](https://github.com/waydabber/BetterDisplay/releases)
- Make sure to **DISABLE** Flux.app (since it prevents "Image Adjustments") and **ENABLE** Night Shift
- `Settings > Displays > "click-on-monitor-name" > System Configuration and Smooth Scaling`
  - Turn ON `Edit the system configuration of this display model`
    - Turn ON `Enable Smooth Scaling`
      - Turn ON `Add near-native HiDPI resolution with smooth scaling`
  - Turn OFF `DDC Control` (to prevent changing monitor's hardware brightness)
- Scale resolution of external monitor by 20% (i.e. scale down to 80%)
  - 2560 x 1440 -> 2048 x 1152
- Under the **"Image Adjustments"** tab
  - Increase **"temperature"** setting (should be 3rd option) after "contrast"
- Lenovo D32Q
  - `-15%` Contrast
  - `+10%` Temperature
- Macbook Pro
  - `+60%` Temperature

## Finder

- Hold down the `Option (⌥)` while resizing finder columns to permanently set column size (also resizes all columns at once)
- Double click on the column divider to temporarily resize columns for current folder

### General + Toolbar

- `View > Show Path Bar`
- `View > Show Status Bar`
- `View > Customise Toolbar`
  - Add
    - `Airdrop`
    - `Get info`
  - Remove `Group by`

### Increase Font Size

- `View > Show View Options > Increase Text Size to "16" > Click "Use as Defaults"`
- Click on Downloads Folder > `Command + J`
  - Sort by: `Date Modified`
  - Add `Date Modified` Column
  - Turn OFF > `Use relative dates`
  - Turn ON > `Calculate all sizes`
  - Click `Use as Defaults`

### Windows Explorer Filename Sorting

- `View > Settings > Advanced`
  - Turn ON > `Show all filename extensions`
  - `Keep Folders on Top:` > Turn ON `In windows when sorting by name`

## Keyboard

### Prevent Accented Characters + Remove Input Menu from Menu Bar

`System Settings > Keyboard > Input Sources > Unicode Hex Input`

`System Settings > Keyboard > Input Sources > All Input Sources` > Turn OFF `Show input menu in menu bar`

`System Settings > Keyboard > Keyboard Shortcuts...`

- `Mission Control > Quick Note` > Turn OFF
- `Input Sources` > Turn OFF ALL
- `Services > Files and Folders` > Turn OFF (for apps such as Keka)
- `Services > Text` > Turn OFF (for apps such as Keka)
- `Accessibility` > Turn OFF ALL
- `App Shortcuts` > Turn OFF ALL

### Disable Mail App Shortcut

`System Settings > Keyboard > Keyboard Shortcuts... > App Shortcuts > Add (+)`

```
Application: All Applications
Menu Title: Email This Page
Keyboard Shortcut: fn + control + option + command + shift + f1

Application: All Applications
Menu Title: Email Link
Keyboard Shortcut: fn + control + option + command + shift + f1
```

https://apple.stackexchange.com/questions/439822/cant-disable-command-shift-i-to-open-mail
https://jamierubin.net/2021/07/30/how-to-remap-cmd-i-to-avoid-opening-the-mail-app-on-a-mac/

### Disable Option key shortcuts inserting special characters and diacritics

https://gist.github.com/greneholt/e7d5373f96cc0f815717c7666790324d

```
mkdir -p ~/Library/Keyboard\ Layouts/
cp ~/Downloads/QWERTY-no-option.keylayout ~/Library/Keyboard\ Layouts/
# Keyboard > Text Input > Input Sources > Edit > Add > Others > Add "Qwerty no option"
# Keyboard > Text Input > Input Sources > Edit > All Input Sources > Show Input menu in menu bar > Turn ON
# Select Qwerty No Option in macOS Menu Bar
# Keyboard > Text Input > Input Sources > Edit > All Input Sources > Show Input menu in menu bar > Turn OFF
```

### Keyboard Remap

Use `System Settings > Keyboard > Keyboard Shortcuts > Change Modifier Keys` or Karabiner-Elements App

**macOS Default**

| Control (^) | Option (⌥) | Command (⌘) |
| ----------- | ---------- | ----------- |

**Windows Keyboard Default**

| Control (^) | Command (⌘) | Option (⌥) |
| ----------- | ----------- | ---------- |

**Windows Keyboard Modified**

| Command (⌘) | Control (^) | Option (⌥) |
| ----------- | ----------- | ---------- |

Hence

```
Control -> Command
Command -> Control
```

```sh
# Settings > Simple Modifications > For all devices
application -> right_command
f4 -> illumination_down
f5 -> illumination_up
pause -> play_or_pause

# Settings > Simple Modifications > For Ducky Keyboard
left_command -> left_control
left_control -> left_command
application -> right_control
right_control -> right_command
keypad_enter -> return_or_enter
```

```sh
# Implicitly
# ----------
# left_control -> left_command
# left_window -> left_control
# left_alt -> left_option
# right_alt -> right_option
# right_menu -> right_control
# right_control -> right_command
```

## MacPorts

[MacPorts](https://www.macports.org/)
[MacPorts Ports](https://ports.macports.org/)

```sh
sudo port selfupdate && sudo port outdated
sudo port selfupdate && sudo port upgrade outdated
```

```sh
# Update MacPorts tree
sudo port selfupdate

# Upgrade all outdated ports
sudo port upgrade outdated

# Search for a port
port search <package_name>

# Get info about a port
port info <package_name>

# List files installed by a port (including filepaths)
port contents <package_name>

# List installed ports
port installed

# Install a port
sudo port install <package_name>

# Uninstall a port
sudo port uninstall <package_name>

# Uninstall all inactive ports and their dependencies
sudo port uninstall --follow-dependents <package_name>

# Clean up intermediate build files
sudo port clean --all <package_name>

# Reclaim space by removing files for inactive ports
sudo port reclaim

# Find which port installed a file
port provides /path/to/file
```

## System Settings

`System Settings > Privacy & Security > Full Disk Access` > iTerm2 + Visual Studio Code

`System Settings > Privacy & Security > Developer Tools` > iTerm2 + Visual Studio Code

`System Settings > Desktop & Dock > Minimise windows using` > Scale Effect

`System Settings > Desktop & Dock > Desktop & Stage Manager > Click wallpaper to reveal desktop` > Only in Stage Manager

### Accessibility

Fix MenuBar Color: `System Settings > Accessibility > Display > Reduce Transparency` > Turn ON

`System Settings > Display > Pointer > Shake mouse pointer to locate` > Turn OFF

### Hot Corners

`System Settings > Desktop & Dock > Hot Corner Shortcuts > Bottom Right` > Hold down `Shift` key + "Mission Control"

- Trigger only with modifier key = HOLD down key of choice when clicking corner option
  - `Shift + Mission Control` for `Bottom-Right` corner

### Mouse

`System Settings > Accessibility > Display > Pointer > Shake mouse pointer to locate` > Turn OFF

## Terminal Commands

### System Settings

```sh
# Allow Apps from Unidentified Developers
sudo spctl --master-disable

# Change Screenshot Type to JPG
defaults write com.apple.screencapture type jpg

# Change Screenshot Location
# Alternative: Command + Shift + 5 > Options > Save to > Other Location...
cd ~/Pictures && mkdir Screenshots
defaults write com.apple.screencapture location /Users/same/Pictures/Screenshots

# Show Full Path in Finder
defaults write com.apple.finder _FXShowPosixPathInTitle -bool YES; killall Finder

# Expanded Print Dialog Window by default
defaults write -g PMPrintingExpandedStateForPrint -bool true

# Expanded Save Dialog Window by default
defaults write NSGlobalDomain NSNavPanelExpandedStateForSaveMode -bool true
defaults write NSGlobalDomain NSNavPanelExpandedStateForSaveMode2 -bool true

# Disable Accented Characters/Turn On Key Repeat
defaults write -g ApplePressAndHoldEnabled -bool false
# defaults write com.microsoft.VSCode ApplePressAndHoldEnabled -bool false

# Make Hidden Apps Transparent
defaults write com.apple.dock showhidden -bool true && killall Dock

# Lock Dock Size
defaults write com.apple.dock size-immutable -bool true; killall Dock
defaults write com.apple.dock size-immutable -bool false; killall Dock

# Lock Dock Contents
defaults write com.apple.dock contents-immutable -bool true; killall Dock
defaults write com.apple.dock contents-immutable -bool false; killall Dock

# Lock Dock Position
defaults write com.apple.dock position-immutable -bool true; killall Dock
defaults write com.apple.dock position-immutable -bool false; killall Dock

# Faster Docker Hiding
defaults write com.apple.dock autohide-delay -float 0; defaults write com.apple.dock autohide-time-modifier -int 0; killall Dock
defaults write com.apple.dock autohide-delay -float 0.5; defaults write com.apple.dock autohide-time-modifier -int 0.5; killall Dock

# Remove Dock Animation
defaults write com.apple.dock autohide-time-modifier -float 0; killall Dock

# Add Dock Spacer
defaults write com.apple.dock persistent-apps -array-add '{tile-data={}; tile-type="spacer-tile";}' && killall Dock

# Add Half Height Docker Spacer
defaults write com.apple.dock persistent-apps -array-add '{"tile-type"="small-spacer-tile";}' && killall Dock

# Disable Apple Intelligence: https://old.reddit.com/r/MacOS/comments/1id8tns/turning_off_apple_intelligence_from_terminal/
defaults write com.apple.CloudSubscriptionFeatures.optIn "device" -bool "false"
defaults write com.apple.CloudSubscriptionFeatures.optIn "auto_opt_in" -bool "false"
```

### Dev Environment

- [Install VSCode](https://code.visualstudio.com/download)
  - `Ctrl + P > Shell Command: Install 'code' command in PATH`
- [Install Nerd Font](https://www.nerdfonts.com/font-downloads)
  - Inconsolata LGC Nerd Font Mono
  - Click on file to install
  - Note: Be careful of the name that the system gives to the font once installed i.e. "Inconsolata LGC Nerd Font Mono" instead of "InconsolataLGC Nerd Font Mono"
- [Install iTerm2](https://iterm2.com/downloads.html)
  - Copy `github/config/iterm2-profile.json`
- [Install Homebrew](https://brew.sh/)
  - [Homebrew Docs](https://docs.brew.sh/)
  - [Homebrew Formulae](https://formulae.brew.sh/formula/)
  - [Homebrew Casks](https://formulae.brew.sh/cask/)
  - [Linuxbrew](https://docs.brew.sh/Homebrew-on-Linux)

```sh
# Disable Last Login Message in Terminal
touch ~/.hushlogin

# Install Homebrew > https://brew.sh/
#------------------------------------
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Follow the "Next Steps" Info > Enter Commands Listed
# echo >> /Users/same/.zprofile
# echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> /Users/same/.zprofile
# eval "$(/opt/homebrew/bin/brew shellenv)"
(echo; echo 'eval "$(/opt/homebrew/bin/brew shellenv)"') >> /Users/same/.zprofile
eval "$(/opt/homebrew/bin/brew shellenv)"

# Turn OFF Analytics
brew analytics off

# Set Homebrew Zsh as Default Shell instead of macOS Zsh > https://gist.github.com/ngocphamm/4978435
brew install zsh
which zsh
# Output should be "/opt/homebrew/bin/zsh"
sudo sh -c "echo $(which zsh) >> /etc/shells"
sudo chsh -s $(which zsh)
# Restart PC

# Install OhMyZsh > https://github.com/ohmyzsh/ohmyzsh
#-----------------------------------------------------
brew install curl fetch wget git fzf ripgrep fd
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"

# Update OhMyZsh
omz update

# Add OhMyZsh Plugins
git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions \
&& git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting \
&& git clone https://github.com/zdharma-continuum/fast-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/fast-syntax-highlighting \
&& git clone https://github.com/Aloxaf/fzf-tab ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/fzf-tab \
&& git clone https://github.com/sukkaw/zsh-fnm ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-fnm
# cd ~/.oh-my-zsh/custom/plugins
# git pull
# git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions
# git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
# git clone https://github.com/Aloxaf/fzf-tab ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/fzf-tab
# git clone https://github.com/sukkaw/zsh-fnm ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-fnm
# git clone https://github.com/zdharma-continuum/fast-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/fast-syntax-highlighting
# fast-theme -t <pathToCustomTheme>
# cd

# Use custom ~/.zshrc, ~/.zprofile, ~/.ssh/config, ~/.gitconfig
#--------------------------------------------------------------
mkdir ~/.ssh && touch ~/.ssh/config && touch ~/.gitconfig && code ~/ && code ~/.zshrc && code ~/.zprofile && code ~/.ssh/config && code ~/.gitconfig
# Copy paste github/config/.zshrc-macos into ~/.zshrc (make sure all "/home/linuxbrew/.linuxbrew/" is changed to "/opt/homebrew/" in ~/.zshrc)
# Copy paste github/config/.zprofile-macos into ~/.zprofile
# Copy paste github/config/.gitconfig into ~/.gitconfig

# GCC
#----
brew install gcc@13
# Set Homebrew GCC as default GCC instead of macOS GCC
# Method 1: Add the following to .zshrc
alias gcc="gcc-13"
alias g++="g++-13"
alias c++="c++-13"
alias cpp="cpp-13"
# Method 2: Create symbolic link (symlink)
sudo ln -sf $(which gcc-13) /usr/local/bin/gcc
sudo ln -sf $(which g++-13) /usr/local/bin/g++
sudo ln -sf $(which c++-13) /usr/local/bin/c++
sudo ln -sf $(which cpp-13) /usr/local/bin/cpp

# Use GNU CLI Tools > BSD CLI Tools
#----------------------------------
# Install GNU Utils > https://gist.github.com/skyzyx/3438280b18e4f7c490db8a2a2ca0b9da
# Afterwards append contents of use-gnu.sh to ~/.zshrc/ or ~/.zprofile file
brew install autoconf bash binutils coreutils diffutils findutils gawk gnu-indent gnu-sed gnu-tar gnu-which gpatch grep gzip less make nano watch wdiff wget zip
brew install jq parallel perl tee

# Other Brew Installs
#--------------------
brew install fastfetch python go tldr tree
brew install fnm # alternatively nvm
# brew install clang-format cmake llvm

# Adoptium OpenJDK (Eclipse Temurin) > https://adoptium.net/installation/
#------------------------------------------------------------------------
brew tap homebrew/homebrew-core
brew install --cask temurin@21

# Brew Casks
#-----------
brew install --cask brave-browser firefox google-chrome microsoft-edge
brew install --cask alfred appcleaner bruno flux-app ghostty iterm2 karabiner-elements keka libreoffice-still librewolf linearmouse lulu macfuse mounty rectangle stats sublime-text temurin@21 visual-studio-code vlc vscodium
brew install --cask dbeaver-community intellij-idea

# Starship
#---------
brew install starship
# brew install node@20
# brew link node@20 --overwrite
# Starship Prompt Customisation
mkdir -p ~/.config && touch ~/.config/starship.toml && code ~/ && code ~/.config/starship.toml
# Copy paste github/config/starship-macos.toml

# Zsh Theme (NO Starship)
# -----------------------
cp $ZSH/themes/robbyrussell.zsh-theme $ZSH_CUSTOM/themes/
code $ZSH_CUSTOM/themes/robbyrussell.zsh-theme
# Copy paste github/config/robbyrussell.zsh-theme
```

#### OhMyZsh

Custom Theme without Starship Prompt

```sh
# Install & paste github/config/.zshrc
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
# Custom theme
cp $ZSH/themes/robbyrussell.zsh-theme $ZSH_CUSTOM/themes/
code $ZSH_CUSTOM/themes/robbyrussell.zsh-theme
# Copy paste config/robbyrussell.zsh-theme
```

#### Git

```sh
code ~/.gitconfig
# Copy paste github/config/.gitconfig
```

#### SSH Keys

```sh
# Create SSH Key
ssh-keygen -t ed25519 -C "s3samedev@gmail.com"
/Users/same/.ssh/github-s3samedev
eval "$(ssh-agent -s)"
code ~/.ssh/config
# Copy paste github/config/ssh-config-wsl

# Add SSH Key to ssh-agent
ssh-add ~/.ssh/github-s3samedev

# Add SSH Key to GitHub Account
cat ~/.ssh/github-s3samedev.pub
# Copy paste into GitHub Account Settings > https://github.com/settings/keys

# Test SSH Key
ssh -T git@github.com
# Enter "yes" when prompted "Are you sure you want to continue connecting (yes/no)?"
```

[GitHub Docs](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)

## Web Browser Extensions

- Dark Reader
- Bypass Paywalls Clean (magnolia1234)
- GoFullPage
- IDM Integration Module (Get link from IDM website since its hidden by default)
- JSON Viewer (tulios)
- Popup Blocker (strict)
- React Developer Tools
- Reddit Enhancement Suite
- Return Youtube Dislike
- uBlock Origin
- Violentmonkey (disabled)
- Youtube-Shorts Block

# Torrents

## Allow Unidentified Developers

```sh
sudo spctl --master-disable
```

## Fix for "App is damaged and can't be opened. You should move it to the Trash" error

- Navigate to offending application in Finder
- Hold Option (⌥) key and right click on the application
- Choose "Copy ... as Pathname"

```sh
sudo xattr -cr /path/to/application.app
# sudo xattr -cr "/Applications/App Cleaner 8.app"
sudo xattr -dr com.apple.quarantine /path/to/application.app
# sudo xattr -dr com.apple.quarantine "/Applications/Alfred 5.app"
```

## Microsoft Office

- Uninstall Microsoft AutoUpdate

```sh
# Microsoft AutoUpdate location
/Library/Application Support/Microsoft/MAU2.0/Microsoft AutoUpdate.app
/Library/Application Support/Microsoft/MAU2.0/Microsoft AutoUpdate.app/Contents/MacOS/Microsoft Update Assistant.app/Contents/SharedSupport/Microsoft Error Reporting.app
```

# Shortcuts

Note: Always hold down `Option (⌥)` key to see more options for context menus

`Command + Click` = Open link in new tab (similar to middle mouse click)

`Command + Tab` = Switch Apps

`Shift + Command + Tab` or `Command + Tab` then `Command + ` = Switch Apps in Reverse

`Command + ` = Switch Windows of the Same App

`Shift + Command + ` = Switch Windows of the Same App in Reverse

`Command + Q` = Quit App

`Command + 1-9` = Select Tab 1-9

`Control + A` = Move Cursor to START of Line

`Control + E` = Move Cursor to END of Line

`Fn + Backspace` = Delete

`Fn + Option + Backspace` = Ctrl + Delete

`Command + Right Arrow` = Home

`Command + Left Arrow` = End

`Enter` = F2/Rename

`Ctrl + Command + Spacebar` = Show Emoji

`Shift + Option + Volume Keys` = Incremental Volume Adjustment (hold `Spacebar` to get volume preview)

`Shift + Option + Command + V` = Paste Without Formatting

`Option + Command + P` = Move Original File (similar to cut and paste): `Command + C` first then `Shift + Command + P` after

`Shift + Command + .` = Show Hidden Files in Finder

`Shift + Command + P` = Toggle Preview Pane in Finder

`F5` = Get Text Suggestions Whilst Typing

`Command + .` = Cancel Dialog Box

`Option + Command + C` = Copy Selected File's Filepath

**Screenshot**

1. `Command + Shift + 3` (FullScreen)
2. `Command + Shift + 4` (Selection)
3. `Command + Shift + 5` (Screen Capture Panel)

- Press `Spacebar` to get whole window
  - Hold `Option` to avoid drop shadow
- Hold `Spacebar` to move selection window
  - Hold `Option` to resize from origin
- Hold `Control` to copy to screenshot to clipboard

**Terminal**

`Control + W` = Delete Word (in Terminal)

`open .` == `explorer.exe .` on windows

```sh
open .
open /usr/local/bin
```

## VSCode Shortcuts

`Option + Arrows` = Move line up/down

`Shift + Option + Arrows` = Duplicate line

`Command + X` = Cut entire line (when not highlighting)

`Command + D` = Copy cursor for next instance of the same highlighted text (have multiple cursors)

`Command + P` = File search by name (I've noticed not all are the same but this is what it if for me)

`Command + Shift + P` = Run vs code command (mostly just for reload)

`Command + Shift + F` = Global text search

# Tips

## Prevent Mac from Sleeping

Enter `caffeinate` into Terminal (end by closing Terminal window or `Ctrl + C`)

## Move Window in Background Without Disrupting Foreground

Hold `Command` key whilst dragging

## Three Finger Window Drag

`Accessibility > Pointer Control > Trackpad Options > Use trackpad for dragging > Enable dragging: "three finger drag"`

Note: This does NOT work if you have MiddleClick enabled

## Brightness

16 levels

- 12'th level = 75% (reach it by reducing brightness by 4 steps from MAX)
- 13'th level = 81.25%
- 14'th level = 87.5%
- 15'th level = 93.75%

# Random

## Automator AppleScript

Automator > Application > Run AppleScript > Save as App

There's no other way to get `Chrome Incognito.app` added to Privacy > Automation tab

Do NOT change application icon until you do the following:

- `sudo spctl --master-disable`
- Launch application.app
- Get `Allow App to control Automation prompt` to show up
- Press allow
- `sudo spctl --master-enable`

## Custom Icons (ICNS)

- [DeviantArt](https://www.deviantart.com/)
- https://macosicons.com
- https://github.com/dhanishgajjar/vscode-icons

## Apps to Check Out

- [Menu Bar Tint](https://manytricks.com/menubartint/)
- [TopNotch](https://topnotch.app/)

## Force Reload Chrome Tab

- Windows/Linux: `Ctrl + F5` or `Shift + F5`
- Mac: `Command + Shift + R`

# Clean Install

- [Create a bootable installer for macOS](https://support.apple.com/en-au/101578)
- [Use Disk Utility to erase a Mac with Apple silicon](https://support.apple.com/en-us/102506)
- [How to Clean Install macOS Sequoia - YouTube](https://www.youtube.com/watch?v=GM1j0ISNh14)

```
softwareupdate --list-full-installers

softwareupdate --fetch-full-installer --full-installer-version 15.1.1

sudo /Applications/Install\ macOS\ Sequoia.app/Contents/Resources/createinstallmedia --volume /Volumes/Sandisk\ 32GB\ Dual
```

# Delete Apple Intelligence (Apple AI)

- https://old.reddit.com/r/MacOS/comments/1hca5ap/how_do_i_remove_apple_intelligence_permanently/
- https://old.reddit.com/r/mac/comments/1kntq8x/how_can_i_delete_apple_intelligence/
- https://old.reddit.com/r/MacOS/comments/1gertfw/removing_language_model_of_apple_intelligence/
- https://old.reddit.com/r/MacOSBeta/comments/1eqrg3k/apple_intelligence_stuck_downloading_for_over_a/
- https://forums.macrumors.com/threads/save-7gb-storage-per-device-by-disabling-apple-intelligence.2448265/page-7

1. Disable Apple Intelligence in System Settings
2. Boot into Recovery Mode
   - Press and Hold the power button until the Startup Options appear (System Volumes and the Options button appear)
   - `Options > Continue`
   - Select an administrator account > Enter password
3. Open Terminal (`Utilities menu > Terminal`)
   - `csrutil disable`
4. Shut Down
5. Boot into Recovery Mode Again
   - Press and Hold the power button until the Startup Options appear (System Volumes and the Options button appear)
   - `Options > Continue`
   - Select an administrator account > Enter password
6. Choose `Disk Utility > Right-click on 'Macintosh HD - Data' under 'Macintosh HD'` and choose Mount **(MOST IMPORTANT STEP)**
7. Quit Disk Utility
8. Open Terminal (`Utilities menu > Terminal`)
   - `ls /Volumes`
   - `cd /Volumes/"Macintosh HD - Data"`
   - `pwd`
   - `cd System/Library/AssetsV2`
   - `pwd`
   - `ls | grep -ie 'MobileAsset_UAF_FM*'`
   - `rm -rf com_apple_MobileAsset_UAF_FM_GenerativeModels`
   - `rm -rf com_apple_MobileAsset_UAF_FM_Visual`
   - `csrutil enable`
9. Restart
