# Table of Contents

- [Table of Contents](#table-of-contents)
- [Enter Boot Options](#enter-boot-options)
- [Powershell](#powershell)
- [View HEIC files](#view-heic-files)
- [Disable Bing Search Windows 10 Start Menu](#disable-bing-search-windows-10-start-menu)
- [Shutdown Event Tracker](#shutdown-event-tracker)
- [Restart WSL](#restart-wsl)

# Enter Boot Options

- Hold Shift key while clicking restart

# Powershell

```
Set-ExecutionPolicy -Scope LocalMachine -ExecutionPolicy RemoteSigned -Force
```

# View HEIC files

- Run command prompt as admin
  ```
  start ms-windows-store://pdp/?ProductId=9n4wgh0z6vhq
  ```

# Disable Bing Search Windows 10 Start Menu

- Navigate to

  ```
  Computer\HKEY_CURRENT_USER\Software\Policies\Microsoft\Windows
  ```

- Create new Key in "Windows" folder

  ```
  Name = Explorer
  ```

- Create new DWORD 32-Bit Value in "Explorer" Folder

  ```
  Name = DisableSearchBoxSuggestions
  Value = 1
  ```

- Restart PC

# Shutdown Event Tracker

- Navigate to

  ```
  HKEY_LOCAL_MACHINE\SOFTWARE\Policies\Microsoft\Windows NT\Reliability
  ```

- If "Reliability" Folder does NOT exist already, then create new Key in "Windows NT" folder

  ```
  Name = Reliability
  ```

- Create new DWORD 32-Bit Value in "Reliability" Folder

  ```
  Name = ShutdownReasonOn
  Value = 1
  ```

- Create new DWORD 32-Bit Value in "Reliability" Folder

  ```
  Name = ShutdownReasonUI
  Value = 1
  ```

- Restart PC

# Restart WSL

- Run Windows PowerShell as Admin

```
Get-Service LxssManager | Restart-Service
```
