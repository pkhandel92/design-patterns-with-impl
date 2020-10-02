package piece;

import board.Board;
import box.Box.Box;

public class Rook  extends Piece{

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}
