interface MembershipPlan {
    double calculateFee();
    String getName();
}

class Monthly implements MembershipPlan {

    public double calculateFee() {
        return 1000;
    }

    public String getName() {
        return "Monthly";
    }
}

class Quarterly implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public String getName() {
        return "Quarterly";
    }
}

class Annual implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public String getName() {
        return "Annual";
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

class Membership {

    Member member;
    MembershipPlan plan;
    private String status = "Active";

    Membership(Member m, MembershipPlan p) {
        member = m;
        plan = p;

        System.out.println(member.name + " purchased "
                + p.getName() + " membership.");
        System.out.println("Fee: ₹" + p.calculateFee());
        System.out.println("Status: Active");
    }

    void checkIn() {
        if (status.equals("Active"))
            System.out.println(member.name + " checked in.");
        else
            System.out.println("Check-in denied: membership is "
                    + status + ".");
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member.name +
                    "'s membership frozen.");
        } else {
            System.out.println("Cannot freeze an "
                    + status + " membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.name +
                    "'s membership unfrozen.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println(member.name +
                "'s membership expired.");
    }
}

public class FitZoneDemo {

    public static void main(String[] args) {

        Membership asha =
                new Membership(new Member("Asha"),
                        new Quarterly());

        Membership ravi =
                new Membership(new Member("Ravi"),
                        new Monthly());

        asha.checkIn();
        asha.freeze();
        asha.checkIn();

        ravi.expire();
        ravi.freeze();
    }
}
