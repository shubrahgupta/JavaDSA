package MachineCoding.SnakeLadderGame.services;

import MachineCoding.SnakeLadderGame.Model.Ladder;
import MachineCoding.SnakeLadderGame.Model.Player;
import MachineCoding.SnakeLadderGame.Model.Snake;

import java.util.ArrayList;

public class GameManager {
    private static ArrayList<Player> players;
    private static ArrayList<Ladder> ladders;
    private static ArrayList<Snake> snakes;


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Player> players) {
        GameManager.players = players;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public void removePlayer(Player player) {
        players.remove(player);
    }

    public static ArrayList<Ladder> getLadders() {
        return ladders;
    }

    public static void setLadders(ArrayList<Ladder> ladders) {
        GameManager.ladders = ladders;
    }

    public static ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public static void setSnakes(ArrayList<Snake> snakes) {
        GameManager.snakes = snakes;
    }
    public static int getPlayerPosition(Player player) {
        return player.getPosition();
    }
    public static int isSnakeBitePosition(int playerPosition) {
        for(Snake snake: getSnakes()) {
            if (snake.getSnakeHeadPosition() == playerPosition) {
                return snake.getSnakeTailPosition();
            }
        }
        return -1;
    }

    public static int isLadderHikePosition(int playerPosition) {
        for(Ladder ladder: getLadders()) {
            if (ladder.getStartLadderPosition() == playerPosition) {
                return ladder.getEndLadderPosition();
            }
        }
        return -1;
    }





}
