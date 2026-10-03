import java.util.*;

interface NotificationChannel {
    void send(Student student, String message);
}

class EmailChannel implements NotificationChannel {

    public void send(Student s, String message) {
        System.out.println("Email → " + s.name + ": " + message);
    }
}

class SmsChannel implements NotificationChannel {

    public void send(Student s, String message) {
        System.out.println("SMS → " + s.name + ": " + message);
    }
}

class AppChannel implements NotificationChannel {

    public void send(Student s, String message) {
        System.out.println("App → " + s.name + ": " + message);
    }
}

class Student {

    String name;
    String department;

    List<NotificationChannel> channels =
            new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel c) {
        channels.add(c);
    }
}

class Notice {

    String title;
    Set<String> departments;

    Notice(String title, String... departments) {
        this.title = title;
        this.departments =
                new HashSet<>(Arrays.asList(departments));
    }

    boolean valid() {
        return title != null &&
               !title.isBlank() &&
               !departments.isEmpty();
    }
}

class NoticeBoard {

    List<Student> students =
            new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }

    void post(Notice n) {

        if (!n.valid()) {
            System.out.println(
                "Cannot post notice: target department required.");
            return;
        }

        System.out.println(
            "Notice posted: " + n.title);

        for (Student s : students) {

            if (n.departments.contains(s.department)) {

                for (NotificationChannel c : s.channels)
                    c.send(s, n.title);
            }
        }
    }
}

public class CampusNoticeDemo {

    public static void main(String[] args) {

        Student asha =
                new Student("Asha", "CSE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi =
                new Student("Ravi", "ECE");

        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();

        board.addStudent(asha);
        board.addStudent(ravi);

        board.post(
            new Notice("Lab Closed Tomorrow", "CSE"));

        board.post(
            new Notice("Fee Deadline Extended",
                       "CSE", "ECE"));

        board.post(
            new Notice("Sports Day"));
    }
}