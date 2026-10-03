
interface WashType {
    int getDuration();
    double getCharge();
    String getName();
}

class QuickWash implements WashType {
    public int getDuration() { return 30; }
    public double getCharge() { return 20; }
    public String getName() { return "Quick"; }
}

class NormalWash implements WashType {
    public int getDuration() { return 45; }
    public double getCharge() { return 30; }
    public String getName() { return "Normal"; }
}

class HeavyWash implements WashType {
    public int getDuration() { return 60; }
    public double getCharge() { return 45; }
    public String getName() { return "Heavy"; }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class WashingMachine {
    private String id;
    private boolean busy;

    WashingMachine(String id) {
        this.id = id;
    }

    public boolean isFree() {
        return !busy;
    }

    public void start() {
        busy = true;
    }

    public void complete() {
        busy = false;
    }

    public String getId() {
        return id;
    }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType wash;

    WashCycle(Student s, WashingMachine m, WashType w) {
        student = s;
        machine = m;
        wash = w;
    }
}

public class HostelLaundryDemo {

    static void startWash(Student s, WashingMachine m, WashType w) {
        if (!m.isFree()) {
            System.out.println("Machine " + m.getId() + " is currently busy.");
            return;
        }

        m.start();
        new WashCycle(s, m, w);

        System.out.println(w.getName() + " wash started on " +
                m.getId() + " for " + s.name);
        System.out.println("Duration: " + w.getDuration() +
                " min, Charge: ₹" + w.getCharge());
    }

    static void completeWash(WashingMachine m) {
        m.complete();
        System.out.println(m.getId() + " cycle completed. Machine is now free.");
    }

    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        startWash(asha, m1, new QuickWash());
        startWash(ravi, m1, new HeavyWash());
        startWash(ravi, m2, new HeavyWash());

        completeWash(m1);

        startWash(neha, m1, new NormalWash());
    }
}