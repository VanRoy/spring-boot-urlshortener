# Hands-on Spring Boot

Ce hands-on à pour but de presenter Spring Boot.

Il contient une presentation de quelques slides ainsi qu'une application de demonstration.


## Instructions

### Branches

| Branche           | Fonctionnalité                          |
| --------          | --------                                |
| master            | Slides et version finale de la demo     |
| step/01-init      | Initialisation du projet                |
| step/02-rest      | Ajout du service REST                   |
| step/03-data      | Ajout du repository MongoDB             |
| step/04-ui        | Ajout de l'interface Web Thymeleaf      |
| step/05-config    | Ajout de la configuration externalisée  |
| step/06-container | Passage au container Undertow           |
| step/07-actuator  | Ajout des endpoint REST de monitoring   |

### Prérequis

Cette démo necessite un JDK 7 ainsi que Maven > 3.0.

### Lancement de mongodb
```
#mvn embedmongo:start -Dembedmongo.wait
```

### Lancement de l'application
```
# mvn spring-boot:run
```
