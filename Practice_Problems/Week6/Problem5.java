public class Problem5 {

    public static void main(String[] args) {

        // =========================================
        // MEMBER NUMBER
        // =========================================

        LibraryMember m1 = new LibraryMember(3);

        System.out.println("Member Number: " + m1.memberNumber);
        System.out.println(
                "Members Enrolled: "
                        + LibraryMember.getMembersEnrolled()
        );


        // =========================================
        // RENEWAL CODE
        // =========================================

        System.out.println(
                LibraryMember.isValidRenewalCode("R12A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("R1A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("X12A")
        );


        // =========================================
        // BORROW BOOK
        // =========================================

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(
                "Books Borrowed: "
                        + m1.getBooksBorrowed()
        );


        // =========================================
        // NIGHTLY AUDIT
        // =========================================

        LibraryMember[] members = {
                new FacultyMember(5, "Physics"),
                null,
                new LibraryMember(3)
        };

        System.out.println(
                LibraryMember.processNightlyAudit(members)
        );
    }
}


// =================================================
// LIBRARY MEMBER
// =================================================

class LibraryMember {

    protected int borrowLimit;
    protected int booksBorrowed;

    // Shared counter
    private static int memberCounter = 100;

    // Number of members created
    private static int membersEnrolled = 0;

    // Cannot be changed after creation
    final String memberNumber;


    // =========================================
    // CONSTRUCTOR
    // =========================================

    public LibraryMember(int borrowLimit) {

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                    "Borrow limit must be positive"
            );
        }

        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        // Increment counter once per object
        memberCounter++;

        // Create final member number
        this.memberNumber =
                "LIB-" + memberCounter;

        membersEnrolled++;
    }


    // =========================================
    // BORROW BOOK
    // =========================================

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }


    // =========================================
    // OVERLOADED BORROW BOOK
    // =========================================

    public void borrowBook(String genre) {

        // Reuse no-argument method
        borrowBook();
    }


    public int getBooksBorrowed() {
        return booksBorrowed;
    }


    // =========================================
    // RENEWAL CODE
    // =========================================

    public static boolean isValidRenewalCode(
            String code) {

        // Check length first
        if (code == null || code.length() != 4) {
            return false;
        }

        // First character must be R
        if (code.charAt(0) != 'R') {
            return false;
        }

        // Second character must be digit
        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        // Third character must be digit
        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        // Fourth character must be uppercase letter
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }


    // =========================================
    // GET MEMBERS ENROLLED
    // =========================================

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }


    // =========================================
    // NIGHTLY AUDIT
    // =========================================

    public static String processNightlyAudit(
            LibraryMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;


        for (LibraryMember member : members) {

            // Handle null first
            if (member == null) {

                nullSkipped++;

            } else {

                processed++;

                if (member instanceof FacultyMember) {

                    faculty++;

                } else {

                    regular++;
                }
            }
        }


        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + faculty
                + " faculty | "
                + regular
                + " regular";
    }
}


// =================================================
// FACULTY MEMBER
// =================================================

class FacultyMember extends LibraryMember {

    private String department;


    public FacultyMember(
            int borrowLimit,
            String department) {

        super(borrowLimit);

        this.department = department;
    }
}