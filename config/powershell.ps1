# Create this file by typing `code $PROFILE` into Windows PowerShell and SAVING it
Invoke-Expression (&'C:\Users\Same\scoop\apps\starship\current\starship.exe' init powershell)
Import-Module posh-git
Import-Module posh-sshell
Import-Module git-aliases -DisableNameChecking
Set-Alias ssh "$env:ProgramFiles\git\usr\bin\ssh.exe"
Set-Alias ssh-agent "$env:ProgramFiles\git\usr\bin\ssh-agent.exe"
Set-Alias ssh-add "$env:ProgramFiles\git\usr\bin\ssh-add.exe"
Set-Alias python3 python
