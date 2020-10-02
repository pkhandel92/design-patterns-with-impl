import Ladder.Ladder;
import Player.Player;
import Snake.Snake;
import dice.DiceService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderService {
    private static final int DEFAULT_BOARDSIZE =100 ;
    private SnakesAndLadderBoard snakesAndLadderBoard;
    private Queue<Player> player;
    private int noOfDices;
    private int initialPlayersCount;
    private DiceService diceService;

    public SnakeAndLadderService(SnakesAndLadderBoard snakesAndLadderBoard, List<Player> player, int noOfDices) {
        this.snakesAndLadderBoard = snakesAndLadderBoard;
        setPlayer(player);
        this.noOfDices = noOfDices;
    }

    public DiceService getDiceService() {
        return diceService;
    }

    public void setDiceService(DiceService diceService) {
        this.diceService = diceService;
    }

    public SnakesAndLadderBoard getSnakesAndLadderBoard() {
        return snakesAndLadderBoard;
    }

    public void setSnakesAndLadderBoard(SnakesAndLadderBoard snakesAndLadderBoard) {
        this.snakesAndLadderBoard = snakesAndLadderBoard;
    }

    public Queue<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> players) {
        this.initialPlayersCount=players.size();
        this.player = new LinkedList<Player>();
        for (Player player:players){
            snakesAndLadderBoard.getPlayerPieces().put(player,0);
            this.player.add(player);
        }
    }

    public int getNoOfDices() {
        return noOfDices;
    }

    public void setNoOfDices(int noOfDices) {
        this.noOfDices = noOfDices;
    }
    public void startGame(){
        while(!isGameCompleted()){
            int totalDiceValue = getTotalValueAfterDiceRolls(); // Each player rolls the dice when their turn comes.
            Player currentPlayer = player.poll();
            movePlayer(currentPlayer, totalDiceValue);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                snakesAndLadderBoard.getPlayerPieces().remove(currentPlayer);
            } else {
                player.add(currentPlayer);
            }
        }
    }

    private boolean hasPlayerWon(Player currentPlayer) {
        return snakesAndLadderBoard.getPlayerPieces().get(currentPlayer)==DEFAULT_BOARDSIZE;

    }

    private void movePlayer(Player currentPlayer, int totalDiceValue) {
        int prevPosition=snakesAndLadderBoard.getPlayerPieces().get(currentPlayer);
        int newPostion=prevPosition+totalDiceValue;
        int boardSize=DEFAULT_BOARDSIZE;
        if(newPostion<=boardSize){
            newPostion=getNewPostionAfterSnakesAndLadders(newPostion);
        }
        snakesAndLadderBoard.getPlayerPieces().put(currentPlayer,newPostion);

    }

    private int getNewPostionAfterSnakesAndLadders(int newPostion) {
        int prevPosition;
        do{
            prevPosition=newPostion;
            for ( Snake snake:snakesAndLadderBoard.getSnakes()){
                if(snake.getStartPosition()==newPostion){
                    newPostion=snake.getEndPosition();
                }
            }
            for ( Ladder ladder:snakesAndLadderBoard.getLadders()){
                if(ladder.getStartPosition()==newPostion){
                    newPostion=ladder.getEndPosition();
                }
            }

        }while (newPostion!=prevPosition);
        return prevPosition;
    }

    private int getTotalValueAfterDiceRolls() {
        return diceService.rollDice();
    }

    private boolean isGameCompleted() {
        if (player.size()<initialPlayersCount)
            return true;
        return false;
    }

}
