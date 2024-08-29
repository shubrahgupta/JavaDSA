package MachineCoding.TicTacToe.Model;

public class PlayingArea {
    int size;
    Piece[][] board;

    public PlayingArea(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }
    public void makeMove(int x, int y, Player player) {
        if (this.board[x][y] != null) {
            System.out.println("Already filled");
        }
        else {
            this.board[x][y] = new Piece(player.getPieceType());
        }

    }
    public String getBoardPictorially() {

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < getSize(); i++) {
            for(int j = 0; j < getSize(); j++) {

                if (this.board[i][j] == null)
                    stringBuilder.append(" ");
                else {
                    stringBuilder.append(this.board[i][j].pieceType);
                }
                if (j != getSize()-1) {
                    stringBuilder.append(" | ");
                }


            }


            if (i != getSize()-1) {
                stringBuilder.append("\n---------\n");
            }

        }
        return stringBuilder.toString();
    }



//    public static void main(String[] args) {
//        PlayingArea playingArea = new PlayingArea(3);
//        System.out.println(playingArea.getBoardPictorially());
//    }
}
