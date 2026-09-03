// PlacementRecord.java
class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    // Constructor to set all three fields
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method to print record in formatted line
    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class MainM1 {
    public static void main(String[] args) {
        // Create an array of PlacementRecord objects
        PlacementRecord[] records = new PlacementRecord[] {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Print each record using a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}