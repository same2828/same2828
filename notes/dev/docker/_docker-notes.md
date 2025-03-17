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
docker compose down -t0 --rmi all -v
```

```sh
docker compose -f ${ABSOLUTE_FILE_PATH_TO_DOCKER-COMPOSE.YML_FILE_NO_QUOTES} up -d
docker compose -f /Users/${username}/dev/docker/docker-compose.yml up -d

docker compose -f ${ABSOLUTE_FILE_PATH_TO_DOCKER-COMPOSE.YML_FILE_NO_QUOTES} down -t0
docker compose -f /Users/${username}/dev/docker/docker-compose.yml down -t0
```

# Commands

## Entering Container

```
docker ps
docker exec -it <containerID> bash
docker exec -it <containerID> /bin/sh
```
