import java.util.*;

interface Seat {
    String getId();
    double getPrice();
}

class RegularSeat implements Seat {
    String id;

    RegularSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumSeat implements Seat {
    String id;

    PremiumSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat implements Seat {
    String id;

    ReclinerSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 400;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    Set<String> booked = new HashSet<>();
    boolean started;

    boolean available(Seat s) {
        return !booked.contains(s.getId());
    }
}

class Booking {
    Customer customer;
    Show show;
    List<Seat> seats = new ArrayList<>();

    Booking(Customer c, Show s) {
        customer = c;
        show = s;
    }

    double total() {
        double total = 0;

        for (Seat s : seats)
            total += s.getPrice();

        return total;
    }

    void cancel() {
        if (show.started) {
            System.out.println("Cannot cancel: show has started.");
            return;
        }

        for (Seat s : seats)
            show.booked.remove(s.getId());

        System.out.println(customer.name +
                "'s booking cancelled. Seats released.");
    }
}

public class CampusPremiereDemo {

    static Booking book(Customer c, Show show, Seat... seats) {

        if (seats.length > 6) {
            System.out.println("Maximum 6 seats allowed.");
            return null;
        }

        for (Seat s : seats) {
            if (!show.available(s)) {
                System.out.println("Seat " + s.getId()
                        + " is already booked.");
                return null;
            }
        }

        Booking b = new Booking(c, show);

        for (Seat s : seats) {
            show.booked.add(s.getId());
            b.seats.add(s);
        }

        System.out.printf("%s booked %d seat(s). Total: ₹%.0f%n",
                c.name, seats.length, b.total());

        return b;
    }

    public static void main(String[] args) {

        Show show = new Show();

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        Booking b1 = book(asha, show, a1, a2, f5);

        book(ravi, show, a2);
        book(ravi, show, r1);

        b1.cancel();

        book(neha, show, a2);
    }
}