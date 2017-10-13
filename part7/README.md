
## Aufgabe - Spring Boot Apps in Docker Containern

### Prerequisites 

Docker muss installiert sein. Bitte einmal per `docker info` prüfen, ob eine Ausgabe erfolgreich läuft.

### Docker Basic Build Prozess für Spring Boot Apps

In part5 liegt ein Beispiel-[Dockerfile](https://github.com/jonashackt/spring-and-rest-basics/blob/master/part5/Dockerfile) - dieses bitte einmal in den Ordner `part4` kopieren.


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

Nun sollte die Beispielapp schon in Docker laufen. Dazu bitte einmal alle Container anzeigen lassen:

```
docker ps -a
```

Um zu überprüfen, ob die Spring Boot App innerhalb des Dockercontainers sauber läuft, können wir uns in den Container connecten und per curl die bekannte Schnittstelle aufrufen. Dazu in den Container verbinden per

```docker exec -it CONTAINER-ID```

Innerhalb des Containers per `curl` auf die URL `http://localhost:8080/api/hello` zugreifen. Liefert der Zugriff einen HTTP `200`?
