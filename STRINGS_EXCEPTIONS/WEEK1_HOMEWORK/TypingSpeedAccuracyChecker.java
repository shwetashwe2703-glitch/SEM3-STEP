import java.util.Scanner;

public class TypingSpeedAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matchedCharacters * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n",
                matchedCharacters, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position " +
                    (firstMismatch + 1) + " ('" +
                    original.charAt(firstMismatch) + "' vs '" +
                    typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);

        scanner.close();
    }
}