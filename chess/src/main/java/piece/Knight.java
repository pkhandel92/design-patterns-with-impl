package piece;

import board.Board;
import box.Box.Box;

public class Knight extends Piece {
    public Knight(boolean b) {
        super(b);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }

}
