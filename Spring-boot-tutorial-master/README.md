# Spring-boot-tutorial

# Aufgabe 3: Spring Boot Fullstack Department-Management (4 Stunden)

Erledige das folgende Tutorial, in dem du lernst, wie man mit Spring Boot eine REST-API entwickelt, globales Exceptions-Handling implementiert UND automatisiert testet. Teile dieses Tutorials sind eine gute Wiederholung des vorhergehenden.

[Spring Boot Tutorial | Full In-depth Course - YouTube](https://www.youtube.com/watch?v=c3gKseNAs9w)

### Was ist Java Spring?

Das Spring Framework ist ein quelloffenes Framework für die Java-Plattform, welches oft für Web-Anwendungen verwendet wird. Ziel des Spring Frameworks ist es, die Entwicklung mit Java/Java EE zu vereinfachen und gute Programmierpraktiken zu fördern.

## Dependency Injection

Das als **Dependency Injection** bekannte Einimpfen von Objekten ist eines der grundlegenden Konzepten von **Spring. In diesem Fall instanziiert das Objekt nicht selbst die benötigte Klasse, sondern bekommt die Abhängigkeit von einem DI-Container beim Start der Anwendung injiziert.**

## Spring Initializr

**Spring Initializr** ist ein webbasiertes Tool, das es ermöglicht, eine **Spring** Boot Projektvorlage ohne Applikationscode zu generieren. Die generierte Projektstruktur beinhaltet eine Gradle oder Maven Build-Datei.

→ Website [start.spring.io](http://start.spring.io) 

Alles auf Standard wir haben nur an den Metadaten etwas geändert.

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled.png)

→ Dependencies

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%201.png)

→ Generate

→ Extrahieren und in IntelliJ öffnen.

## SpringBoot Starters

→ gehe in die pom.xml Datei

 bei einer Dependency kan man bei der artifactId einen klick mit STRG machen um die fremd dependencys ansehen zu können.

## Creating Simple API

Die SpringBootTutorialApplication ist die Main-Klasse unserer Anwendung.  Über STRG+Klick auf die @SpringBootApplication kommen wir in ein @interface.  Dort können wir sehen, dass dieses Inerface einmal ein @SpringBootConfiguration, @EnableAutoConfiguration implementiert. 

→ neues Package controller einfügen.

→ in diesem Package fügen wir eine Klasse HelloController hinzu.

Mache diese Klasse zu einer Komponenten von SpringBoot um sie zum String Boot Container hinzuzufügen müssen wir ein @Component am Anfang der Klasse definieren.

```java
@Component
```

→ nun ist diese Klasse im String-Boot Radar. Wenn wir die main-Methode ausführen wird diese Klasse zu unserem String-Boot-Container hinzugefügt.

Da aber die HelloController Klasse ein Controller ist benötigen wir ein anderes Wort als Component und deshalb schreiben wir ein @Controller am Anfang der Klasse

→ Wenn wir das @interface öffnen sehen wir, dass das interface ein @Component implementiert.

@RestController 

Das ist ein PartikularController + ein Komponent + es Returnt immer einen ResponseBody (sehen wir im @interface, es returnt immer Daten)

@RequestMapping = Einfach ausgedrückt, wird die Annotation verwendet, um Webanforderungen Spring Controller-Methoden zuzuordnen.

→ Jedes Mal wenn der [Localhost:8080](http://Localhost:8080) ausgeführt wird, wird diese Methode aufgerufen. (/)

```java
@RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Welcom too Daily Code Buffer!!";
    }
```

Wenn wir eine Auto Konfiguration ändern möchten oder Tauschen können wir diese Änderung über das File [application.properties](http://application.properties) machen.

Server Port tauschen:

→ application.properties

→ server.port= 8082

## Running SpringBoot App

→ Außführen der Main

→ Beim durchstarten können wir sehen das der Tomcat nun auf port 8082 läuft.

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%202.png)

→ nun müssen wir [localhost](http://localhost):8082 angeben um unsere Webapplication zu sehen.

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%203.png)

→ Wir ändern das @RequestMapping zu @GetMapping. Das @GetMapping @interface implementiert das @RequestMapping.

Spring-Boot hat andere Maven-Goals um unsere Spring-Boot-Applikation auszuführen.

→ über das Terminal können wir mit mvn spring-boot:run können wir das Maven-Goal run ausführen.

→ mit STRG+C trennen wir die verbindung wieder.

## SpringBoot Devtools

→ pom.xml öffnen

→ öffne start.spring.io

→ suche bei Dependencies nach DEVELOPER TOOLS und explore diese.

→ kopiere das dependency und füge sie in der pom.xml ein

```java
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
      <optional>true</optional>
    </dependency>
```

→ suche nach Registry

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%204.png)

→ File, Settings, Compiler und setze den Hacken bei Build project automatically.

→ apply und ok

→ starte den Server

- wenn devtools funktioniert sehen wir, dass wir beim verändern sofort auf der Website das Ergebnis sehen.

## Architecture & Example

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%205.png)

 

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%206.png)

GET/POST/PUT/DELETE 

Unser Handl-Layer um unsere Requests zu steuern 

Service Layer

ist unser Businesslayer. Service-Layer, die Domains kapseln, stellen die logische Entsprechung von Funktionalitäten innerhalb des Unternehmens dar. Sie müssen mit anderen Services interagieren, um gemeinsame Geschäftsprozesse und –aufgaben zu automatisieren. (MainBussinesLayer)

Data Access / Repository Layer

Dieser Layer interagiert mit der Datenbank. Händelt alle Datenbank zugriffe.

## Adding Dependency H2 & JPA

→ gehe zu der pom.xml Datei

→ gehe auf start.spring.io

→ Dependencies Spring Data JPA 

→einfügen

```java
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
```

Datenbank Einstellungen in der application properties

```java
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:dcbapp
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

→ starten der Application

→ wir sehen im Terminal siehe Screenshot

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%207.png)

→ über [localhost:8082/h2-console](http://localhost:8082/h2-console) kommen wir zur Datenbank

## Creating Components

→ create ein entity Package

→ create service Package

→ create repository Package

- in das Package entity kommt unsere Klasse Department

→ Datenfelder erstellen + Getter und Setter generieren

→ Konstruktor mit allen Datenfeldern und einen Default (leer)

→ toString Methode erzeugen mit allen Datenfeldern

Damit diese Klasse mit unserer Datenbank interagieren kann, müssen wir am Anfang der Klasse das @interface @Entity einfügen.

Wir benötigen natürlich einen PrimaryKey für unsere Datenbank, daher machen wir ein @Id über die departmentId, damit Spring-Boot weiss, dass die ID departmentId ist.

Mit @GeneratedValue(strategy = GenerationType.AUTO) wird automatisch immer pro Eintrag raufgezählt bei der ID (1,2,3,..)

- neue Klasse DepartmentController im Package controller erstellen.

→ wir fügen das @interface @RestContoller hinzu. jetzt können wir die Rest-API machen.

- neues Interface erzeugen Namens DepartmentService im Package Service.
- Hinzu fügen der Klasse DepartmentServiceImpl die das Interface DepartmentService implementiert.

Diese Klasse kenzeichnen wir mit Java-Spring mit @Service als Service.

- Erzeugen eines Interfaces DepartmentRepository im Package Repository (kennzeichnung @Repository

Erweiterung der JpaRepository. Wir müssen zwei Arten von Typen mitgeben einmal der Typ des Objekts (Department) und einmal der Typ vom Primery Key (Long)

```java
public interface DepartmentRepository extends JpaRepository<Department, Long>
```

mit der Kennzeichnung der @interfaces erkennt Spring-Boot, dass diese Klassen zu dem String-Boot gehören und bei dem Start werden alle Klassen in den Spring-Boot-Container hinzugefügt.

## Department Save API

→ Erste Methode erstellen im DepartmentController

@PostMapping = @PostMappingAnnotation ordnet HTTP-POST-Anforderungen bestimmten Handlermethoden zu.

@RequestBody = Die Annotation @ResponseBody teilt einem Controller mit, dass das zurückgegebene Objekt automatisch in JSON serialisiert und an das HttpResponse- Objekt zurückgegeben wird.

@Autowired = Das Spring-Framework ermöglicht die automatische Abhängigkeitsinjektion. Mit anderen Worten, durch die Deklaration aller Bean-Abhängigkeiten in einer Spring-Konfigurationsdatei kann Spring Container Beziehungen zwischen kollaborierenden Beans automatisch verdrahten . Dies wird als Spring Bean Autowiring bezeichnet .

→ Wir machen eine Methode saveDepartment in DepartmentConroller. Dei Variable departmentService ist vom Typ DepartmentService. In der Methode rufen wir an der Variablen departmentService eine Methode Namens saveDepartment(department) auf. Im Interface Department Service haben wir eine Methode implementiert die einen Parameter vom Typ Department mitbekommt. Da DepartmentServiceImpl das Interface DepartmentService implementiert müssen wir die Methode hier auch hinein geben.  In der Klasse DepartmentServiceImpl haben wir eine globale Vriable vom Typ departmentRepository so bekommen wir zugriff auf die Daten der Datenbank , da dieses Interface eine Erweiterung der JpaRepository ist.

## Testing API`S using Rest Client

→ anmelden h2-controle

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%208.png)

→ Download Insomnia

→ neuen Request erstellen 

→ POST auswählen und in die JSON Datei die Daten schreiben und absenden.

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%209.png)

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2010.png)

## GetMapping Fetching data from DB

Erlauben dass wir alle Departments von der Datenbank bekommen.

Wir machen eine Methode in DepartmentController. Sie implementiert ein @GetMapping. Wir möchten eine List zurückbekommen, daher geben wir im Methodenkopf als Rückgabe einer Liste mit Objekten von Department an. 

Das interface DepartmentService implementiert wieder den Methodenkopf und die Klasse DepartmentServiceImpl implementiert diese wider. In der Klasse DepartmentServiceImpl haben wir eine globale Vriable vom Typ departmentRepository so bekommen wir zugriff auf die Daten der Datenbank, da dieses Interface eine Erweiterung der JpaRepository ist.

## Fetching Data by ID

Wir erzeugen eine Methode fetchDepartmentById() wir initialisieren diese wieder mit @GetMapping, jedoch geben wir bei dem Pfad eine /{id} mit das bedeutet ein besonderer Wert wird mitgegeben.

Mappe die besondere ID mit dieser ID und für das brauchen wir bei der Parameter mitgabe die @PathVariable("id")

```java
public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
```

Über diese URL z.B. [http://localhost:8082/departments/2](http://localhost:8082/departments/2) bekommen wir das Department mit der ID 2.

## Deleting Data

@DeleteMapping

```java
@DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
```

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2011.png)

## Updating Data

→ Neue Methode updateDepartment.

Es wird ein @PuttMapping @interface verwendet. 

Wir geben der Methode die @PathVariable (id) und den @RequestBody mit.

Das Interface departmentService stellt dies wieder zur verfügung, somit muss die Klasse DepartmentServiceImpl wieder diese implementieren.

DepartmentController:

```java
@PutMapping("/departments/{id}")
    public Department updateDepartment( @PathVariable("id") 
		Long departmentId, @RequestBody Department department){
    return  departmentService.updateDepartment(departmentId, department);
```

DepartmentService:

```java
public Department updateDepartment(Long departmentId, 
Department department);
```

Die Methode bekommt zwei Parameter mit 1: departmentId 2: Department

Neue Variable depDB vom Typ Department = wird verwendet um das gesuchte Department in der Datenbank zu finden und wird dann in depDB gesetzt.

Wenn das Objekt nicht Null ist rufe an dem Mitgegebenen Parameter die Methode getDepartmentName() auf und prüfe ob ein Namen vorhanden ist oder nicht. Setzte in die depDB Variable den neuen Namen und überschreibe diesen in der Datenbank. Die anderen if Anweisungen werden überprüft und das Objekt wird in der Datenbank verändert gespeichert. 

DepartmentServiceImpl:

```java
@Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);

    }
```

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2012.png)

Nur die departmentAddress ändern:

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2013.png)

## Fetch Data by Name

→ Erstellung einer neuen Methode in der Klasse DepartmentController:

Hier müssen wir die Methode fetchDepartmentByName mit dem @GetMapping @Interface inizialisieren und die URL mitgeben.

Der Name des Departments wird als @PathVariable verwendet und als String in einer Variable namens departmentName gespeichert und der Methode mitgegeben. 

Retrunt wird somit über das departmentService Objekt die Methode fetchDepartmentByName und der Name des Departments wird dieser Methode mitgegeben.

Somit müssen wir im Interface departmentService einen Methodenkopf erzeugen.

```java
@GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
```

Methodenkopf im Interface departmentService:

```java
public Department fetchDepartmentByName(String departmentName);
```

Die Klasse DepartmentServiceImpl implementiert das Interface departmentService, also müssen wir die Methode fetchDepartmentByName() dort hinzufügen.

Dier Methode wird wieder der Namen des Departments mitgegeben und Returnt wird der Methodenaufruf am Interface departmentRepository "findByDepartmentName(departmentName)".

```java
@Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
```

Somit müssen wir auch im Interface departmentRepository die Methode findByDepartmentName inizialisieren.

```java
public Department findByDepartmentName(String departmentName);
```

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2014.png)

Groß und Kleinschreibung überprüfen:

→ hinzufügen der Methode findDepartmentByNameIgnoreCase:

```java
public Department findByDepartmentNameIgnoreCase(String departmentName);
```

→ zugreifen auf diese Methode in der Klasse DepartmentServiceImpl:

```java
departmentRepository.findByDepartmentNameIgnoreCase(departmentName)
```

Bei mir hat dies beim ersten Versuch nicht geklappt, ich musste meine Application neu starten und dort hat es funktioniert.

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2015.png)

IgnoreCase ist ein Schlüsselwort, die automatisch eine vordefinierte Methode in Spring-Boot aufruft um die Groß- und Kleinschreibung zu ignorieren. Unter dem folgenden Link sehen Sie mehr solcher Methoden(Schlüsselwörter).

[Spring Data JPA - Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

@Query  = Die Verwendung benannter Abfragen zum Deklarieren von Abfragen für Entitäten ist ein gültiger Ansatz und funktioniert für eine kleine Anzahl von Abfragen problemlos.

## Hibernate Validation

→ hinzufügen einer dependecy in der pom.xml

```java
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
```

→ Klasse Department

→ Datenfeld departmentName darf nicht leer sein somit Initialisieren wir diese mit @NotBlank dort geben wir eine Messag mit wenn das Feld doch leer sein sollte.

```java
@NotBlank(message = "Please Add Department Name")
```

hinzufügen @Valid bei der Postanfrage saveDepartment in der Klasse DepartmentController

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2016.png)

Man kann nun auf vieles Prüfen durch das Plugin spring-boot-starter-validation

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2017.png)

## Adding Loggers

Logger import von org.slf4j.Logger

```php
private final Logger LOGGER = 
LoggerFactory.getLogger(DepartmentController.class);
```

Hinzufügen einer LOGGER.info() in saveDepartment() und fetchDepartmentList().

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2018.png)

## Project Lombok

→ [start.spring.io](http://start.spring.io) auswählen Lombok 

→ Hinzufügen der Lombok Dependency in der pom.xml

```php
<dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>
```

→ Plugin kopieren und in der pom.xml einfügen unter Plugins

```php
<plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
          <excludes>
            <exclude>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
            </exclude>
          </excludes>
        </configuration>
      </plugin>
```

→ Löschen aller Konstruktoren, Getter, Setter und toString in Department.

→ die Klasse inizialisieren wir mit den Folgenden @interfaces

@Data = benötigen wir wenn wir alles möchten Getter, Setter, ...

wir können aber auch z.B. nur mit @Getter abreiten.

→ @NoArgsConstructor = Default Constructor

→ @AllArgsConstructor = mit Allen Argumenten

## Exception Handling

→ neues Package error mit Klasse DepartmentNotFoundException erstellen

→ extends Exception

→ Alt Einfügen und die Override-Methoden einfügen

DepartmentServerImpl:

Wir bekommen hier ein Optional<Department>.

```java
public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
```

Wir überprüfen ob das Department vorhanden ist oder nicht. Wenn nicht ist die if-Anweisung true und erzeugt ein neues DepartmentNotFoundException Objekt mit der Message "Department Not Available." Ansonsten wird da gesuchte Department zurückgegeben.

```java
if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
            return department.get();
```

DepartmentService:

Das Interface implementiert die Methode und muss auch über die Exception bescheid wissen, somit müssen wir hier auch ein throws einbinden.

```java
public Department fetchDepartmentById(Long departmentId) 
throws DepartmentNotFoundException;
```

DepartmentController:

Auch im DepartmentController müssen wir bei der fetchDepartmentById das throws mitgeben.

```java
@GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
```

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2019.png)

Wir wollen aber nicht die ganze Fehlermeldung immer ausgeben

→ neue Klasse RestResponseEntityExceptionHandler

→ extends `ResponseEntityExceptionHandler`

→ die Klasse inizialisieren wir mit @ControllerAdvice 

→ die Klasse inizialisieren wir auch mit @ResponseStatus

Immer wenn eine Exception geschmissen wird sollte diese Klasse die Exception händeln und erzeugt immer eine passende Antwort. Diese sendet die Klasse dan zurück als Response Objekt.

RestResponseEntityExceptionHandler:

→ Erweitert die Klasse ResponseEntityExceptionHandler.

→ die Methode departmentNotFoundException wird inizialisiert mit dem @Interface @ExceptionHandler dort wird die DepartmentNotFoundException.class mitgegeben, da wir diese handeln möchten.

Als Rückgabe Typ hat diese Methode ein ResponseEntity, die ein Objekt von ErrorMessage haltet. Der Methode wird zum einen die DepartmentNotFoundException und der WebRequest mitgeliefert.

Wir erzeugen in der Methode ein neues Objekt vom Typ ErrorMessage und geben der ErrorMessage den Status HttpStatus.NOT_FOUND und die exception.message mit.

Returnt wird ein ResponseEntity, an der die Methode status aufgerufen wird und dieser Methode wird der HttpStatus.NOT_FOUND mitgegeben. Und der aufgerufenen Mthode Body wird die Exception Message mitgegeben.

```java
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception,
                                                                   WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }
}
```

neue Klasse im Package entity ErrorMessage erstellen.

```php
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus status;
    private String message;
```

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2020.png)

## Changing H2 → MySQL

→ Downloaden Workbench und MySQL

Ändern der [application.properties](http://application.properties) 

```java
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/dcbapp
spring.datasource.username=root
spring.datasource.password=
spring.jpa.show-sql=true
```

Ändern der pom.xml (hinzufügen dependency)

```java
<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
```

→ Neues Schema (dcbapp) in der Workbench erzeugen. 

→ IntelliJ mit der Datenbank verknüpfen.

→ starten

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2021.png)

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2022.png)

## Unit Testing

## Unit Testing Service Layer

→ gehe in die Klass SpringBoot TutorialApplicationTests im test Ordner

→ Löschen der Test Methode

→ Öffne DepartmentService 

→ Gehe über das DepartmentService und rechts klick

→ Wähle Generate aus und gehe auf Test

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2023.png)

setUp/@Before auswählen

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2024.png)

im Ordner test erstellt es ein neuen Ordner service mit der Klasse DepartmentServiceTest

```java
@BeforeEach
    void setUp() {
    }
}
```

### @MockBean

Wir können die @MockBean verwenden, um dem Sprin-Anwendungskontext Scheinobjekte hinzuzufügen. Der Mock ersetzt alle vorhandenen Bean des gleichen Typs im Anwendungskontext.

Wenn keine Bean des gleichen Typs definiert ist, wird eine neue hinzugefügt. Diese Annotation ist bei Integrationstests nützlich, bei denen eine bestimmte Bean, wie ein externer Service, gemockt werden muss.

Wenn wir die Annotation für ein Feld verwenden, wird der Mock in das Feld eingefügt und im Anwendungskontext registriert.

Wir erstellen zwei Datenfelder:

Initialisieren des Datenfeldes departmentRepository mit @MockBean

```java
@Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
```

whenVaildDepartmentName_thenDepartmentShouldFound():

Wir erstellen eine Variable departmentName mit dem Namen IT.

Erstellung eines Objekts Department namens found., diese initialisieren wir in dem wir an der Variablen departmentService die Methode fetchDepartmentByName mit der mitgabe des Parameters departmentName aufrufen.

Verglichen wird anschließend der departmentName und an der Variable found vom Typ Deparment die Methode getDepartmentName() aufgerufen. Bei einer übereinstimmung bekommen wir das Department.

```java
@Test
    @DisplayName("Get Data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
```

void setUp()

Diese Methode initialisieren wir mit @BeforeEach 

Wir ereugen ein Objekt vom Typ Department, diese erzeugen wir mit dem @Builder in der Klasse Department. Wir bekommen daher die Methode builder() an dieser geben wir die jeweiligen Datenfelder mit und am Schluss rufen wir an der Klasse Mockito die Methode when() mit. Dieser Methode geben wir das Datenfeld departmentRepository die findByDepartmentNameIgnoreCase auf und geben "IT".  Anschließend rufen wir thenReturn auf und geben das Department mit.

```java
@BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Ahmedabad")
                        .departmentCode("IT-06")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }
```

## Unit Testing Repository Layer

Ist schwieriger, da es mit unserer Datenbank arbeitet.

→ Klasse DepartmentRespository

→ rechts kilck / Generate

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2025.png)

→ Neue Klasse DepartmentRepositoryTest

→ zwei Datenfelder

```java
@Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;
```

void setUp():

 entityManager.perist()

Machen Sie eine Instanz verwaltet und persistent.

```java
@BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Mechanical Engineering")
                        .departmentCode("ME - 011")
                        .departmentAddress("Delhi")
                        .build();

        entityManager.persist(department);
    }
```

whenFindById_thenReturnDepartment()

```java
@Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }
```

Wir können Problem los den ReposityLayer testen ohne einen neuen Eintrag in die Datenbank zu machen.

## Unit Testing Controller Layer

→ wieder eine TestKlasse von DepartmentController erzeugen.

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2026.png)

Wir verwenden die WebMvsTest

Wir möchten die Klasse DepartmentController.class Testen

```java
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
```

Datenfelder:

```java
@Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
```

setUp()

```java
@BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }
```

saveDepartment():

Mocken mit ServiceLayer.

```java
@Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "\t\"departmentName\":\"IT\",\n" +
                        "\t\"departmentAddress\":\"Ahmedabad\",\n" +
                        "\t\"departmentCode\":\"IT-06\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }
```

fetchDepartmentById():

```java
@Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
```

## Adding Config in properties file:

Willkommens Text in properties auslagern.

application.properties:

```java
welcome.message = Welcome too Daily Code Buffer!!
```

erzeugen der Variable wegen zugriff in HelloController:

```java
@Value("${welcome.message}")
    private String welcomeMessage;
```

zurückgeben:

```java
@GetMapping("/")
    public String helloWorld(){
        return welcomeMessage;
    }
```

Ausgabe ist die selbe:

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2027.png)

## Adding application.yml

Die meisten Application verwenden yml.

→ Im Internet properties to yaml öffnen und übersetzen lassen.

→ Kopieren und in die application.yml einfügen 

→ aus kommentieren in application.properties

## Springboot Profiles

application.yml

active: qa bedeutet, dass qa bevorzugt wird.

Wir haben einmal profides dev, qa, prod erstellt

bei der url mussten wir hinter dcbapp"-qa" hinzufügen.

→ Wir erstellten ein Schema dcbapp-qa und dcbapp-prod in der workbench. Da die dcbapp bevorzugt wird, wird diese beim starten ausgewählt und diese Datenbank verwendet.

→ die - - - begrenzen das jewilige Dokument.

```java
server:
  port: '8082'
spring:
  profiles:
    active: qa

---

spring:
  profiles: dev
  datasource:
    username: root
    url: jdbc:mysql://localhost:3306/dcbapp
    password: ''
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: 'true'
welcome:
  message: Welcome too Daily Code Buffer!!

---

  spring:
    profiles: qa
    datasource:
      username: root
      url: jdbc:mysql://localhost:3306/dcbapp-qa
      password: ''
    jpa:
      hibernate:
        ddl-auto: update
      show-sql: 'true'
  welcome:
    message: Welcome too Daily Code Buffer!!

---

    spring:
      profiles: prod
      datasource:
        username: root
        url: jdbc:mysql://localhost:3306/dcbapp-prod
        password: ''
      jpa:
        hibernate:
          ddl-auto: update
        show-sql: 'true'
    welcome:
      message: Welcome too Daily Code Buffer!!

---
```

## Running Springboot with multiple Profiles

→ pom.xml Änderung Spring-boot-tutorial auf 1.0.0

→ Terminal öffnen und mvn clean install aufrufen

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2028.png)

→ cd target 

→ dir

→ java -jar Spring-boot-tutorial-1.0.0.jar —spring.profiles.active=prod und ausführen

→ Die Anwendung startet mit der active= prod, somit wird das Schema dcbapp-prod ausgeführt

![Untitled](SPRING%20BOOT%20Aufgabe%203%20b6a0c9b2da104ad39574c290e0c85240/Untitled%2029.png)

## Springboot Actuator

→ Hinzufügen einer Dependency in der pom.xml

```java
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
```

→ [http://localhost:8082/actuator/health](http://localhost:8082/actuator/health)

→ [http://localhost:8082/actuator](http://localhost:8082/actuator/health)

→ [http://localhost:8082/actuator/](http://localhost:8082/actuator/health)info

application.yml

"*" = beinhaltet alle endpoints

```java
management:
      endpoints:
        web:
          exposure:
            include: "*"
```

## Custom Actuator Endpoint

→ neuer Ordner config

→ neue Klasse FeatureEntpoint

!! Aufpassen, dass in der application.yml die Abstände passen, da beim ersten Versuch mit den Actuator Endpoints nur 2 Endpoints bei mir wahren. (wegen Abstand)

## Exclude Actuator Endpoint

→ application.yml 

→ hinzufügen exclude:

→ was möchten wir excluden "env,beans"
