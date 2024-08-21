package MachineCoding.SnakeLadderGame.Model;

import MachineCoding.SnakeLadderGame.services.Constants;

public class Player {
    private int position;
    private String name;
    private boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Player(int position, String name) {
        this.position = position;
        this.name = name;
        this.status = Constants.INCONCLUSIVE_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

}
