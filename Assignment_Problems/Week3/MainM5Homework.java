class EmployeeCompany {
    // Instance fields
    String empName;
    double salary;

    // Static fields shared across all instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment static counter on every object creation
    }

    // Static method: can only access static fields directly
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class MainM5Homework {
    public static void main(String[] args) {
        // Create three EmployeeCompany objects
        EmployeeCompany emp1 = new EmployeeCompany("Divya", 65000);
        EmployeeCompany emp2 = new EmployeeCompany("Arjun", 25000);
        EmployeeCompany emp3 = new EmployeeCompany("Suresh", 45000);

        // Call static method through the class name directly
        EmployeeCompany.printCompanyInfo();
    }
}