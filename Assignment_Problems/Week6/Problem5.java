class GymMember {

    private static int memberCounter = 2000;
    private static int membersEnrolled = 0;

    protected int monthlyFee;

    public final String membershipNumber;

    private int feesPaid;
    private String paymentMode;

    public GymMember(int monthlyFee) {

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                "Monthly fee must be positive"
            );
        }

        this.monthlyFee = monthlyFee;

        // Increment counter once for every object
        memberCounter++;

        // Assign final membership number
        membershipNumber = "GYM-" + memberCounter;

        membersEnrolled++;

        feesPaid = 0;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        paymentMode = mode;

        // Reuse the one-argument version
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}


class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}


public class Problem5 {

    public static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
             + nullSkipped + " null skipped | "
             + group + " group | "
             + individual + " individual";
    }


    public static void main(String[] args) {

        // Membership number
        GymMember m1 = new GymMember(1000);

        System.out.println(m1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        // Referral codes
        System.out.println(
            GymMember.isValidReferralCode("G45B")
        );

        System.out.println(
            GymMember.isValidReferralCode("G4B")
        );

        System.out.println(
            GymMember.isValidReferralCode("X45B")
        );

        // Pay fee
        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(m1.getFeesPaid());

        // Weekly check-in
        GymMember[] members = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };

        System.out.println(
            processWeeklyCheckIn(members)
        );
    }
}