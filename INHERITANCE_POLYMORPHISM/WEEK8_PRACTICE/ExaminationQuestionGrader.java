import java.util.Scanner;

public class ExaminationQuestionGrader {

    static abstract class Question {
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;

        Question(String questionText, String correctAnswer,
                 String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double calculateScore();
    }

    static class MCQ extends Question {
        MCQ(String questionText, String correctAnswer,
            String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        double calculateScore() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }
            return 0;
        }
    }

    static class TrueFalse extends Question {
        TrueFalse(String questionText, String correctAnswer,
                  String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        double calculateScore() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }
            return 0;
        }
    }

    static class Essay extends Question {
        Essay(String questionText, String correctAnswer,
              String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        double calculateScore() {
            String answer = studentAnswer.toLowerCase();
            String[] keywords = correctAnswer.split(",");

            int count = 0;

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    count++;
                }
            }

            if (count >= 2) {
                return points * 0.75;
            } else if (count == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String[] lastPart = parts[6].trim().split("\\s+");
            double points = Double.parseDouble(lastPart[0]);

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                question = new TrueFalse(questionText, correctAnswer, studentAnswer, points);
            } else {
                question = new Essay(questionText, correctAnswer, studentAnswer, points);
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}