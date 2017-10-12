
##Aufgabe - Context auf Annotationen umstellen##

Bitte folgenden Test fixen:
com.cc.spring.configuration.AnnotationBasedContextTest.testStartup()

Lösungshinweise:
Die Konfiguration des Application-Context ist auf Annotationen umzustellen: 

Bitte den folgenden Context mit Annotationen ausstatten:
com.cc.spring.configuration.AppContext

Folgende Annotation sollten verwendet werden:
org.springframework.context.annotation.Configuration;
org.springframework.context.annotation.ComponentScan;
org.springframework.context.annotation.Bean;
org.springframework.beans.factory.annotation.Autowired;
