# Table of Contents

- [Table of Contents](#table-of-contents)
- [Port Numbers](#port-numbers)
  - [View Port Numbers Used](#view-port-numbers-used)
  - [Find Process ID Associated with Port](#find-process-id-associated-with-port)
  - [Kill Process (PID)](#kill-process-pid)
  - [Check if Service is Listening on Specific Port](#check-if-service-is-listening-on-specific-port)

# Port Numbers

```
sudo apt install -y net-tools
sudo apt install -y nc
```

- Use `127.0.0.1` instead of `localhost`

## View Port Numbers Used

```sh
# Displays all TCP and UDP connections with their corresponding port numbers
netstat -tuln
```

```sh
ss -tuln
```

```sh
# View every process on system using standard/BSD syntax
ps aux | ps -ef
# View every process on system associated with TTY (terminal)
ps -t
# VIew process based on regexp
ps -ef | grep -En 'regxp'
# View process name based on PID
ps -ef | grep -En <PID>
```

## Find Process ID Associated with Port

```sh
# `lsof` lists all open files and displays the process ID (PID) associated with the specified port
sudo lsof -i :<port_number>
```

## Kill Process (PID)

```sh
sudo kill <PID>
# -9 = SIGKILL
sudo kill -9 <PID>
# ps -ef | grep <name> && kill -9 <PID>
```

```sh
sudo fuser -k <port_number>/tcp
```

## Check if Service is Listening on Specific Port

- Check if a web server is running on the host "example.com" and listening on port 80

```sh
nc -vz example.com 80
```
