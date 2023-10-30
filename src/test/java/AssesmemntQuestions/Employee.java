package AssesmemntQuestions;

import java.util.ArrayList;
import java.util.List;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

class SalaryCal {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Add employees to the list
        employees.add(new Employee("Sai", 35, 14000.0));
        employees.add(new Employee("Shiv", 28, 68600.0));
        employees.add(new Employee("Bob", 32, 3676.0));
        employees.add(new Employee("Jay", 40, 129000.0));
        employees.add(new Employee("Mike", 25, 12790.0));

        double totalSalary = 0;
        int numEmployeesOlderThan30 = 0;

        for (Employee employee : employees) {
            if (employee.age > 30) {
                totalSalary += employee.salary;
                numEmployeesOlderThan30++;
            }
        }

        if (numEmployeesOlderThan30 > 0) {
            double averageSalary = totalSalary / numEmployeesOlderThan30;
            System.out.println("Average salary of employees older than 30: " + averageSalary);
        } else {
            System.out.println("No employees are older than 30.");
        }
    }
}
