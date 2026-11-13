import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[3];

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }

        return (double) sum / marks.length;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void displayResult() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(),
                calculateAverage(),
                calculateGrade());
    }
}

public class Problem10StudentResultCard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.next();

        int[] marks = new int[3];

        System.out.println("Enter three marks:");

        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }

        Student student = new Student(name, marks);

        student.displayResult();

        sc.close();
    }
}