package move;

import box.Box.Box;
import piece.Piece;
import player.Player;

public class Move {
    private Box start;
    private Box end;
    private Piece pieceMoved;
    private Player player;
    private Piece pieceKilled;
    private boolean castlingMove;

    public Move(Box start, Box end, Player player) {
        this.start = start;
        this.end = end;
        this.player = player;
    }
    public boolean isCastlingMove(){
        return this.castlingMove==true;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public Box getStart() {
        return start;
    }

    public void setStart(Box start) {
        this.start = start;
    }

    public Box getEnd() {
        return end;
    }

    public void setEnd(Box end) {
        this.end = end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }
}
