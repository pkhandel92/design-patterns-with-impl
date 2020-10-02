package piece;

import board.Board;
import box.Box.Box;

public class King extends Piece{

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
    public boolean isCastlingMove(){
        return false;
    }
}
