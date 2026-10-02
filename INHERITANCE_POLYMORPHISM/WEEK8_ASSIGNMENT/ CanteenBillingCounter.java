import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        protected double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double getFinalAmount();
    }

    static class Student extends Customer {
        Student(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount * 0.90;
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount * 0.95;
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student(amount);
                    break;
                case "STAFF":
                    customer = new Staff(amount);
                    break;
                default:
                    customer = new Guest(amount);
            }

            customers.add(customer);
        }

        double total = 0;

        for (Customer customer : customers) {
            total += customer.getFinalAmount();
        }

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            String type;

            if (customer instanceof Student) {
                type = "STUDENT";
            } else if (customer instanceof Staff) {
                type = "STAFF";
            } else {
                type = "GUEST";
            }

            System.out.printf("%s: %.2f%n", type, customer.getFinalAmount());
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}