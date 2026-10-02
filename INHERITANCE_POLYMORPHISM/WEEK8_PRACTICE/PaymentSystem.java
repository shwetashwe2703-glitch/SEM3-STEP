import java.util.Scanner;

public class PaymentSystem {

    static abstract class Payment {
        protected double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double calculateAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) {
            super(amount);
        }

        @Override
        double calculateAmount() {
            return amount * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) {
            super(amount);
        }

        @Override
        double calculateAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) {
            super(amount);
        }

        @Override
        double calculateAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransferPayment(amount);
            }

            double result = payment.calculateAmount();

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}