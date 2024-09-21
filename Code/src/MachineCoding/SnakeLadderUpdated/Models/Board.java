package MachineCoding.SnakeLadderUpdated.Models;

public class Board {
    private Cell[][] cells;
    private int sizeOfBoard;

    public Board(int sizeOfBoard) {
        this.cells = new Cell[sizeOfBoard][sizeOfBoard];
        for(int i = 0; i < sizeOfBoard; i++) {
            for(int j = 0; j < sizeOfBoard; j++) {
                this.cells[i][j] = new Cell();
            }
        }
        this.sizeOfBoard = sizeOfBoard;
    }
    public Cell getCell(int position) {

        int row = position/10;
        int column = position%10;

        return getCells()[row][column];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    public void setSizeOfBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }
}
