
##Aufgabe - Erste eigene SpringBoot-Application###

Bitte auf http://start.spring.io/ gehen und unten auf den Link "Switch to the full version." klicken, und die folgenden Felder füllen:
*Group: com.cc.spring 
*Artifact: springschulung_part2

Die anderen Felder ignorieren und weiter unten "Web" auswählen.

Dann "Generate Project" klicken und das zip-File lokal in den Ordner part2 entpacken.

Danach das Projekt in IntelliJ als Maven-Projekt importieren und die Application.class starten per "Run as..."

Zuletzt: Auf die Kommandozeile wechseln (per C:\dev\bipro-dev\env.cmd) und im Projektverzeichnis

```
mvn clean install 
```

ausführen. Danach per 

```
java -jar target/XXX.jar
```
laufen lassen.