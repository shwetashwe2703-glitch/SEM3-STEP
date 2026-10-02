import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        protected int units;

        Room(int units) {
            this.units = units;
        }

        abstract double getBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super(units);
        }

        @Override
        double getBill() {
            return units * 8;
        }
    }

    static class SharedRoom extends Room {
        private int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        double getBill() {
            return (units * 6.0) / occupants;
        }
    }

    static class ACRoom extends Room {
        ACRoom(int units) {
            super(units);
        }

        @Override
        double getBill() {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(units, occupants);
                    break;
                default:
                    room = new ACRoom(units);
            }

            rooms.add(room);
            types.add(type);
        }

        double total = 0;

        for (int i = 0; i < rooms.size(); i++) {
            double bill = rooms.get(i).getBill();

            System.out.printf("%s: %.2f%n", types.get(i), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}