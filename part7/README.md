
## Aufgabe - Spring Boot Apps in Docker Containern

### Prerequisites 

Docker muss installiert sein. Bitte einmal per `docker info` prüfen, ob eine Ausgabe erfolgreich läuft.

### Docker Basic Build Prozess für Spring Boot Apps

In part5 liegt ein Beispiel-[Dockerfile](https://github.com/jonashackt/spring-and-rest-basics/blob/master/part5/Dockerfile) - dieses bitte einmal in den Ordner `part4` kopieren und auf den korrekten __jar-Namen__ anpassen.


Nun einen ersten Docker Container bauen per

```
docker build . --tag springschulung_part4:latest
```

Das Docker Image sollte jetzt gebaut vorliegen, das bitte einmal per

```docker images```

prüfen.


Danach kann der Container gestartet werden mit
 
```
docker run -d --publish 8090:8090 --name=springschulung_part4 --restart=unless-stopped springschulung_part4:latest
```

### Zugriff auf die REST-Endpoints der Spring Boot App im Docker-Container


Nun sollte die Beispielapp schon in Docker laufen. Dazu bitte einmal alle Container anzeigen lassen:

```
docker ps -a
```

Um zu überprüfen, ob die Spring Boot App innerhalb des Dockercontainers sauber läuft, können wir uns in den Container connecten und per curl die bekannte Schnittstelle aufrufen. Dazu in den Container verbinden per

```
docker exec -it CONTAINER-ID sh
``` 

Innerhalb von `openjdk:8-jdk-alpine` ist leider kein `curl` dabei, also installieren wir es kurzerhand nach (könnten wir auch per `RUN` direkt im `Dockerfile` machen...)

```
apk --no-cache add curl
```

Innerhalb des Containers per `curl` auf die URL `http://localhost:8090/api/hello` zugreifen. Funktioniert der Zugriff?


Danach wieder raus aus dem Container per `exit` und den gleichen Zugriff per curl von Außen probieren (oder per Postman :) ).
