class FeeAccount {
    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

public class BatchPaymentProcessor {
    public static void processPayment(FeeAccount account, double amount) {
        account.pay(amount);
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double paymentAmount = 60000;
        int hostelCount = 0;
        int dayScholarCount = 0;

        // Process batch using instanceof dispatch and simple counters
        for (FeeAccount account : accounts) {
            processPayment(account, paymentAmount);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else if (account instanceof FeeAccount) {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}