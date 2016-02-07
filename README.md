# Démonstration Spring Boot

Ce projet à pour but de presenter Spring Boot.

Il contient une presentation de quelques slides ainsi qu'une application de demonstration.


## Instructions

### Branches

| Branche                            | Fonctionnalité                          |
| --------                           | --------                                |
| master                             | Slides et version finale de la demo     |
| instructions/01-init               | Initialisation du projet                |
| instructions/02-rest               | Ajout du service REST                   |
| instructions/03-data               | Ajout du repository MongoDB             |
| instructions/04-ui                 | Ajout de l'interface Web Thymeleaf      |
| instructions/05-config             | Ajout de la configuration externalisée  |
| instructions/06-container          | Passage au container Undertow           |
| instructions/07-actuator           | Ajout des endpoint REST de monitoring   |
| instructions/08-httpclient         | Ajout d'une validation via HTTPClient   |
| instructions/10-httpclient-starter | Starter apache  HTTPClient              |

### Prérequis

Cette démo necessite un JDK 8 ainsi que Maven > 3.0.

### Lancement de l'application
```
# mvn spring-boot:run
```
