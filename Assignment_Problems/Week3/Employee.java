public class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // 3-argument constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // 2-argument constructor for interns (chains to 3-arg constructor using this(...))
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true; // Overrides default isIntern set in chained constructor
    }

    // Instance method to print full profile
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("E-101", "Divya", 65000);
        Employee emp2 = new Employee("E-102", "Arjun");

        emp1.printProfile();
        emp2.printProfile();
    }
}