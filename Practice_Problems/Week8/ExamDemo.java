import java.util.*;

abstract class Question {
    String text;
    int marks;

    Question(String text, int marks) {
        this.text = text;
        this.marks = marks;
    }

    abstract boolean checkAnswer(String answer);
}

class MCQ extends Question {
    String correct;

    MCQ(String text, String correct, int marks) {
        super(text, marks);
        this.correct = correct;
    }

    boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correct);
    }
}

class TrueFalse extends Question {
    boolean correct;

    TrueFalse(String text, boolean correct, int marks) {
        super(text, marks);
        this.correct = correct;
    }

    boolean checkAnswer(String answer) {
        return Boolean.parseBoolean(answer) == correct;
    }
}

class Attempt {
    HashMap<Question, String> answers = new HashMap<>();
    boolean submitted = false;

    void answer(Question q, String ans) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        answers.put(q, ans);
        System.out.println("Answer recorded for Question.");
    }

    void submit() {
        submitted = true;
        System.out.println("Exam submitted.");
    }

    void result() {
        int score = 0;
        int total = 0;

        for (Question q : answers.keySet()) {
            total += q.marks;

            if (q.checkAnswer(answers.get(q))) {
                score += q.marks;
                System.out.println("Correct (" + q.marks + " points)");
            } else {
                System.out.println("Incorrect (0 points)");
            }
        }

        System.out.println("Total score: " + score + "/" + total);
    }
}

public class ExamDemo {

    public static void main(String[] args) {

        Question q1 =
                new MCQ("Capital of India?", "C", 5);

        Question q2 =
                new TrueFalse("Java is an OOP language?", false, 5);

        Attempt a = new Attempt();

        System.out.println("Exam A started by Student 1.");

        a.answer(q1, "C");
        a.answer(q2, "True");

        a.submit();

        System.out.println("Result:");
        a.result();

        a.answer(q1, "B");
    }
}