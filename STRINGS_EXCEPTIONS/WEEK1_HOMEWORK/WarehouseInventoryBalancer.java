import java.util.Scanner;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {

            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }

            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        String status;

        if (totalA == totalB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Status: " + status);
        System.out.println("Highest Quantity: " +
                highestQuantity + " (" +
                highestSection + ", Item " +
                (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] sectionA = new int[3];
        int[] sectionB = new int[3];

        System.out.println("Enter 3 quantities for Section A:");

        for (int i = 0; i < sectionA.length; i++) {
            sectionA[i] = scanner.nextInt();
        }

        System.out.println("Enter 3 quantities for Section B:");

        for (int i = 0; i < sectionB.length; i++) {
            sectionB[i] = scanner.nextInt();
        }

        analyzeInventory(sectionA, sectionB);

        scanner.close();
    }
}