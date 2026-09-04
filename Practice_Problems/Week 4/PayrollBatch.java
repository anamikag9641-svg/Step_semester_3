class Employee {
    private String empId;
    private double salary;

    // Constructor resolving parameter/field clash via this
    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    // raiseSalary resolving parameter/field clash via this
    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printFinalSalary() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }
}

public class PayrollBatch {
    public static void main(String[] args) {
        Employee[] team = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        double festivalBonus = 5000;

        // Apply bonus to every employee in a single pass and print result
        for (Employee emp : team) {
            emp.raiseSalary(festivalBonus);
            emp.printFinalSalary();
        }
    }
}