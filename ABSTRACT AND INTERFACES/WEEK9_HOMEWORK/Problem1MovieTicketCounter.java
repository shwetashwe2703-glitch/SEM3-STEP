
import java.util.Scanner;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20.0;

    abstract double getPrice();

    double calculateAmount(int count) {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    double getPrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    double getPrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    double getPrice() {
        return 400.0;
    }
}

public class Problem1MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket();
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket();
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket();
                    break;
                default:
                    continue;
            }

            double amount = ticket.calculateAmount(count);
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
