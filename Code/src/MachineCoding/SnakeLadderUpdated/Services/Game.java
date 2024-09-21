package MachineCoding.SnakeLadderUpdated.Services;

import MachineCoding.SnakeLadderUpdated.Models.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Game {
    Deque<Player> playerList;
    List<Jump> jumps;
    Board board;
    List<Dice> dices;

    public Game(int sizeOfBoard) {
        initialiseGame(sizeOfBoard);
    }
    public void initialiseGame(int sizeOfBoard){
        this.playerList = new LinkedList<>();
        this.jumps = new ArrayList<>();
        this.board = new Board(sizeOfBoard);
        this.dices = new ArrayList<>();
        addPlayers(2, new ArrayList<>(Arrays.asList("Mohan", "Mithi")));
        addDice(1);
        addJumps(5, 5);
        associateJumpsToCells();
        System.out.println("Game starts...");
        playGame();

    }

    public void playGame() {
        Player winner = null;
        while (winner == null && !playerList.isEmpty()) {
            Player currentPlayer = playerList.pollFirst();
            System.out.println("Current Player " + currentPlayer.getName());

            int currentMove = playDice();
            System.out.println("Dice rolls " + currentMove);

            int newPosition = finalPositionForMove(currentMove, currentPlayer);
            currentPlayer.setCurrentPosition(newPosition);
            System.out.println(currentPlayer.getName() + " at " + newPosition);

            // Check if this player has won
            winner = checkWinner(newPosition, currentPlayer);

            if (winner != null) {
                System.out.println("Winner: " + winner.getName());
                break;
                // Only add the player back to the queue if they haven't won

            } else {
                playerList.addLast(currentPlayer);
            }
        }
    }

    public Player checkWinner(int currentPosition, Player currentPlayer) {
        if (currentPosition >= (board.getSizeOfBoard() * board.getSizeOfBoard()) - 1) {

            return currentPlayer;
        }
        else return null;
    }

    public int finalPositionForMove(int currentMove, Player player) {
        int finalPositionAfterRoll = player.getCurrentPosition() + currentMove;

        if (checkWinner(finalPositionAfterRoll, player) != null) {

            return finalPositionAfterRoll;
        }

        Set<Integer> visitedPositions = new HashSet<>(); // To track visited cells

        while (!board.getCell(finalPositionAfterRoll).getJumps().isEmpty()) {
            if (visitedPositions.contains(finalPositionAfterRoll)) {
//                System.out.println("Cycle detected, exiting...");
                break; // Break if we encounter a cycle
            }

            visitedPositions.add(finalPositionAfterRoll);
            System.out.println(player.getName() + " at " + finalPositionAfterRoll);

            Cell cellUnderObservation = board.getCell(finalPositionAfterRoll);
            List<Jump> jumps = cellUnderObservation.getJumps();
            for (Jump jump : jumps) {
                if (cellUnderObservation == board.getCell(jump.getStart())) {
                    System.out.println("Jump detected...");
                    finalPositionAfterRoll = jump.getEnd();
                    player.setCurrentPosition(finalPositionAfterRoll);
                    System.out.println(jump.getJumpType() + " at " + jump.getStart());
                    break;
                }
            }
        }
        return finalPositionAfterRoll;
    }

    public int playDice() {
        int currentMove = 0;
        for(Dice dice: dices) {
            currentMove += dice.rollDice();
        }
        return currentMove;
    }

    public void addPlayers(int numOfPlayers, ArrayList<String> playerNames) {
        for(int i = 0; i < numOfPlayers; i++) {
            this.playerList.add(new Player(i+1, playerNames.get(i), 0));
            System.out.println(playerNames.get(i));
        }
    }

    public void addDice(int numOfDice) {
        for(int i = 0; i < numOfDice; i++) {
            this.dices.add(new Dice());
        }
    }

    public void addJumps(int numOfLadder, int numOfSnake) {
        int ladderCount = 0, snakeCount = 0;
        while(((ladderCount < numOfLadder) || (snakeCount < numOfSnake))) {
            int start = ThreadLocalRandom.current().nextInt(1,board.getSizeOfBoard()*board.getSizeOfBoard()-2);
            int end = ThreadLocalRandom.current().nextInt(1,board.getSizeOfBoard()*board.getSizeOfBoard()-2);

            if (start < end) {
                this.jumps.add(new Jump(start, end, JumpType.LADDER));
                ladderCount++;
            }
            else if (start > end) {
                this.jumps.add(new Jump(start, end, JumpType.SNAKE));
                snakeCount++;
            }

        }
    }

    public void associateJumpsToCells() {

        for(Jump jump: jumps) {
            Cell start = board.getCell(jump.getStart());
            Cell end = board.getCell(jump.getEnd());
            start.addJump(jump);
            end.addJump(jump);
            System.out.println(jump.getJumpType() + " - " + jump.getStart() + " " + jump.getEnd());

        }
    }




}
