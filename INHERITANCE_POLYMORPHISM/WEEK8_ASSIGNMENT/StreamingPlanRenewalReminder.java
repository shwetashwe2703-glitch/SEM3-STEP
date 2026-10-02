import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    static abstract class Plan {
        protected String name;
        protected LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract LocalDate getRenewalDate();
    }

    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        LocalDate getRenewalDate() {
            return startDate.plusDays(30);
        }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        LocalDate getRenewalDate() {
            return startDate.plusDays(90);
        }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        LocalDate getRenewalDate() {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;
                default:
                    plan = new PremiumPlan(name, startDate);
            }

            plans.add(plan);
        }

        for (Plan plan : plans) {
            System.out.println(plan.name + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}