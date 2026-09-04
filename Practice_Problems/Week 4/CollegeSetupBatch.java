class SrmStudent {
    private String name;

    // Static variables shared across all instances
    private static String collegeName;
    private static String academicYear;

    // Static block runs exactly once when class is loaded
    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + this.name);
    }
}

public class CollegeSetupBatch {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        // Creating multiple students in a loop without re-triggering static block
        for (String name : names) {
            new SrmStudent(name);
        }
    }
}