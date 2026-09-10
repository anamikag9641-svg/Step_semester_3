public class MembershipCard {
    private static String libraryName;
    private static String validUntil;
    private String studentName;

    // Static block runs exactly once when class is loaded
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
        System.out.println("Membership card issued: " + this.studentName);
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        // Loop creates multiple objects without triggering static block again
        for (String name : names) {
            new MembershipCard(name);
        }
    }
}