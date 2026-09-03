class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class ReferenceDemo {
    public static void main(String[] args) {
        // Create initial object
        IdCard ravi = new IdCard("Ravi", 0);

        // Reference copy (points to same object)
        IdCard duplicate = ravi;

        // Modify field using second reference
        duplicate.booksIssued = 3;

        // Print value as seen through first reference and check reference equality
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Create separate object with identical field values
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}