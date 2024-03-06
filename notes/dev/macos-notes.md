# Table of Contents

- [Table of Contents](#table-of-contents)
- [Dev Setup](#dev-setup)
  - [Apps](#apps)
    - [Mounty](#mounty)
  - [External Display/Monitor](#external-displaymonitor)
  - [Finder](#finder)
    - [General + Toolbar](#general--toolbar)
    - [Increase Font Size](#increase-font-size)
    - [Windows Explorer Filename Sorting](#windows-explorer-filename-sorting)
  - [Keyboard](#keyboard)
    - [Prevent Accented Characters + Remove Input Menu from Menu Bar](#prevent-accented-characters--remove-input-menu-from-menu-bar)
    - [Keyboard Remap](#keyboard-remap)
  - [System Settings](#system-settings)
    - [Hot Corners](#hot-corners)
  - [Terminal Commands](#terminal-commands)
    - [System Settings](#system-settings-1)
    - [Dev Environment](#dev-environment)
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

# Dev Setup

## Apps

- [AppCleaner](https://freemacsoft.net/appcleaner/)
- [BetterDisplay](https://github.com/waydabber/BetterDisplay/releases)
- [Flux](https://justgetflux.com/) Note: `Menu Bar > Options` > Turn ON "Expanded daytime settings" > 2300K
- [IINA](https://github.com/iina/iina/releases)
- [Karabiner-Elements](https://karabiner-elements.pqrs.org/)
- [Keka](https://www.keka.io/en/)
- [LinearMouse](https://github.com/linearmouse/linearmouse/releases)
- [MiddleClick](https://github.com/artginzburg/MiddleClick-Sonoma)
- [Mounty](https://mounty.app/)
- [OpenMTP](https://github.com/ganeshrvel/openmtp/releases)
- [Rectangle](https://rectangleapp.com/)

- Alfred
- App Cleaner & Uninstaller
- Moom
- PDF Expert
- Radio Silence
- SoundSource
- TextSniper

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

## System Settings

`System Settings > Privacy & Security > Full Disk Access` > iTerm2 + Visual Studio Code

`System Settings > Privacy & Security > Developer Tools` > iTerm2 + Visual Studio Code

`System Settings > Desktop & Dock > Minimise windows using` > Scale Effect

`System Settings > Desktop & Dock > Desktop & Stage Manager > Click wallpaper to reveal desktop` > Only in Stage Manager

### Hot Corners

`System Settings > Desktop & Dock > Hot Corner Shortcuts > Bottom Right` > Hold down `Shift` key + "Mission Control"

- Trigger only with modifier key = HOLD down key of choice when clicking corner option
  - `Shift + Mission Control` for `Bottom-Right` corner

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

# Lock Dock Contents
defaults write com.apple.dock contents-immutable -bool true; killall Dock

# Lock Dock Position
defaults write com.apple.dock position-immutable -bool true; killall Dock

# Faster Docker Hiding
defaults write com.apple.dock autohide-delay -float 0; defaults write com.apple.dock autohide-time-modifier -int 0;killall Dock
defaults write com.apple.dock autohide-delay -float 0.5; defaults write com.apple.dock autohide-time-modifier -int 0.5 ;killall Dock

# Add Dock Spacer
defaults write com.apple.dock persistent-apps -array-add '{tile-data={}; tile-type="spacer-tile";}' && killall Dock

# Add Half Height Docker Spacer
defaults write com.apple.dock persistent-apps -array-add '{"tile-type"="small-spacer-tile";}' && killall Dock
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
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Follow the "Next Steps" Info > Enter Commands Listed
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

# OhMyZsh > https://github.com/ohmyzsh/ohmyzsh
brew install curl && brew install fetch && brew install wget && brew install git
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"

# OhMyZsh Plugins
cd ~/.oh-my-zsh/custom/plugins
git pull
git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
git clone https://github.com/zsh-users/zsh-history-substring-search ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-history-substring-search
cd

# Starship + .zshrc
brew install starship && brew install node@20
brew link node@20 --overwrite
mkdir ~/.ssh && code ~/.zshrc
# Copy paste github/config/.zshrc-macos (make sure all "/home/linuxbrew/.linuxbrew/" is changed to "/opt/homebrew/" in .zshrc)

# Starship Prompt Customisation
mkdir -p ~/.config && touch ~/.config/starship.toml && code ~/.config/starship.toml
# Copy paste github/config/starship-macos.toml

# Other brew installs
brew install clang-format && brew install cmake && brew install coreutils && brew install jq && brew install tldr && brew install tree
brew install llvm

# GCC
brew install gcc
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

# Adoptium OpenJDK (Eclipse Temurin) > https://adoptium.net/installation/
brew tap homebrew/cask-versions
brew install --cask temurin
# brew install --cask temurin21
```

#### Git

```sh
code ~/.gitconfig
# Copy paste github/config/.gitconfig
```

#### SSH Keys

```sh
# Create SSH Key
ssh-keygen -t ed25519 -C "samsolichin01@gmail.com"
/Users/same/.ssh/github-samsolichin
eval "$(ssh-agent -s)"
code ~/.ssh/config
# Copy paste github/config/ssh-config-wsl

# Add SSH Key to ssh-agent
ssh-add ~/.ssh/github-samsolichin

# Add SSH Key to GitHub Account
cat ~/.ssh/github-samsolichin.pub
# Copy paste into GitHub Account Settings > https://github.com/settings/keys

# Test SSH Key
ssh -T git@github.com
# Enter "yes" when prompted "Are you sure you want to continue connecting (yes/no)?"
```

[GitHub Docs](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)

## Web Browser Extensions

- Dark Reader
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

`open` = `explorer` on windows

```
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
