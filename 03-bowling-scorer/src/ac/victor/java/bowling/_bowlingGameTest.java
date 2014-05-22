package ac.victor.java.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the BowlingGame class.
 * Created by Victor on 22/05/14.
 */
public class _bowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    // Abstracted for-loop for multiple rolls.
    private void repeatedRolls(int numberOfRolls, int numberOfPinsKnocked) {
        for (int i = 0; i < numberOfRolls; i++) {
            bowlingGame.roll(numberOfPinsKnocked);
        }
    }

    // If I roll both 0 on every single frame,
    // I should score a 0 at the end of the game.
    @Test
    public void gutterGameTest() {
        repeatedRolls(20, 0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void singleRollTest() {
        bowlingGame.roll(4);
        bowlingGame.roll(4);
        repeatedRolls(18, 0);
        assertEquals(8, bowlingGame.score());
    }

    // If I score all 1s on every single frame,
    // I should score a 20 at the end of the bowling game
    @Test
    public void allOnesTest() {
        repeatedRolls(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    // If in 2 tries, the bowler knocks down all the pins, it is a spare.
    // The scoring of a spare is the sum of the number of pins knocked down ..
    // plus the number of pins knocked down in the next bowl.
    @Test
    public void oneSpareTest() {
        bowlingGame.roll(4);
        bowlingGame.roll(6); // Spare
        bowlingGame.roll(5);

        // Put in 0 for the rest of the frames
        repeatedRolls(17, 0);

        // Calculation for the first frame:   4 + 6 + 5 = 15
        // Calculation for the second frame:  5 + 0 = 5
        // Calculation for the next 8 frames: 8 * 0 = 0
        // Total for the game : 15 + 5 + 0 = 20
        assertEquals(20, bowlingGame.score());
    }

    @Test
    public void oneStrikeTest() {
        bowlingGame.roll(10); // Strike
        bowlingGame.roll(5);
        bowlingGame.roll(4);

        repeatedRolls(16, 0);

        // Calculation for the first frame: 10 + 5 + 4 = 19
        // Calculation for the second frame: 5 + 4 = 9
        // Calculation for the next 8 frames: 8 * 0 = 0
        // Total for the game: 28
        assertEquals(28, bowlingGame.score());
    }

    // If one has a strike for every roll ..
    // The total score should be 300.
    @Test
    public void allStrikesTest() {
        repeatedRolls(12, 10);
        assertEquals(300, bowlingGame.score());
    }

    // In the last frame, if the bowler bowls a spare, they get another bowl.
    // The score of this frame is the sum of the three bowls.
    @Test
    public void lastSpareTest() {
        // Gutter for the first 9 frames
        repeatedRolls(18, 0);

        // On the 10th frame, spare
        // then 5.
        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(5);

        assertEquals(15, bowlingGame.score());
    }

    // In the last frame, if the bowler bowls a strike, ..
    // they get another 2 bowls.
    // The score of this frame is the sum of the three bowls.
    @Test
    public void lastStrikeTest() {
        // Gutter for the first 9 frames
        repeatedRolls(18, 0);

        // On the 10th frame,
        // Strike, then 5 then 1.
        bowlingGame.roll(10);
        bowlingGame.roll(5);
        bowlingGame.roll(1);

        assertEquals(16, bowlingGame.score());
    }
}
