abstract class Room {
    String name;
    boolean available = true;

    Room(String name) {
        this.name = name;
    }

    abstract double calculatePrice(int days);
}

class StandardRoom extends Room {

    StandardRoom(String name) {
        super(name);
    }

    double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeRoom extends Room {

    DeluxeRoom(String name) {
        super(name);
    }

    double calculatePrice(int days) {
        return days * 150;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Room room;
    Customer customer;
    String start, end;
    int days;

    Reservation(Room room, Customer customer,
                String start, String end, int days) {

        this.room = room;
        this.customer = customer;
        this.start = start;
        this.end = end;
        this.days = days;
    }
}

class HotelSystem {

    static void reserve(Room r, Customer c,
                        String start, String end, int days) {

        if (!r.available) {
            System.out.println(r.name + " is not available.");
            return;
        }

        r.available = false;

        System.out.println("Reservation confirmed for " +
                c.name + ", " + r.name +
                " (" + start + "-" + end + ").");

        System.out.println("Price: $" + r.calculatePrice(days));
    }

    static void cancel(Room r, Customer c,
                       String start, String end) {

        r.available = true;

        System.out.println("Reservation for " + c.name +
                ", " + r.name + " (" + start + "-" +
                end + ") cancelled successfully.");
    }
}

public class HotelDemo {

    public static void main(String[] args) {

        Room standard = new StandardRoom("Standard Room 101");
        Room deluxe = new DeluxeRoom("Deluxe Room 201");

        Customer a = new Customer("Customer A");
        Customer b = new Customer("Customer B");
        Customer c = new Customer("Customer C");

        System.out.println("Standard Room 101 is available from Jan 1 to Jan 5.");

        HotelSystem.reserve(
                standard, a, "Jan 1", "Jan 5", 4);

        HotelSystem.reserve(
                standard, b, "Jan 3", "Jan 7", 4);

        HotelSystem.cancel(
                standard, a, "Jan 1", "Jan 5");

        HotelSystem.reserve(
                deluxe, c, "Feb 10", "Feb 12", 2);
    }
}