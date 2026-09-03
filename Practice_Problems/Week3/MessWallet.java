public class MessWallet {
    // Private field for encapsulation
    private double balance;

    // Public constructor
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Starting at 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Top up method
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than zero.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    // Deduct method
    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct rejected: Amount must be greater than zero.");
        } else if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    // Getter for read-only access
    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}