package MachineCoding.TicTacToe.Service;

import MachineCoding.TicTacToe.Model.Game;

import java.io.IOException;

public class DriverClass {
    public static void main(String[] args) throws IOException {
        Game gameTicTacToe = new Game();
        gameTicTacToe.initiateGame();
        gameTicTacToe.startGame();
    }

}
