public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // No-argument constructor
    public MovieBookingProfile() {
        confirmed = false;
    }

    // Constructor chaining
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // Name getter
    public String getName() {
        return name;
    }

    // Name setter
    public void setName(String name) {
        this.name = name;
    }

    // Boolean getter
    public boolean isConfirmed() {
        return confirmed;
    }

    // Boolean setter
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // OTP setter - no getter
    public void setOtp(String otp) {
        if (otp != null && otp.matches("\\d{4,6}")) {
            this.otp = otp;
        }
    }

    public static void main(String[] args) {

        MovieBookingProfile p =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(p.getName());

        p.setConfirmed(true);

        System.out.println(p.isConfirmed());

        p.setOtp("4471");
    }
}