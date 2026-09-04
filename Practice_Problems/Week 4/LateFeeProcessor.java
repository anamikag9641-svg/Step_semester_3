class StudentAccount {
    private String regNo;
    private double totalFee;

    public StudentAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // Final method locked against being overridden
    public final double calculateLateFee(int daysLate) {
        // Flat 10% late fee on total fee for late payments
        return totalFee * 0.10;
    }

    // Final method locked against being overridden
    public final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);
            System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + lateFee);
        }
    }
}

public class LateFeeProcessor {
    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        // Single pass batch execution
        for (int i = 0; i < regNos.length; i++) {
            StudentAccount account = new StudentAccount(regNos[i], totalFees[i]);
            account.printSummary(daysLate[i]);
        }
    }
}