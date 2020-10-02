import Ladder.Ladder;
import Player.Player;
import Snake.Snake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakesAndLadderBoard {
    List<Snake> snakes;
    List<Ladder> ladders;
    Map<Player,Integer> playerPieces;

    public void initialize(List<Snake>snakes,List<Ladder> ladders){
        this.snakes=snakes;
        this.ladders=ladders;
        playerPieces=new HashMap<Player, Integer>();
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<Player, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<Player, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }
}
