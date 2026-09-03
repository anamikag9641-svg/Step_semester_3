class Student {
    // Instance fields
    String name;
    double attendance;

    // Static fields shared across all instances
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // Increment static counter on every creation
    }

    // Static method: can only access static fields directly
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class MainM5 {
    public static void main(String[] args) {
        // Create two Student objects
        Student student1 = new Student("Anitha", 85.5);
        Student student2 = new Student("Karthik", 92.0);

        // Call static method through the class name directly
        Student.printCollegeInfo();
    }
}