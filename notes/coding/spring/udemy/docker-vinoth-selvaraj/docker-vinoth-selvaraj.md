# Table of Contents

- [Table of Contents](#table-of-contents)
- [Links](#links)
- [Docker Test Containers + Spring - Vinoth Selvaraj](#docker-test-containers--spring---vinoth-selvaraj)
  - [What is Docker](#what-is-docker)
  - [Install Verification](#install-verification)
  - [Docker Terminologies](#docker-terminologies)
  - [Docker System Prune](#docker-system-prune)
  - [Docker Commands](#docker-commands)
  - [Dockerfile Commands](#dockerfile-commands)
  - [Shell Form vs Exec Form](#shell-form-vs-exec-form)

# Links

https://github.com/vinsguru/docker-spring-webflux

https://vins-udemy.s3.amazonaws.com/docker-webflux/docker-commands.pdf

https://vins-udemy.s3.amazonaws.com/docker-webflux/linux-cheat-sheet.pdf

# Docker Test Containers + Spring - Vinoth Selvaraj

## What is Docker

Docker = An open source platform for

- Packaging applications and their dependencies
- Running dockerised applications in isolation
- Separating applications from the underlying host and hardware

## Install Verification

```
docker
docker version
docker ps
```

## Docker Terminologies

| Term       | Description                                                              |
| ---------- | ------------------------------------------------------------------------ |
| Dockerfile | Human readable instructions for the app to run (dependencies + run time) |
| Build      | Creating snapshot from Dockerfile                                        |
| Image      | Lightweight VM (Snapshot)                                                |
| Tag        | Image version                                                            |
| Container  | Running instance of image                                                |
| DockerHub  | Image Registry                                                           |

## Docker System Prune

```sh
# Remove everything (including images)
docker system prune -af
# Remove all stopped containers
docker system prune -f
```

## Docker Commands

| Command                                                                                   | Description                                                                                      |
| ----------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------ |
| `docker ps`                                                                               | Show list of RUNNING containers                                                                  |
| `docker ps -a`                                                                            | Show ALL containers (including exited ones)                                                      |
| `docker images` or `docker image ls`                                                      | Show the list of images you have in your machine                                                 |
| `docker run ${imageName}`                                                                 | Create a container of the image                                                                  |
| `docker run ${imageName} ${command}`                                                      | Create a container of the image and executes the command inside the container                    |
| `docker run -it ${imageName}`                                                             | Start container in INTERACTIVE mode <br> `-i` for stdin <br> `-t` for stdout and attach terminal |
| `docker run -it --name=myName ${imageName}`                                               | Assign name for container                                                                        |
| `docker pull ${imageName}`                                                                | Pull the image from DockerHub                                                                    |
| `docker start ${containerName}`                                                           | Starts a container                                                                               |
| `docker start -ia ${containerName}`                                                       | Starts a container, attach STDOUT/STDERR and forward signals, attach container's STDIN           |
| `docker rmi ${imageName}`                                                                 | Delete image                                                                                     |
| `docker start ${containerName}`                                                           | Start a container                                                                                |
| `docker stop ${containerName}`                                                            | Stop running container (might take some time)                                                    |
| `docker kill ${containerName}`                                                            | Kill running container at once                                                                   |
| `docker rm ${containerName}`                                                              | Remove container                                                                                 |
| `docker exec ${containerName} ${command}`                                                 | To start a command on a running container                                                        |
| Port Mapping                                                                              |                                                                                                  |
| `docker run -p host-port:container-port nginx`                                            | To map the host port to a container port                                                         |
| `docker run -p host-port-1:container-port-1 -p host-port-2:container-port-2 ${imageName}` | To map multiple ports for a container                                                            |
| Run Detached                                                                              |                                                                                                  |
| `docker run -d nginx`                                                                     | Run the docker container in detached mode                                                        |
| Access Container Logs                                                                     |                                                                                                  |
| `docker logs ${containerName}`                                                            | Access the container terminal output                                                             |
| `docker logs ${container-id}`                                                             | Access the container terminal output                                                             |
| Volume Mapping                                                                            |                                                                                                  |
| `docker run -v /host-path:/container-path ${imageName}`                                   | Map specific directory to a container directory. (use absolute paths)                            |
| `docker run -v $PWD/resources/docker:/container-path ${imageName}`                        | Map specific directory to a container directory. (use absolute paths)                            |
| `docker run -v /Users/same/temp1:/a/b/c -v /Users/same/temp2:/a/b/d ${imageName}`         | Map multiple host paths to container path                                                        |
| `docker run -v /host-path:/container-path:ro ${imageName}`                                | Share file system in read-only mode                                                              |
| `docker run -v /host-path/file.txt:/container-path/some.txt ${imageName}`                 | Share a single file                                                                              |
| Network                                                                                   |                                                                                                  |
| `docker network create ${customName}`                                                     | Creates a custom network (NO quotes needed)                                                      |
| `docker network ls`                                                                       | List all networks                                                                                |
| `docker run --name=nginx --network=${customName} nginx`                                   | Creates nginx container and places in the custom network network                                 |

## Dockerfile Commands

| Command                                             | Description                                                                                                      |
| --------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- |
| `FROM ${image}`                                     | The base image for your docker image. Any image should extend another image                                      |
| `ADD ${host-dir} ${container-dir}`                  | Adds files from your host directory to the image <br> ADD is more or less like COPY <br> ADD can also accept url |
| `COPY ${host-dir} ${container-dir}`                 | Adds files from your host directory to the image <br> ADD is more or less like COPY <br> ADD can also accept url |
| `RUN ${command}`                                    | Command to execute during the image build process. Useful to install any software or create directories etc      |
| `ENV ${key} ${value}`                               | Sets an environment variable                                                                                     |
| `WORKDIR ${path}`                                   | Creates a workspace / default working directory. If we ignore root directory / would be used.                    |
| `EXPOSE ${port}`                                    | Exposes port                                                                                                     |
| `CMD ${commandToExecuteWhenContainerStarts}`        | The command to be executed / process to be started when the container is created.                                |
| `ENTRYPOINT ${commandToExecuteWhenContainerStarts}` | The command to be executed / process to be started when the container is created.                                |

## Shell Form vs Exec Form

Shell form CREATES ANOTHER shell process
Exec form does NOT create another shell process

Shell form interpolates variables such as `${PATH}`
Exec form does NOT interpolate variables such as `${PATH}` (it will print out the string "${PATH}")

```
# Shell Form
CMD cat hello-world.txt
# Exec Form
CMD ["cat", "hello-world.txt"]
```
