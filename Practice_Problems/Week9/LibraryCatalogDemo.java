class Book {
    String isbn;
    String title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}

public class LibraryCatalogDemo {

    static String findBook(Book[] catalog, String targetIsbn) {
        int low = 0, high = catalog.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (catalog[mid].isbn.equals(targetIsbn))
                return catalog[mid].title;

            if (catalog[mid].isbn.compareTo(targetIsbn) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Book[] catalog = {
            new Book("0001112223", "Introduction to Algebra"),
            new Book("0002223334", "Beginning Python"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Data and Society"),
            new Book("0005556667", "European History")
        };

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}