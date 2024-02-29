# Table of Contents

- [Table of Contents](#table-of-contents)
- [Docker Compose](#docker-compose)
- [Commands](#commands)
  - [Entering Container](#entering-container)

# Docker Compose

- [Read more](https://docs.docker.com/compose/reference/)

```sh
docker ps

# docker compose build
# docker compose start
docker compose up --build

docker compose up
docker compose restart -t0
docker compose down -t0
```

```sh
docker compose down -v
docker compose down --rmi all -v
```

# Commands

## Entering Container

```
docker ps
docker exec -it <containerID> bash
docker exec -it <containerID> /bin/sh
```
