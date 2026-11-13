import java.util.Scanner;

public class Problem5DigitSumReversal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int num = sc.nextInt();

        int temp = num;
        int sum = 0;
        int reverse = 0;

        while (temp > 0) {
            int digit = temp % 10;

            sum = sum + digit;
            reverse = reverse * 10 + digit;

            temp = temp / 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);

        sc.close();
    }
}