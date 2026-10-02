public class Scorecard {

    private final boolean[] results;
    private int answerCount;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}