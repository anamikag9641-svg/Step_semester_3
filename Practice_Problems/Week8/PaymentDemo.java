import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        System.out.println("Payment processed through Credit Card.");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        System.out.println("Payment processed through PayPal.");
        return false;
    }
}

class Order {
    String customer;
    ArrayList<Product> products = new ArrayList<>();
    String status = "Pending";

    Order(String customer) {
        this.customer = customer;
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void pay(PaymentMethod method) {

        if (products.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        double total = 0;

        for (Product p : products)
            total += p.price;

        boolean success = method.processPayment(total);

        if (success) {
            status = "Paid";
            System.out.println("Payment for Order " +
                    customer + " successful.");
        } else {
            System.out.println("Payment for Order " +
                    customer + " failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class PaymentDemo {

    public static void main(String[] args) {

        Order x = new Order("X");

        x.addProduct(new Product("Product A", 100));
        x.addProduct(new Product("Product B", 50));

        System.out.println("Order created for Customer X.");
        System.out.println("Payment initiated via Credit Card for Order X.");

        x.pay(new CreditCardPayment());

        Order y = new Order("Y");

        System.out.println("Order created for Customer Y.");
        y.pay(new CreditCardPayment());

        Order z = new Order("Z");

        z.addProduct(new Product("Product C", 100));

        System.out.println("Order created for Customer Z.");
        System.out.println("Payment initiated via PayPal for Order Z.");

        z.pay(new PayPalPayment());
    }
}