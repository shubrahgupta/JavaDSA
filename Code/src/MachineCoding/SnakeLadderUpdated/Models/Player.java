package MachineCoding.SnakeLadderUpdated.Models;

public class Player {
    private int playerId;
    private String name;
    private int currentPosition;

    public Player(int playerId, String name, int currentPosition) {
        this.playerId = playerId;
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
