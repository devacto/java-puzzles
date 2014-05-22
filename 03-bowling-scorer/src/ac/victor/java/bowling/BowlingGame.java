package ac.victor.java.bowling;

/**
 * BowlingGame class keeps score of a bowling game.
 * Created by Victor on 22/05/14.
 */
public class BowlingGame {
    private int[] rolls = new int[21];
    private int currentRollIndex = 0;

    public void roll(int numberOfPinsKnocked) {
        rolls[currentRollIndex] = numberOfPinsKnocked;
        currentRollIndex++;
    }

    // Strike check
    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    // Spare check
    private boolean isSpare(int rollIndex) {
         return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    // Go through each frame and calculate total score for the game.
    public int score() {
        int score = 0;
        int rollIndex = 0;

        // Go through the rolls for each frame
        for (int frame = 0; frame < 10; frame++) {

            // If strike, then add score from next 2 bowls.
            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex ++;

            // If spare, then add score from next bowl.
            } else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;

            // Otherwise, add scores normally.
            } else {
                // If not spare, then calculate as per normal
                score += numberOfPinsKnockedInRolls(rollIndex);
                rollIndex += 2;
            }

        }

        return score;
    }

    // Calculate points in case other than spare or strike.
    private int numberOfPinsKnockedInRolls(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    // Calculate spare bonus.
    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    // Calculate strike bonus.
    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }
}
