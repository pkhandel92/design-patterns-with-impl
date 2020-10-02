package board;

import box.Box.Box;
import piece.Bishop;
import piece.Knight;
import piece.Pawn;
import piece.Rook;

public class Board {
    private Box[][] boxes;
    public Board(){
        this.resetBoard();
    }

    private void resetBoard() {
        // initialize white pieces
        boxes[0][0] = new Box(0, 0, new Rook(true));
        boxes[0][1] = new Box(0, 1, new Knight(true));
        boxes[0][2] = new Box(0, 2, new Bishop(true));
        //...
        boxes[1][0] = new Box(1, 0, new Pawn(true));
        boxes[1][1] = new Box(1, 1, new Pawn(true));
        //...

        // initialize black pieces
        boxes[7][0] = new Box(7, 0, new Rook(false));
        boxes[7][1] = new Box(7, 1, new Knight(false));
        boxes[7][2] = new Box(7, 2, new Bishop(false));
        //...
        boxes[6][0] = new Box(6, 0, new Pawn(false));
        boxes[6][1] = new Box(6, 1, new Pawn(false));
        //...

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Box(i, j, null);
            }
        }
    }

    public Box[][] getBoxes() {
        return boxes;
    }

    public void setBoxes(Box[][] boxes) {
        this.boxes = boxes;
    }

    public Box getBox(int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return boxes[x][y];
    }
}
