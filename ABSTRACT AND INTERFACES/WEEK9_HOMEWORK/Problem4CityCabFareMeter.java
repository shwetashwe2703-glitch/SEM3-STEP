
import java.util.Scanner;

interface NightService {
    double calculateNightFare(double fare);
}

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        return Math.max(100, km * getRate());
    }

    boolean hasNightService() {
        return this instanceof NightService;
    }

    double getFinalFare(String time) {
        double fare = calculateFare();

        if (time.equals("NIGHT") && hasNightService()) {
            return ((NightService) this)
                    .calculateNightFare(fare);
        }

        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

public class Problem4CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT") &&
                    !cab.hasNightService()) {
                System.out.println(
                        type + ": night service not available");
                continue;
            }

            double fare = cab.getFinalFare(time);

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
