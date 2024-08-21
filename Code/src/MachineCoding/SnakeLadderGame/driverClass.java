package MachineCoding.SnakeLadderGame;

import MachineCoding.SnakeLadderGame.Model.Ladder;
import MachineCoding.SnakeLadderGame.Model.Player;
import MachineCoding.SnakeLadderGame.Model.Snake;
import MachineCoding.SnakeLadderGame.services.EventManager;
import MachineCoding.SnakeLadderGame.services.GameManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class driverClass {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("Code\\snakeLadder.txt"))) {
            int countSnakes = Integer.parseInt(br.readLine());
            ArrayList<Snake> snakes = new ArrayList<>();
            for(int i = 0; i < countSnakes; i++) {
               String[] snakeInfo = br.readLine().split(" ");
                snakes.add(new Snake(Integer.parseInt(snakeInfo[0]), Integer.parseInt(snakeInfo[1])));
            }
            GameManager.setSnakes(snakes);

            int countLadders = Integer.parseInt(br.readLine());
            ArrayList<Ladder> ladders = new ArrayList<>();
            for(int i = 0; i < countLadders; i++) {
                String[] ladderInfo = br.readLine().split(" ");
                ladders.add(new Ladder(Integer.parseInt(ladderInfo[0]), Integer.parseInt(ladderInfo[1])));
            }
            GameManager.setLadders(ladders);
            int countPlayers = Integer.parseInt(br.readLine());
            ArrayList<Player> players = new ArrayList<>();
            for(int i = 0; i < countPlayers; i++) {
                players.add(new Player(0, br.readLine()));
            }
            GameManager.setPlayers(players);
//            System.out.println(players);
            String line;
            boolean playerChance = false;
            while((line = br.readLine()) != null) {
                System.out.println(line);
                if (!playerChance) {
                    EventManager eventManager = new EventManager(players.get(0), Integer.parseInt(line));
                    System.out.println(eventManager.commmentary());
                    playerChance = true;
                }
                else {
                    EventManager eventManager = new EventManager(players.get(1), Integer.parseInt(line));
                    System.out.println(eventManager.commmentary());
                    playerChance = false;

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
