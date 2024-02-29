# Table of Contents

- [Table of Contents](#table-of-contents)
- [GCC](#gcc)
- [GDB](#gdb)
- [Permission denied (shell script sh)](#permission-denied-shell-script-sh)

# GCC

```c
// This changes all "warning" flags to "error" flags
gcc -Wall -Werror programName.c -o ProgramName

```

```c
// -g for gdb
gcc -Wall -Werror -g -o myProg myProg.c
```

# GDB

```c
gdb -q ./tw
// Create a breakpoint on line 99 in tw.c
b tw.c:99 // Can also be done via "break tw.c:99"
// "data/0011.txt" is the extra command line that you would normally include (same as ./tw data/0011.txt)
run data/0011.txt
// Move onto next line
n
// Shows where the error occurs
where
list
info locals
// Enter specific frame shown by ‘where'
frame 7
// Continues running code as usual
continue
// Moves up a stack
up
```

# Permission denied (shell script sh)

```
chmod 755 _.sh
chmod +x _.sh
Do "sh ./autotest" instead of "./autotest"
```
