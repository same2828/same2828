# cp $ZSH/themes/robbyrussell.zsh-theme $ZSH_CUSTOM/themes/
# code $ZSH_CUSTOM/themes/robbyrussell.zsh-theme

# PROMPT='%{$fg_bold[cyan]%}%~%{$reset_color%} $(git_prompt_info)
# %(?:%{$fg_bold[green]%}%1{➜%} :%{$fg_bold[red]%}%1{➜%} )'
PROMPT='%{$fg_bold[cyan]%}%~%{$reset_color%} $(git_prompt_info)
%(?:%{$fg_bold[green]%}%1{☁️%} :%{$fg_bold[red]%}%1{☁️%} ) '

RPROMPT='%{$fg_bold[white]%}%D{%-I:%M:%S%P - %d/%m}'
# RPROMPT='%{$fg_bold[white]%}%D{%-I:%M:%S%p - %d/%m}' # macOS

ZSH_THEME_GIT_PROMPT_PREFIX="on %{$fg_bold[blue]%}%{$fg[magenta]%}"
ZSH_THEME_GIT_PROMPT_SUFFIX="%{$reset_color%} "
ZSH_THEME_GIT_PROMPT_DIRTY="%{$fg[blue]%} %{$fg[red]%}%1{[!]%}"
ZSH_THEME_GIT_PROMPT_CLEAN="%{$fg[blue]%}"
