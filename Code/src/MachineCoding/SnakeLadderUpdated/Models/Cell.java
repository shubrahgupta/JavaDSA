package MachineCoding.SnakeLadderUpdated.Models;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Jump> jumps;

    public Cell() {
        jumps = new ArrayList<>();
    }

    public List<Jump> getJumps() {
        return jumps;
    }

    public void setJumps(List<Jump> jumps) {
        this.jumps = jumps;
    }
    public void addJump(Jump jump) {
        this.jumps.add(jump);
    }

}
