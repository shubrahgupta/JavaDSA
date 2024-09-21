package MachineCoding.SnakeLadderUpdated.Models;

public class Jump {
    private int start;
    private int end;
    private JumpType jumpType;

    public JumpType getJumpType() {
        return jumpType;
    }

    public void setJumpType(JumpType jumpType) {
        this.jumpType = jumpType;
    }

    public Jump(int start, int end, JumpType jumpType) {
        this.start = start;
        this.end = end;
        this.jumpType = jumpType;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
