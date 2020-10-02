package piece;

import board.Board;
import box.Box.Box;

public class Bishop extends Piece {
    public Bishop(boolean b) {
        super(b);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }

}
