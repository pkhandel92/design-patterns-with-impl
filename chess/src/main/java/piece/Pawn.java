package piece;

import board.Board;
import box.Box.Box;

public class Pawn extends Piece {
    public Pawn(boolean b) {
        super(b);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }


    public boolean isCastlingMove() {
        return false;
    }

}

