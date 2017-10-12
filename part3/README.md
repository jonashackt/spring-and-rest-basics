
# 3 Aufgaben - REST mit Spring

### 3.1 Vorbereitung

Verschaffen Sie sich einen Überblick über die Projekt- & Package-Struktur. Sie können sich voll auf das Erstellen und Bereitstellen der REST-Endpunkte konzentrieren - alles andere ist bereits vorhanden.

Öffnen Sie die Klasse com.cc.spring.endpoints.RestEndpoints und annotieren Sie die Klasse so, dass Spring sie als REST-Controller erkennt. Mappen Sie auf Klassenebene auf die URI `/api`.


### 3.2 Ein erster REST-Endpunkt (GET)

Stellen Sie einen REST-Endpunkt bereit, der auf einen GET-Request an die URL `/api/hello` mit einem Gruß antwortet.

Testen Sie ihren REST-Endpunkt selbständig mit Postman - schicken Sie dabei einen `GET` an die URI `http://localhost:8080/api/hello`


### 3.3 Ressource zum Anlegen eines Wertes (POST) - Übergabe als URI-Parameter

Stellen Sie sich vor, sie möchten erreichen, dass ihr erstellter Endpunkt neben einem vordefinierten Gruß, den korrekten Namen verwendet. Dazu müssen Sie ihrer Ressource `/hello` den Namen übergeben können. (Wir werden den ersten Endpunkt hier nicht mehr ändern und den angelegten Namen nicht speichern, da dies hier zu weit führen würde. Sie können aber gern die Anwendung im Nachgang dafür erweitern... Fokus hier: Anlegen eines Wertes ala "REST")

Stellen Sie dazu die Ressource `/hello` mit der HTTP-Operation POST bereit. Ihr wollen wir einen Namen als URI-Parameter in folgender Form übergeben können: `http://localhost:8080/api/hello?name=Gerald`
Die Java-Methode muss nichts tun - ein System.out.println mit dem übergebenen Namen reicht.
Der REST-Endpunkt muss keinen Rückgabewert liefern, dafür aber einen HTTP-Status-Code: `201 Created`

Testen Sie ihren REST-Endpunkt selbständig mit curl/Postman - schicken Sie dabei einen `POST` an die URI `http://localhost:8080/api/hello?name=Gerald`


### 3.4 Ressource zum Ändern eines Wertes (PUT) - Übergabe als Pfadvariable

Stellen Sie eine nahezu identische Ressource names `/hello` bereit, die allerdings das ändern des Namens anbieten soll (HTTP-Operation PUT). Außerdem wollen wir den Namen nicht per URL-Parameter übergeben, sondern als Pfadvariable (dafür muss die URI um einen Platzhalter erweitert werden, bspw. `/hello/{name}`).
Die Methode muss neben einem System.out.println nichts tun - aber nun einen HTTP-Status-Code: `204 No Content` zurückliefern (die Paarung wird in der Praxis auch empfohlen! Wenn der Request erfolgreich war, gibt `PUT` einen `204` zurück, `POST` ein `201`, `GET` ein `200`, usw.)

Testen Sie ihren REST-Endpunkt selbständig mit Postman - schicken Sie dabei einen `POST` an die URI `http://localhost:8080/api/hello/Gerald`


### 3.5 Datenmapping mit JSON sowie komplexen Request- und Responseobjekten - am Beispiel eines frei erfundenen Backends

Nähern wir uns komplexeren Request- und Responseobjekten. Wir nehmen dazu ein an die BiPro-VorsorgeNet-Integration angelehntes Beispiel.

Stellen Sie einen Endpunkt `/produkt.json` bereit, der auf ein POST reagiert und ausschließlich JSON zurückliefert (Hinweis: `produces` im `@RequestMapping` verwenden). Er nimmt ein JSON entgegen, dass der Klasse `com.cc.spring.domain.User` entspricht:

```
{
    "geschlecht": "MAENNLICH",
    "name": {
        "nachname": "Mayer",
        "vorname": "Franz"
    }
}
```

außerdem liefert der Endpunkt ein JSON zurück, dass der Klasse `com.cc.spring.domain.Produkt` entspricht. Dazu verwenden Sie innerhalb der Methode die Klasse `com.cc.spring.backend.ExampleBackend`, die eine Methode `public static Produkt berechneImBackend(User user)` anbietet.

Annotieren Sie den Methoden-Parameter dazu mit `@RequestBody` und das Rückgabeobjekt mit `@ResponseBody`. Die Methode soll einen HTTP-Status `200 OK` zurückliefern.

Testen Sie ihren REST-Endpunkt selbständig mit Postman - schicken Sie dabei einen `POST` an die URI `http://localhost:8080/api/produkt.json`
Ergänzen Sie dabei in Postman einen Header Namens Content-Type mit dem Wert `application/json`
Außerdem geben Sie im Body im Format `raw` den oben genannten Request mit.


### 3.6 Erweiterung der Ressource produkt um das Datenformat XML (Thema: mehrere Repräsentationen der gleichen Ressource)

Ein Prinzip von REST ist die Entkoppelung von Ressource und ihrer Representation. Wir wollen konkret sehen, wie das in Spring umgesetzt werden kann und bieten unsere produkt-Ressource auch mit einem XML-Response an.

Erweitern Sie dazu die Klasse `com.cc.spring.domain.User` um die Annotation @XmlRootElement(name = "User")` und die Klasse `com.cc.spring.domain.Produkt` um `@XmlRootElement(name = "Produkt")`

Kopieren Sie die Methode, die die JSON-Antwort zurückgibt und erweitern Sie ihren Namen, damit die Klasse kompiliert werden kann (z.B. in `berechneProduktDatenXml). Ändern sie auch die URL in `/produkt.xml` und geben Sie XML zurück (wieder produces im `@RequestMapping` verwenden!).

Testen Sie ihren REST-Endpunkt selbständig mit Postman - schicken Sie dabei einen `POST` an die URI `http://localhost:8080/api/produkt.xml





