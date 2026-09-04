class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ReferenceDemoM4 {
    public static void main(String[] args) {
        // Create initial object
        HallTicket priya = new HallTicket("Priya", 0);

        // Reference copy (points to same object)
        HallTicket copy = priya;

        // Modify field using second reference
        copy.seatNumber = 45;

        // Print value as seen through first reference and check reference equality
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        // Create separate object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}