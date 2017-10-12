
# 4 Aufgaben Testen von REST-WebServices mit Spring

Achtung: Aufgrund der Komplexität des Themas haben wir nicht TDD-konform erst mit der Implementierung begonnen. Diese ist schon gegeben und wir setzen unsere Tests davor. In der Praxis sollte aber mit dem Schreiben der Tests begonnen werden!


### 4.1 Vorbereitung

Ergänzen Sie die Annotationen der Klasse `com.cc.spring.endpoints.RestEndpointsTest` im Source-Folder `src/test/java`


### 4.2 Testen eines GET-Calls mit Spring RestTemplate

Ergänzen Sie die Testmethode testWithSpringRestTemplate(), die mit Hilfe des Spring RestTemplate die Ressource `http://localhost:8080/api/hello` per `GET` aufrufen soll. Prüfen Sie im "Then"-Abschnitt, ob der Text dem Rückgabewert der Methode `public String gruesse()` der Klasse `com.cc.spring.endpoints.RestEndpoints` entspricht.

Führen Sie den Test aus - wird er grün?


### 4.3 Testen eines GET-Calls mit RestAssured

Ergänzen Sie die Testmethode `testWithRestAssured()` und rufen Sie die gleiche Ressource per RestAssured auf. Prüfen Sie auf das gleiche Ergebnis. Wird der Test grün?


### 4.4 POST und HTTP-Status

Legen Sie eine Methode `testeLegeNamenAn()` an und annotieren Sie sie mit @Test.

Nutzen Sie RestAssured, um die Ressource `http://localhost:8080/api/hello?name=Benjamin` per POST aufzurufen.
Prüfen Sie auf den Statuscode 201 Created. Wird der Test grün?


### 4.5 PUT mit Pfadvariable

Legen Sie eine Methode testeAendereNamen() an und annotieren Sie sie mit `@Test`.

Nutzen Sie RestAssured, um die Ressource `http://localhost:8080/api/hello/Gerald` per `PUT` aufzurufen. Prüfen Sie auf den Statuscode `204 No Content`. Wird der Test grün?


### 4.6 Komplexer Request- & Response (JSON)

Legen Sie eine Methode testeBerechnungJson() an und annotieren Sie sie mit `@Test`.

Nutzen Sie RestAssured, um die Ressource `http://localhost:8080/api/produkt.json` per `POST` aufzurufen. Übergeben Sie als Body ein Objekt der Klasse `com.cc.spring.domain.User` (die Erstellung eines Users können Sie abkürzen, in dem Sie die Methode `generateSampleUser()` der Klasse `com.cc.spring.util.RestUtils` nutzen) und den ContentType JSON.

Prüfen Sie auf den Statuscode 200 OK und den ContentType JSON. Prüfen Sie außerdem, ob der Response einem Objekt der Klasse `com.cc.spring.domain.Produkt` entspricht, dass wiederum den User des Requests enthält. Die Erstellung eines entsprechenden Produkt-Objekts können Sie abkürzen, in dem Sie die Methode `generateSampleProdukt(User user)` der Klasse `com.cc.spring.util.RestUtils` nutzen.

Wird der Test grün?


### 4.7 Komplexer Request- & Response (XML)

Legen Sie eine Methode `testeBerechnungXml()` an und annotieren Sie sie mit `@Test`.

Nutzen Sie RestAssured, um die Ressource `http://localhost:8080/api/produkt.xml` per POST aufzurufen. Nutzen Sie die gleiche Vorgehensweise, wie in der Methode `testeBerechnungJson()`. Ändern Sie nur den ContentType auf XML. Wird der Test grün?
