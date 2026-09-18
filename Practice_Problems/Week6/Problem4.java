public class Problem4 {

    public static void main(String[] args) {

        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(
            LibraryMember.batchPrint(members)
        );
    }
}


// ======================================
// LIBRARY MEMBER
// ======================================

class LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;


    public LibraryMember(
            String memberId,
            int borrowLimit) {

        if (memberId == null ||
            memberId.trim().length() < 4) {

            throw new IllegalArgumentException(
                "Invalid member ID"
            );
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }


    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }


    public int getBooksBorrowed() {
        return booksBorrowed;
    }


    public String displayInfo() {

        return "General | Books: "
                + booksBorrowed;
    }


    // ======================================
    // PROBLEM 4
    // ======================================

    public static String batchPrint(
            LibraryMember[] members) {

        StringBuilder report =
                new StringBuilder();

        for (LibraryMember member : members) {

            // Polymorphic method call
            member.displayInfo();

            if (member instanceof StudentMember) {

                StudentMember student =
                        (StudentMember) member;

                report.append(
                    "Student | Course: "
                    + student.getCourse()
                    + " | Books: "
                    + student.getBooksBorrowed()
                    + " [Course via downcast: "
                    + student.getCourse()
                    + "] | "
                );

            } else {

                report.append(
                    "General | Books: "
                    + member.getBooksBorrowed()
                    + " | "
                );
            }
        }

        return report.toString();
    }
}


// ======================================
// STUDENT MEMBER
// ======================================

class StudentMember extends LibraryMember {

    private String course;


    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);

        this.course = course;
    }


    public String getCourse() {
        return course;
    }


    @Override
    public String displayInfo() {

        return "Student | Course: "
                + course
                + " | Books: "
                + booksBorrowed;
    }
}
