import board.Board;
import box.Box.Box;
import move.Move;
import piece.King;
import piece.Piece;
import player.Player;

import java.util.List;

public class Chess {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameStatus status;
    private List<Move> moves;
    private Board board;
   public void initialize(Player p1,Player p2){
       player1=p1;player2=p2;
       board=new Board();
       if(p1.isWhite()){
           this.currentPlayer=p1;

       }else{
           this.currentPlayer=p2;
       }
       moves.clear();
   }
   public boolean isEnd(){
       return this.getStatus()!=GameStatus.ACTIVE;
   }

    private GameStatus getStatus() {
        return status;
    }
    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Box startBox = board.getBox(startX, startY);
        Box endBox = board.getBox(startY, endY);
        Move move = new Move( startBox, endBox,player);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player) {
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        // valid player
        if (player != currentPlayer) {
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhite()) {
            return false;
        }

        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())){
            return false;
        }

        // kill?
        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        // castling?
        if (sourcePiece != null && sourcePiece instanceof King
                && ((King) sourcePiece).isCastlingMove()) {
            move.setCastlingMove(true);
        }

        // store the move
        moves.add(move);

        // move piece from the stat box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece != null && destPiece instanceof King) {
            if(player.isWhite()) {
                this.setStatus(GameStatus.WHITE_WON);
            } else {
                this.setStatus(GameStatus.BLACK_WON);
            }
        }

        // set the current turn to the other player
        if(this.currentPlayer == player1) {
            this.currentPlayer = player2;
        } else {
            this.currentPlayer = player1;
        }

        return true;
    }

    private void setStatus(GameStatus status) {
       this.status=status;
    }

}
