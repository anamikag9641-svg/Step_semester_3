import java.time.LocalDate;

abstract class Assignment {
    String title;
    int maxMarks;
    LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double applyPenalty(double marks, long lateDays);
}

class CodingAssignment extends Assignment {

    CodingAssignment(String t, int m, LocalDate d) {
        super(t, m, d);
    }

    double applyPenalty(double marks, long days) {
        return marks * Math.max(0, 1 - 0.10 * days);
    }
}

class WrittenAssignment extends Assignment {

    WrittenAssignment(String t, int m, LocalDate d) {
        super(t, m, d);
    }

    double applyPenalty(double marks, long days) {
        return marks * Math.max(0, 1 - 0.20 * days);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    LocalDate date;
    private String status = "Submitted";

    Submission(Student s, Assignment a, LocalDate d) {
        student = s;
        assignment = a;
        date = d;
    }

    void grade(double awarded) {

        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade: already graded.");
            return;
        }

        long lateDays = Math.max(0,
                date.toEpochDay() - assignment.dueDate.toEpochDay());

        double finalMarks =
                assignment.applyPenalty(awarded, lateDays);

        System.out.println(student.name + " graded: "
                + finalMarks + "/" + assignment.maxMarks);

        status = "Graded";
    }

    boolean isGraded() {
        return status.equals("Graded");
    }
}

public class AssignmentSubmissionDemo {

    static Submission submit(Student s, Assignment a, LocalDate date) {

        Submission sub = new Submission(s, a, date);

        long days = Math.max(0,
                date.toEpochDay() - a.dueDate.toEpochDay());

        System.out.println(s.name + "'s submission for "
                + a.title + " received.");

        if (days == 0)
            System.out.println("Submitted on time.");
        else
            System.out.println(days + " days late.");

        return sub;
    }

    public static void main(String[] args) {

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50,
                LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay", 50,
                LocalDate.of(2026, 3, 12));

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission s1 = submit(
                asha, coding, LocalDate.of(2026, 3, 10));

        Submission s2 = submit(
                ravi, written, LocalDate.of(2026, 3, 14));

        s1.grade(45);
        s2.grade(40);

        if (s1.isGraded())
            System.out.println(
                "Cannot resubmit: assignment already graded.");
    }
}