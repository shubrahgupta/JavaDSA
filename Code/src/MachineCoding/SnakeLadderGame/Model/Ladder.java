package MachineCoding.SnakeLadderGame.Model;

public class Ladder {
    private int startLadderPosition;
    private int endLadderPosition;

    public Ladder(int startLadderPosition, int endLadderPosition) {
        this.startLadderPosition = startLadderPosition;
        this.endLadderPosition = endLadderPosition;
    }

    public int getStartLadderPosition() {
        return startLadderPosition;
    }

    private void setStartLadderPosition(int startLadderPosition) {
        this.startLadderPosition = startLadderPosition;
    }

    public int getEndLadderPosition() {
        return endLadderPosition;
    }

    private void setEndLadderPosition(int endLadderPosition) {
        this.endLadderPosition = endLadderPosition;
    }

    public int positionAfterUsingLadder(int playerPosition) {
        if (playerPosition == this.getStartLadderPosition()) {
            return this.getEndLadderPosition();
        }
        return playerPosition;
    }
}
