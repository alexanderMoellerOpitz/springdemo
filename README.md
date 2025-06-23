# Dokumentation

## Anwendung (Spring)
### Controller-Schicht
- Es wurde ein Controller mit drei Endpunkten erstellt:
  - Persistieren eines Objekts in der Datenbank
  - Ausgeben aller aktuell in der Datenbank gespeicherten Objekte
  - Löschen aller Objekte in der Datenbank
- Eingehende Parameter werden auf Validität geprüft und typisiert.
- Die Kommunikation mit der Service-Schicht erfolgt über speziell auf den jeweiligen Endpunkt zugeschnittene DTOs.
- Eine Utility-Mapper-Klasse wandelt die Datentypen zwischen den Schichten um.

### Service-Schicht
- Stellt die vom Controller benötigte Geschäftslogik bereit.
- Die Rückgabe an den Controller erfolgt ebenfalls über DTOs.
- Verwendet Entities, um mit der Datenbank-Schicht zu kommunizieren.

### Datenbank-Schicht
- Die Kommunikation mit der Datenbank erfolgt über JPA/Hibernate-Repositories und Entities.
- Die Datenbankverbindung wird beim Start der Applikation hergestellt. Die Konfiguration befindet sich in der Datei application.properties.

## CI/CD (Jenkins )
- Die Pipeline-Konfiguration erfolgt über ein Jenkinsfile.
- In Jenkins müssen die verwendeten Tools (Maven & JDK) bereitgestellt werden da sie im Jenkinsfile referenziert werden.
- Stage 1: Checkout des Projekts aus dem Versionsverwaltungssystem.
- Stage 2: Kompilieren des Projekts.
- Stage 3: Ausführen der Tests im Profil „test“.
- Stage 4: Statische Codeanalyse mit SonarQube; die Ergebnisse werden an den SonarQube-Server gesendet.
- Stage 5: Erstellen des Artefakts zur Auslieferung.