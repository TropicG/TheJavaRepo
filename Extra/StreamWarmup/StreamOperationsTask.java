
// Use a stream pipeline to process a list of employee names and salaries:
// filter by salary, sort, map to uppercase, limit results, and collect.

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class StreamOperationsTask {

    record Employee(String name, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice",  85_000),
                new Employee("Bob",    42_000),
                new Employee("Carol",  95_000),
                new Employee("Dave",   67_000),
                new Employee("Eve",   110_000),
                new Employee("Frank",  38_000)
        );

        // filter > 60,000 -> sorting -> mapping to names -> limiting the first 3 candidates
        List<String> result = employees.stream()
                .filter(employee -> employee.salary() > 60_000)
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .map(employee -> employee.name.toUpperCase())
                .limit(3)
                .toList();
        System.out.println("The trop 3 high earners are: " + result);

        // avarage employee's salary
        OptionalDouble avgSalary = employees.stream()
                .mapToDouble(Employee::salary)
                .average();
        System.out.println("The avarage salary of the employees is: " + avgSalary.orElse(0));

        // employee with max salary
        OptionalDouble maxSalary = employees.stream()
                .mapToDouble(Employee::salary)
                .max();
        System.out.println("The employee with the max salary is: " + maxSalary.orElse(0));
    }
}
