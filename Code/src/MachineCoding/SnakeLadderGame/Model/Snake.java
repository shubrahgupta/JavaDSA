package MachineCoding.SnakeLadderGame.Model;

public class Snake {
    private int snakeHeadPosition;
    private int snakeTailPosition;

    public Snake(int snakeHeadPosition, int snakeTailPosition) {
        this.snakeHeadPosition = snakeHeadPosition;
        this.snakeTailPosition = snakeTailPosition;
    }

    public int getSnakeHeadPosition() {
        return snakeHeadPosition;
    }

    private void setSnakeHeadPosition(int snakeHeadPosition) {
        this.snakeHeadPosition = snakeHeadPosition;
    }

    public int getSnakeTailPosition() {
        return snakeTailPosition;
    }

    private void setSnakeTailPosition(int snakeTailPosition) {
        this.snakeTailPosition = snakeTailPosition;
    }

    public int positionAfterSnakeBite(int playerPosition) {
        if (playerPosition == this.getSnakeHeadPosition()) {
            return this.getSnakeTailPosition();
        }
        return playerPosition;
    }
}
