import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        protected int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double getCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        @Override
        double getCharge() {
            return hours * 10;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        @Override
        double getCharge() {
            return 30 + (hours - 1) * 20;
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        @Override
        double getCharge() {
            return Math.max(hours * 50, 100);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                default:
                    vehicle = new Truck(hours);
            }

            vehicles.add(vehicle);
            types.add(type);
        }

        double total = 0;

        for (int i = 0; i < vehicles.size(); i++) {
            double charge = vehicles.get(i).getCharge();

            System.out.printf("%s: %.2f%n", types.get(i), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}