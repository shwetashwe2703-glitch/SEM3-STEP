import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {
        protected String name;
        protected double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        abstract double getBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        double getBonus() {
            return salary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        double getBonus() {
            return salary * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) {
            super(name, salary);
        }

        @Override
        double getBonus() {
            return 2000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;
                default:
                    employee = new Intern(name, salary);
            }

            employees.add(employee);
        }

        double total = 0;

        for (Employee employee : employees) {
            double bonus = employee.getBonus();

            System.out.printf("%s: %.2f%n", employee.name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}