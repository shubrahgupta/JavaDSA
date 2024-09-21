package MachineCoding.SnakeLadderUpdated;

import MachineCoding.SnakeLadderUpdated.Services.Game;

public class DriverClass {
    public static void main(String[] args) {
        Game game = new Game(10);
        game.playGame();
    }
}
