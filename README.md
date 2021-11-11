# Spring-boot-tutorial-Erweitern# SPRING BOOT Aufgabe 5

# Weitere Entität hinzufügen

Erweitere eines der ersten beiden durchgemachten Spring-Boot-Tutorials (Aufgabe 2 oder Aufgabe 3) mit
mindestens einer weiteren Domänenklasse, die zu einer der bestehenden Domänenklassen eine sinnvolle 1:n
bzw. n:1 Beziehung aufbaut. Implementiere alle Layers (Domäne, Service / Business, Repo, REST- oder
Thymeleaf-MVC-Controller) entsprechend. Globales Exceptionhandling, JUNIT-Tests sind obligatorisch. Bereite
dich auf eine Präsentation deiner Lösung vor.

→ neue Klasse Empolyee im Package entity erstellen

```java
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String employeeFirstName;
    private String employeeLastName;

}
```

→ neues Interface EmployeeRepositroy erweitert das Interface JpaRepositor<, dort geben wir als Objekt einmal Emloyee und einmal für die ID Long mit.

```java
@Repository
public interface EmployeeRepository extends JpaRepository< Employee, Long> {
}
```

→ neues Interface EmployeeService im Package service erstellen.

→ erstellen der Klasse EmployeeServiceImpl im Package service

→ durchstarten des Programmes die neue Tabelle sollte erstellt werden in der Datenbank.

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled.png)

→ die neue Tabelle wird natürlcih in der dcapp-qa gebildet.

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%201.png)

→ neue Klasse EmployeeController im Package controller

→ diese Klasse Markieren wir mit dem  @Interface  @RestConrtoller 

### saveEmployee

→ neue Methode in EmployeeController 

```java
@PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        LOGGER.info("Inside saveEmployee of EmloyeeController");
        return employeeService.saveEmployee(employee);
    }
```

→ neuer Methodenkopf in EmployeeService

```java
Employee saveEmployee(Employee employee);
```

→ neue Methode in EmployeeServiceImpl

```java
@Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
```

Testen der Methode in Insomina 

→ neuer Request erstellen save Employee Methode POST

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%202.png)

Eintrag in der Datenbank

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%203.png)

Ausgeben der gespeicherten Employees in der Datenbank

→ neue Methode fetchEmployeeList in EmployeeController

→ neuer Methodenkopf in EmployeeService

→ neue Methode fetchEmployeeList in EmployeeServiceImpl.

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%204.png)

→ neue Klasse EmployeeNotFoundException erweitert die Klasse Exception

→ mit Alt+einfg können wir uns vordefinierte Methoden einfügen lassen.

Ausgaben des Employees mit der ID / diese Methode muss von der EmployeeNotFoundException wissen.

→ neue Methode fetchEmployeeById in EmployeeController

```java
@GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException{
        return employeeService.fetchEmployeeById(employeeId);
    }
```

→ neuer Methodenkopf in EmployeeService

```java
Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;
```

→ neue Methode fetchEmployeeById in EmployeeServiceImpl

```java
@Override
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
    }
```

→ Testen in Insomnia

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%205.png)

Methode zum löschen eines Employees

→ neue Methode in EmployeeController / deleteEmployeeById

→ neuer Methodenkopf in EmployeeService / deleteEmployeeById

→ neue Methode in EmployeeServiceImpl / deleteEmployeeById

→ Testen in Insomnia (neuer Request)

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%206.png)

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%207.png)

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%208.png)

Hinzufügen von der @OneToMany Relationship in der Klasse Department 

```java
@OneToMany(
            cascade = CascadeType.ALL
    )
@JoinColumn(
        name = "department_id",
        referencedColumnName = "departmentId"
)
    private List<Employee> employeeList;
```

Hinzufügen der @ManyToOne Relationship in der Klasse Employee

```java
@ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "departmentId"
    )
    private Department department;
```

→ neue Test Klasse generieren DepartmentRepositoryTest2 

→ neue Test Klasse generieren EmployeeRepositoryTest

→ Neue Methode in DepartmentRepositoryTest2 saveDeparmtent()

```java
@Test
    public void saveDepartment(){
    Employee employee1 = Employee.builder()
            .employeeFirstName("Paul")
            .employeeLastName("Schonger")
            .build();

    Employee employee2 = Employee.builder()
            .employeeFirstName("Julian")
            .employeeLastName("Berger")
            .build();

    Employee employee3 = Employee.builder()
            .employeeFirstName("Jakob")
            .employeeLastName("Falch")
            .build();

    Department department = Department.builder()
            .departmentCode("IT-10")
            .departmentName("IT")
            .departmentAddress("London")
            .employeeList(List.of(employee1, employee2, employee3)).build();

            departmentRepository.save(department);
   }
```

Tabelle Employee:

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%209.png)

Tabelle Department:

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%2010.png)

→ neue Klasse EmployeeDTO (um ein Employee mit dem Department zu speichern)

→ neue Klasse EmployeeDTO im package service

Die Klasse besteht nur aus 4 Datenfelder und bei dem inizialisieren der Klasse geben wir alle @Interfaces mit bis auf @Entity.

→ neue Methode saveEmployee

Der Rückgabe Typ der Methode bleibt Employee, jedoch geben wir einen Partameter vom Typ EmployeeDTO als RequestBody mit. Die Methode benötigt ein Department , daher muss diese Methode von der DepartmentNotFoundException wissen.

```php
@PostMapping("/employees")
    public Employee saveEmployee(@RequestBody EmployeeDTO employee) throws DepartmentNotFoundException {
        LOGGER.info("Inside saveEmployee of EmloyeeController");
        return employeeService.saveEmployee(employee);
    }
```

→ neuer Methodenkopf im Interface EmplloyeeService

Der Parameter wir geändert zum Typ EmployeeDTO und die Exception wird der Methode mitgegeben.

```php
Employee saveEmployee(EmployeeDTO employee) throws DepartmentNotFoundException;
```

→ neue Methode in EmployeeServiceImpl saveEmployee

Da der Methode ein EmployeeDTO Objekt mitgegeben wird haben wir eine departmentId. Wir erstellen ein Objekt Optional und geben dort ein Department mit. am departmentRepository rufen wir die Methode findById auf und am mitgegebenen EmployeeDTO Objekt rufen wir die getDepartmentId() auf um das Department zu bekommen.

In der if-Anweisung überprüfen wir ob das Department nicht vorhanden ist. Wenn dies zutrifft wird eine DepartmentNotFoundException geworfen und wenn false wird ein Objekt vom Typ Employee gebuildet.

Als beispiel wir benötigen für die Erstellung eines Employees die employeeId, diese bekommen wir indem wir am mitgegebenen Objekt vom Typ EmployeeDTO (employee) die Methode getEmployeeId aufrufen, diese wird dann im Employee Objekt gespeichert als employeeId.

Mit department.get() bekommen wir das Department und speichern diese im Employee in die Variable department die vom Typ Department ist.

Zurückgegeben wird der Methodenaufruf am employeeRepository save, dort wird das Employee Objekt mitgegeben.

```php
public Employee saveEmployee(EmployeeDTO employee) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(employee.getDepartmentId());

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Availabel");
        }

        Employee employeeOptional = Employee.builder()
                .employeeId(employee.getEmployeeId())
                .employeeLastName(employee.getEmployeeLastName())
                .employeeFirstName(employee.getEmployeeFirstName())
                .department(department.get())
                .build();

        return employeeRepository.save(employeeOptional);
    }
```

→ Die Speicherung in die Datenbank erfolgt folgend:

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%2011.png)

![Untitled](SPRING%20BOOT%20Aufgabe%205%20663163f0109d48daad3dd448d12315c5/Untitled%2012.png)

<aside>
💡 Hinweis: Zubeginn war die Ausgabe in Insomnia verschachtelt, dass bedeutet z.B. die Ausgabe von Employee 1 wurde immer und immer wiederholt bis die Dateigröße erreicht war. Die Schuld hierbei war, dass die Bidirektionale Benziehung von OneToMany und ManyToOne in einer Art Schleife endetet, der Employee wurde aber wie gewünscht nur einmal gespeichert.                                                                                                                        Um diesen Fehler zu beheben Kommentierte ich die OneToMany Benziehung in der Klasse Department aus. Danach funktionierte die Ausgabe Problemlos.

</aside>
