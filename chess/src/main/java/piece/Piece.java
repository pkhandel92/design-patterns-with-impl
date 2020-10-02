package piece;

import board.Board;
import box.Box.Box;

public abstract class Piece {
    private boolean killed;
    private boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }
    public abstract boolean canMove(Board board, Box start, Box end);
}
