package MachineCoding.TicTacToe.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Game {
    PlayingArea playingArea;
    List<Player> playerList;
    boolean isGameComplete;

    public void initiateGame() {
        this.playingArea = new PlayingArea(3);
        this.playerList = new ArrayList<>();
        Player player1 = new Player("Sohan", PieceType.X);
        Player player2 = new Player("Chomu", PieceType.O);
        this.playerList.add(player1);
        this.playerList.add(player2);
        this.isGameComplete = false;
    }
    public Player getPlayerWithX() {
        for(Player player: playerList) {
            if (player.getPieceType() == PieceType.X)   return player;
        }
        return null;
    }
    public Player getPlayerWithO() {
        for(Player player: playerList) {
            if (player.getPieceType() == PieceType.O)   return player;
        }
        return null;
    }
    public Player gameWinner() {

        int pieceXCount = 0;
        int piecePopulated = 0;
        //horizontal check
        for(int i = 0; i < playingArea.getSize(); i++) {
            pieceXCount = 0;
            piecePopulated = 0;
            for(int j = 0; j < playingArea.getSize(); j++) {
                if (this.playingArea.board[i][j] != null) {
                    piecePopulated++;
                    if (this.playingArea.board[i][j].pieceType == PieceType.X) {
                        pieceXCount++;

                    }
                }

            }
            if (pieceXCount == 0 && piecePopulated == playingArea.getSize()) {
                return getPlayerWithO();
            }
            else if(pieceXCount == this.playingArea.getSize()) {
                return getPlayerWithX();
            }
        }


        //vertical check
        for(int i = 0; i < playingArea.getSize(); i++) {
            pieceXCount = 0;
            piecePopulated = 0;
            for(int j = 0; j < playingArea.getSize(); j++) {
                if (this.playingArea.board[j][i] != null) {
                    piecePopulated++;
                    if (this.playingArea.board[j][i].pieceType == PieceType.X) {
                        pieceXCount++;

                    }
                }
            }
            if (pieceXCount == 0 && piecePopulated == playingArea.getSize()) {
                return getPlayerWithO();
            }
            else if(pieceXCount == this.playingArea.getSize()) {
                return getPlayerWithX();
            }
        }

        pieceXCount = 0;
        piecePopulated = 0;
        //diagonal 1 check
        for(int i = 0; i < playingArea.getSize(); i++) {
            if (this.playingArea.board[i][i] != null) {
                piecePopulated++;
                if (this.playingArea.board[i][i].pieceType == PieceType.X) {
                    pieceXCount++;

                }
            }
        }
        if (pieceXCount == 0 && piecePopulated == playingArea.getSize()) {
            return getPlayerWithO();
        }
        else if(pieceXCount == this.playingArea.getSize()) {
            return getPlayerWithX();
        }

        pieceXCount = 0;
        piecePopulated = 0;
        //diagonal 2 check
        for(int i = 0; i < playingArea.getSize(); i++) {
            if (this.playingArea.board[i][playingArea.getSize()-i-1] != null) {
                piecePopulated++;
                if (this.playingArea.board[i][playingArea.getSize() - i - 1].pieceType == PieceType.X) {
                    pieceXCount++;
                }
            }
        }
        if (pieceXCount == 0 && piecePopulated == playingArea.getSize()) {
            return getPlayerWithO();
        }
        else if(pieceXCount == this.playingArea.getSize()) {
            return getPlayerWithX();
        }
        return null;


    }
    public void startGame() throws IOException {
        Deque<Player> players = new LinkedList<>();
        for(Player player: playerList) {
            players.addFirst(player);
        }
        boolean isGameComplete = false;
        while(!isGameComplete){
            Player onStrikePlayer = players.pollFirst();
            if (!isBoardFilled() && gameWinner() == null) {
                System.out.println(this.playingArea.getBoardPictorially());
                int x; int y;
                System.out.println("Coordinates: ");

                Scanner scanner = new Scanner(System.in);
                String[] coordinates = scanner.nextLine().split(",");
                x = Integer.parseInt(coordinates[0]);
                y = Integer.parseInt(coordinates[1]);
                this.playingArea.makeMove(x,y,onStrikePlayer);
                players.addLast(onStrikePlayer);

            }
            else {
                isGameComplete = true;
                if (gameWinner() == null) {
                    System.out.println("Tie");
                }
                else {
                    System.out.println(gameWinner().getName());
                    System.out.println(gameWinner().getPieceType());
                }

            }
        }

    }
    public boolean isBoardFilled() {
        for(Piece[] pieceRow: this.playingArea.board) {
            for(Piece pieceCell: pieceRow) {
                if (pieceCell == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Game gameTicTacToe = new Game();
        gameTicTacToe.initiateGame();
        gameTicTacToe.startGame();
    }
}
