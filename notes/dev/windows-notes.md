# Table of Contents

- [Table of Contents](#table-of-contents)
- [Windows Setup](#windows-setup)
  - [Motherboard](#motherboard)
    - [CPU Configuration](#cpu-configuration)
    - [PCH Configuration](#pch-configuration)
    - [Fans](#fans)
    - [Overclock Ram](#overclock-ram)
  - [Windows](#windows)
    - [BIOS](#bios)
    - [Wipe Disks + Convert MBR to GPT Disk Partition Style](#wipe-disks--convert-mbr-to-gpt-disk-partition-style)
    - [Bypass Creating Online Account](#bypass-creating-online-account)
    - [Initialise Second Hard Disk Drive (HDD)](#initialise-second-hard-disk-drive-hdd)
    - [Power Options](#power-options)
      - [Change What Power Buttons Do](#change-what-power-buttons-do)
      - [Disable Fast Startup](#disable-fast-startup)
      - [High Performance Mode](#high-performance-mode)
      - [Prevent Ethernet from Waking PC from Sleep](#prevent-ethernet-from-waking-pc-from-sleep)
      - [Turn On All Processors](#turn-on-all-processors)
    - [Calendar](#calendar)
    - [File Explorer](#file-explorer)
    - [HEIF/HEVC Plugins](#heifhevc-plugins)
    - [Keyboard](#keyboard)
      - [Disable `Left Alt + Shift` Shortcut](#disable-left-alt--shift-shortcut)
      - [Disable Start Narrator Shortcut](#disable-start-narrator-shortcut)
      - [Disable Sticky Keys](#disable-sticky-keys)
      - [Enable Print Screen Shortcut to Open Screen Snipping](#enable-print-screen-shortcut-to-open-screen-snipping)
      - [Hide Input in Taskbar](#hide-input-in-taskbar)
    - [Mouse](#mouse)
    - [System Properties/Environment Variables](#system-propertiesenvironment-variables)
    - [DNS](#dns)
  - [Apps](#apps)
    - [7-Zip](#7-zip)
    - [Google Chrome](#google-chrome)
      - [uBlock Origin Filter](#ublock-origin-filter)
    - [ffmpeg (Convert mp4 to mp3)](#ffmpeg-convert-mp4-to-mp3)
    - [Firefox](#firefox)
    - [MSI Afterburner](#msi-afterburner)
    - [NVIDIA Graphics Driver](#nvidia-graphics-driver)
    - [PotPlayer Media Player](#potplayer-media-player)
    - [Task Manager](#task-manager)
    - [yt-dlp](#yt-dlp)
  - [Taskbar](#taskbar)
- [Dev Setup](#dev-setup)
  - [WSL](#wsl)
    - [Install WSL](#install-wsl)
    - [Update WSL](#update-wsl)
    - [Restart WSL](#restart-wsl)
    - [Troubleshoot WSL](#troubleshoot-wsl)
  - [Terminal Commands for Dev Environment](#terminal-commands-for-dev-environment)
    - [OhMyZSH](#ohmyzsh)
  - [Git](#git)
    - [SSH Keys](#ssh-keys)
    - [Update Git for Windows](#update-git-for-windows)
  - [Fonts](#fonts)
  - [Web Browser Extensions](#web-browser-extensions)
- [Tips/Tricks](#tipstricks)
- [Cleanup Nvidia GeForce Drivers](#cleanup-nvidia-geforce-drivers)
  - [Diskpart](#diskpart)
  - [Enter Boot Options](#enter-boot-options)
  - [Troubleshooting](#troubleshooting)

# Windows Setup

## Motherboard

### CPU Configuration

`Hyper-Threading` > Enable

`Active Processor Cores` > All

`Intel Virtualization Technology` > Enable

### PCH Configuration

`Intel Rapid Start Technology` > Disable

`Intel Smart Connect Technology` > Disable

### Fans

DC Mode

Minimum Speed > 400 RPM

### Overclock Ram

**Enable XMP Profile**

- Speed (DRAM Frequency): 1600 MHZ
- Timing (DRAM Timing Control)
  - tCL: 9
  - tRCD: 9
  - tRP: 9
  - tRAS: 24
  - tRC: 33
  - Command Rate: 2
- Voltage (DRAM Voltage): 1.5V
- To see recommended settings for RAM
  - Tool > Asus SPD Information
  - Cycle through DIMM Slot Numbers
- Links
  - http://blackholetec.com/main/article/kingston-ddr3-8gb-value-ram-1600mhz-review-page-3

## Windows

### BIOS

Turn OFF: "CSM (Compatibility Support Module)" boot option

Turn ON: "TPM" + "Secure Boot" boot options

### Wipe Disks + Convert MBR to GPT Disk Partition Style

- [Create installation media for Windows](https://support.microsoft.com/en-us/windows/create-installation-media-for-windows-99a58364-8c02-206f-aa6f-40c3b507420d)
- Plug USB into PC > Restart PC > Boot to USB (alternatively hold `Shift` key when clicking `Restart` on Lock Screen)
  - `Enter Bios (F2 or Delete) > Override Startup Disk > UEFI Windows Installation Media USB`
- Wipe All Drives: `Windows Installer > Shift + F10 > Windows Command Prompt`
  ```powershell
  diskpart
  list disk
  select disk 0
  clean
  convert GPT
  # create partition primary
  select disk 1
  clean
  convert GPT
  exit
  # Not necessary to use `clean all`
  ```
- **DISCONNECT all other internal drives before installing Windows to prevent "EFI System Partition" from being randomly created on other internal drives**
  - We want ALL of Window's "System Partitions" to be created on the SINGLE SSD that contains the main Windows installation
- Restart PC again
- Click "New" button when shown the "Unallocated" SSD and Windows installer will automatically create 3 partitions on your SSD

### Bypass Creating Online Account

Method 1

- Disconnect internet (optional but preferred)
- Enter fake email `user@user.com` and password `pwd` > proceed to create local account

Method 2

- Use [Rufus](https://rufus.ie/en/)

### Initialise Second Hard Disk Drive (HDD)

`Disk Management > Right Click on HDD > Format`

- File System = NTFS
- Allocation Size = Default
- Perform Quick Format
- Do NOT enable "file and folder compression"

### Power Options

#### Change What Power Buttons Do

`Control Panel > Hardware and Sound > Power Options > Choose what the power buttons do > When I press the power + sleep button` > Sleep

#### Disable Fast Startup

`Control Panel > Hardware and Sound > Power Options > Choose what the power buttons do > Change settings that are currently unavailable` > Turn OFF "Fast Startup"

#### High Performance Mode

`Control Panel > Power Options` > High Performance

`High Performance > Change Plan Settings > Change Advanced Power Settings > Processor Power Management > Minimum Processor State` > 100%

Alternatively set using "Wintoys" app

#### Prevent Ethernet from Waking PC from Sleep

`Device Manager > Network Adapters > Intel(R) Ethernet Connection > Properties > Power Management` > UNTICK "Allow this device to wake the computer"

#### Turn On All Processors

`msconfig > Boot > Advanced Options > Tick "Number of Processors" > Choose maximum number of processors` > Restart PC

### Calendar

Change Calendar Format to Australian: `Settings > Time & Language > Region > Regional Format` > English (Australia)

### File Explorer

`View` > ENABLE "Hidden items" + "File name extensions"

`View` > DISABLE "Item check boxes"

`View > Group by` > None

### HEIF/HEVC Plugins

HEIF: [Download from Microsoft Store](https://apps.microsoft.com/detail/9PMMSR1CGPWG?hl=en-us&gl=US)
HEVC: Download [K-Lite Codec Pack Full Version](https://www.codecguide.com/download_kl.htm)

https://www.codecguide.com/media_foundation_codecs.htm

[Lowkey shady link](https://codecpack.co/download/hevc-video-extensions.html)

### Keyboard

#### Disable `Left Alt + Shift` Shortcut

`Settings > Devices > Typing > Advanced Keyboard Settings > Input language hot keys > Advanced Key Settings > Between Input Languages > Change Key Sequence` > Not Assigned > Apply

#### Disable Start Narrator Shortcut

`Settings > Ease of Access > Narrator` > Turn OFF: Use Narrator + Allow the shortcut key to start Narrator

#### Disable Sticky Keys

`Settings > Ease of Access > Use Sticky Keys` > Untick: Allow shortcut key

#### Enable Print Screen Shortcut to Open Screen Snipping

`Settings > Ease of Access` > Tick: Print Screen Shortcut

#### Hide Input in Taskbar

`Settings > Personalization > Taskbar > Turn system icons on or off` > Turn OFF: Input Indicator

`Settings > Personalization > Taskbar > Combine buttons on other taskbars` > Choose "Always, hide labels"

### Mouse

`Mouse Settings > Additional mouse options > Buttons` > Double-click speed = 7th speed

`Mouse Settings > Additional mouse options > Pointer Options` > Turn OFF: "Enhance Pointer Precision"

`Mouse Settings > Additional mouse options > Pointer Options` > Pointer Speed = 6th speed

`Mouse Settings > Additional mouse options > Wheel` > Vertical + Horizontal Lines = 3

### System Properties/Environment Variables

`Edit System Environment Variables > "Remote" Tab` > Turn OFF: Allow Remote Assistance Connections

`Edit System Environment Variables > "Advanced" Tab > Environment Variables` > Remove: OneDrive from Path

### DNS

Method 1: `Taskbar > Right-click on Wifi > Open Network & Internet Settings > Change Adapter Options > Right-click on network-adapter > Properties` > Change IPv4 + IPv6

Method 2: `Control Panel > Network and Internet > Network and Sharing Center > Change Adapter Options > Right-click on network-adapter > Properties` > Change IPv4 + IPv6

```sh
# IPv4
1.1.1.1
1.0.0.1
# IPv6
2606:4700:4700::1111
2606:4700:4700::1001
```

[Cloudflare 1.1.1.1](https://1.1.1.1/dns/)

## Apps

Open the **Microsoft Store** app and **UPDATE ALL APPS**

- Deemix
- [7-Zip](https://www.7-zip.org/download.html)
- [balenaEtcher](https://etcher.balena.io/)
- [CCleaner](https://www.ccleaner.com/ccleaner/download)
- [Equalizer APO](https://sourceforge.net/projects/equalizerapo/)
- [ffmpeg](https://ffmpeg.org/)
- [Git Bash](https://git-scm.com/download/win)
- [Internet Download Manager (IDM)](https://www.internetdownloadmanager.com/download.html)
- [mp3DirectCut](https://mpesch3.de/)
- [mp3Tag](https://www.mp3tag.de/en/download.html)
- [MSI-Afterburner](https://www.msi.com/Landing/afterburner/graphics-cards)
- [PDF-XChange](https://pdf-xchange.eu/pdf-xchange-editor/)
- [PotPlayer](https://potplayer.daum.net/)
- [PowerToys](https://learn.microsoft.com/en-us/windows/powertoys/install)
- [ScreenToGif](https://www.screentogif.com/)
- [ShareX](https://getsharex.com/)
- [Spotube](https://github.com/KRTirtho/spotube)
- [SpotX](https://github.com/SpotX-Official/SpotX/releases)
- [Text-Grab](https://github.com/TheJoeFin/Text-Grab/releases)
- [Windows Clock](https://apps.microsoft.com/detail/9WZDNCRFJ3PR?hl=en-us&gl=US)
- [Windows Terminal](https://apps.microsoft.com/detail/9N0DX20HK701?hl=en-US&gl=US)
- [Wintoys](https://apps.microsoft.com/detail/9P8LTPGCBZXD?hl=en-US&gl=US)
- [yt-dlp](https://github.com/yt-dlp/yt-dlp)

- [Samsung Magician](https://semiconductor.samsung.com/consumer-storage/support/tools/)
  - Make sure to "Remove from starup" by right-clicking icon

### 7-Zip

`Settings > Apps > Default Apps > Choose default apps by file type > .zip` > Choose `7zFM.exe` and NOT `7z.exe`

### Google Chrome

Open Incognito Default

- `Right click Google Chrome in taskbar twice (2x) > Navigate to Properties` > Add ` --incognito` to end of "Target:" string
  - Target: `"C:\Program Files\Google\Chrome\Application\chrome.exe" --incognito`

#### uBlock Origin Filter

```
! www.linkedin.com##li:has-text(Promoted)
drive.google.com###nt\:D > .a-U-xc-J.a-U-J
leetcode.com##.css-14oi7nj-StyledCard
leetcode.com##.css-te1yc9-InnerStyledCard
leetcode.com##.note-btn__uLJR
www.levels.fyi##tr:has-text(Promoted)
www.lintcode.com##.ai-chat-item-GQi81
www.lintcode.com##.invite-btn-xlfpt
www.lintcode.com##.left-KM5H1 > .ad-O2n3f.advertisement-WtYpF
www.lintcode.com##.problem-list-advertisement-mZGOP.advertisement-WtYpF
www.lintcode.com##.react-draggable.ball-img-FVTro
www.lintcode.com##div.func-button-fPxXx > .ant-btn-primary.ant-btn
www.youtube.com##.ytd-rich-section-renderer.style-scope > .ytd-rich-shelf-renderer.style-scope
www.youtube.com##.ytp-cards-teaser
www.youtube.com##.ytp-ce-element
www.youtube.com##.ytp-featured-product-container
www.youtube.com##ytd-horizontal-card-list-renderer.ytd-item-section-renderer.style-scope
```

### ffmpeg (Convert mp4 to mp3)

Download windows exe file and drag the "ffmpeg.exe" file into the same folder as the video file you want to convert

```sh
# Example Usage
cd "D:\Chrome Download"
.\ffmpeg.exe -i videoFileInput.mp4 audoFileOutput.mp3
```

### Firefox

Change Zoom Levels

- `URL Bar > about:config > zoom > toolkit.zoomManager.zoomValues > .3,.5,.67,.8,.9,1,1.1,1.25,1.33,1.5,1.75,2,2.25,2.5,2.75,3.4,3,4,5`

Enable Performance Mode

- `Settings > General > Performance` > UNTICK "Use recommended performance settings" + Leave ON "Use hardware acceleration when available"

Enable DNS over HTTPS

- `about:preferences > Privacy & Security > DNS over HTTPS > Increased Protection > Cloudflare`

### MSI Afterburner

Set Skin

- `Settings > User Interface > Skin > MSI Ampere`

Create Profile and Load on Startup

- Turn OFF "Auto" by clicking on the "A" icon
- Turn ON "User Define" by clicking on "user" icon
- Set fan speed to `50` > Click the "tick" icon > Click "save" icon > Click "Profile 1"
- Set fan speed to `50` > Click the "tick" icon > Click "save" icon > Click "Profile 2"
- Switch between Profile 1 and Profile 2 to ensure fan speed settings have saved properly
- Click Profile 1
- Click Windows icon (top right corner)

Theme

- `Settings > User Interface` > MSI Ampere Afterburner skin by Drerex Design

### NVIDIA Graphics Driver

**536.67** is the upper bound of graphics drivers that does NOT cause monitor "no signal" upon restart

- 536.23 also works

- [Search for "Nvidia Driver History"](https://www.nvidia.com/download/find.aspx)

### PotPlayer Media Player

`Settings > Playback > Time Jump` > Untick: "Jump to keyframe"

`Settings > General` > Stay on top: Never

`Settings > General` > Untick: "Auto download files if an update is available"

### Task Manager

`Options > Always on Top`

### yt-dlp

```sh
# Example Usage
.\yt-dlp.exe -f mp3 "https://www.youtube.com/watch?v=MjE5_JnNslk"
.\yt-dlp.exe -f "mp4[height=720]" -x --audio-format mp3 --audio-quality 128k "https://www.youtube.com/watch?v=lTRiuFIWV54"
```

## Taskbar

- File Explorer
- Chrome
- Firefox
- IDM
- Dynalist
- VSCode
- Windows Terminal
- Text-Grab
- Paint3D
- Sublime Text
- Calculator
- Postman
- mp3DirectCut
- Obsidian
- Excel
- Spotify

# Dev Setup

## WSL

### Install WSL

Step 1: Enable Virtualisation in BIOS

Step 2: `Turn Windows Features On or Off` > Turn ON: "Virtual Machine Platform" + "Windows Subsystem for Linux"

Step 3: Run Windows PowerShell as Admin

    ```sh
    # Turn on Windows Features
    dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
    dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
    # Download Linux Kernel Update Package > https://learn.microsoft.com/en-us/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package
    # Run `wsl --update` until no more updates occur
    wsl --update
    wsl --set-default-version 2
    # Ubuntu 20.04 LTS
    wsl -l -o # wsl --list --online
    wsl --install -d Ubuntu-20.04
    wsl -l -v # wsl --list --verbose
    wsl --set-version Ubuntu-20.04 2
    ```

**Post Installation Steps**

```sh
# Update & Upgrade Packages
sudo apt update --fix-missing && sudo apt upgrade --fix-missing -y && sudo apt autoremove -y && sudo apt autoclean -y
# Disable MOTD/Login Message
touch ~/.hushlogin
# Open WSL Folder in Windows File Explorer > Add Root Folder to Quick Access
explorer.exe .
```

### Update WSL

Run Windows PowerShell as Admin

```sh
wsl --update
```

### Restart WSL

Run Windows PowerShell as Admin

```sh
wsl --shutdown
# OR
Get-Service LxssManager | Restart-Service
```

### Troubleshoot WSL

```sh
wsl --unregister <distroName>
# Restart PC
```

## Terminal Commands for Dev Environment

- [Install VSCode](https://code.visualstudio.com/download)
  - `Ctrl + P > Shell Command: Install 'code' command in PATH`
- [Install Nerd Font](https://www.nerdfonts.com/font-downloads)
  - Fonts
    - Inconsolata LGC Nerd Font Mon LGCo
    - CodeNewRoman Nerd Font Mono
    - RobotoMono Nerd Font Mono
  - Click on file to install
  - Note: Be careful of the name that the system gives to the font once installed i.e. "Inconsolata LGC Nerd Font Mono" instead of "InconsolataLGC Nerd Font Mono LGC"
- [Install Windows Terminal](hhttps://www.microsoft.com/store/productId/9N0DX20HK701?ocid=pdpshare)
  - Copy `github/config/windows-terminal.json`
- [Install Linuxbrew](https://brew.sh/)
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
(echo; echo 'eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"') >> /home/same/.bashrc
eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"
sudo apt-get install build-essential

# Turn OFF Analytics
brew analytics off

# Specific linuxbrew commands > https://docs.brew.sh/Homebrew-on-Linux
test -d ~/.linuxbrew && eval "$(~/.linuxbrew/bin/brew shellenv)"
test -d /home/linuxbrew/.linuxbrew && eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"
echo "eval \"\$($(brew --prefix)/bin/brew shellenv)\"" >> ~/.zprofile
# echo "eval \"\$($(brew --prefix)/bin/brew shellenv)\"" >> ~/.zshrc

# Set Homebrew Zsh as Default Shell
brew install zsh
which zsh
# Output should be "/home/linuxbrew/.linuxbrew/bin/zsh"
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
# Copy paste github/config/.zshrc-wsl (make sure all "/home/linuxbrew/.linuxbrew/" is changed to "/opt/homebrew/" in .zshrc)

# Starship Prompt Customisation
mkdir -p ~/.config && touch ~/.config/starship.toml && code ~/.config/starship.toml
# Copy paste github/config/starship-wsl.toml

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

# Other brew installs
brew install clang-format && brew install cmake && brew install coreutils && brew install jq && brew install tldr && brew install tree && brew install python
brew install llvm

# Install Adoptium OpenJDK (Eclipse Temurin) > https://adoptium.net/installation/linux/ > https://askubuntu.com/questions/1157417/install-adoptopenjdk-adoptium-onto-ubuntu
sudo apt install -y wget apt-transport-https gpg
sudo wget -qO - https://packages.adoptium.net/artifactory/api/gpg/key/public | sudo gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/adoptium.gpg > /dev/null
sudo echo "deb https://packages.adoptium.net/artifactory/deb $(awk -F= '/^VERSION_CODENAME/{print$2}' /etc/os-release) main" | sudo tee /etc/apt/sources.list.d/adoptium.list
sudo apt update && sudo apt upgrade
sudo apt install temurin-17-jdk
java --version
```

### OhMyZSH

```sh
# Install & paste github/config/.zshrc
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
# Custom theme
cp $ZSH/themes/robbyrussell.zsh-theme $ZSH_CUSTOM/themes/
code ZSH_CUSTOM/themes/robbyrussell.zsh-theme
```


## Git

```sh
code ~/.gitconfig
# Copy paste github/config/.gitconfig
```

### SSH Keys

```sh
# Create SSH Key
ssh-keygen -t ed25519 -C "samsolichin01@gmail.com"
/home/same/.ssh/github-samsolichin
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

### Update Git for Windows

Run Windows PowerShell as Admin

```sh
git update-git-for-windows
```

## Fonts

[Google Fonts](https://fonts.google.com/?sort=popularity)
[FontForge](https://fontforge.org/en-US/downloads/windows-dl/)

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

Naming Scheme

- "S" = Square Brackets [] (copied from Inconsolata LGC)
- "P" = Parentheses () (copied from Inconsolata LGC)
- "B" = Braces {} (copied from Inconsolata LGC)
- "EQ" = Equality <> (copied from Inconsolata LGC)
- "AT" = @ (copied from Roboto)

```
@ (for RobotoLGC)
# Version 1
Scale: 150% x, 125% y (Transform Width)
Move: -300 y
# Version 2
Move: 100 y (copied from Roboto)

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
Move: -75y (for RobotoLGC)
Move: -25y (for InconsolataLGC)

"#$%'/0\_|
Scale Uniformly: 200.49% (Origin = Glyph Origin) (Transform Width) (copied from Inconsolata LGC)

`
Scale: 175% x, 100y
Move: 75 y
Used PowerToy's Screen Ruler to make top and bottom lengths equal

<>
Scale Uniformly: 200.49% (Origin = Glyph Origin) (Transform Width) (copied from Inconsolata LGC)
```

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

# Tips/Tricks

# Cleanup Nvidia GeForce Drivers

`C:\Program Files\NVIDIA Corporation\Installer2`

- Can delete everything inside the folder but NOT the folder itself

`C:\ProgramData\NVIDIA Corporation\Downloader`

- Delete everything EXCEPT for "config" folder and "status.json"

## Diskpart

Usage of Balena Etcher will fuck up a USB

Open command prompt

```sh
diskpart
list disk
select disk N
clean
format fs=ntfs quick
create partition primary
select partition 1
```

## Enter Boot Options

`Lock Screen > Hold Shift Key > Click Restart`

## Troubleshooting

Fix problems that block programs from being installed or removed

- [Microsoft Uninstaller Helper/Troubleshooter](https://support.microsoft.com/en-us/topic/fix-problems-that-block-programs-from-being-installed-or-removed-cca7d1b6-65a9-3d98-426b-e9f927e1eb4d)
