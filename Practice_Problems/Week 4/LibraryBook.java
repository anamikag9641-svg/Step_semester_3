public class LibraryBook {
    private String title;
    private String isbn;

    // 2-argument constructor
    public LibraryBook(String title, String isbn) {
        this.title = title;
        // Default to "PENDING" if ISBN is null or empty
        if (isbn == null || isbn.trim().isEmpty()) {
            this.isbn = "PENDING";
        } else {
            this.isbn = isbn;
        }
    }

    // 1-argument constructor chaining via this(...)
    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public void printStatus() {
        System.out.println(title + " | " + isbn + " | Catalogued: true");
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        // Process every entry in a single pass
        for (int i = 0; i < titles.length; i++) {
            LibraryBook book = new LibraryBook(titles[i], isbns[i]);
            book.printStatus();
        }
    }
}