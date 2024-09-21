package MachineCoding.SnakeLadderUpdated.Models;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Dice {
    static int max = 6;
    static int min = 1;

    public int rollDice() {
        return current().nextInt(min, max);
    }

}
