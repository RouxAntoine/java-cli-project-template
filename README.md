# Java CLI project template

Probably the fastest way to bootstrap a **Java** Command Line Application (**CLI**) project!

Click the big green *Use This Template* button and start building your own CLI.

## 🤩 Highlights

- uses [Picocli](https://picocli.info/) for simple and elegant commands implementation
- builds to an **executable jar** and **GraalVM Native Image**
- preconfigured `help` and `version` commands
- generates Bash/ZSH autocompletion scripts
- uses **Maven** as a build tool
- **no frameworks** like Spring, Micronaut or Quarkus

## 🛠 Requirements

- GraalVM distribution of Java (easy to install with https://sdkman.io/)

## 🤔 How to use

Run tests & build an executable JAR:

```shell
$ ./mvnw package
```

Run tests as native image & build a native executable:

```shell
$ ./mvnw package -Pnative
```

Run application through Maven

```shell
$ ./mvnw -Dexec.args=--help
```

Build container in local docker daemon

```shell
$ ./mvnw -Pnative clean verify jib:dockerBuild -Dimage=org.example.registry/app:latest -Djib.dockerClient.executable=/opt/homebrew/bin/docker.lima
```

Sounds good? Consider [❤️ Sponsoring](https://github.com/sponsors/maciejwalkowiak) the project! Thank you!
