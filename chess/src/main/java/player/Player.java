package player;

public class Player {
    private String playerId;
    private boolean white;

    public String getPlayerId() {
        return playerId;
    }

    public boolean isWhite() {
        return white;
    }

    public Player(String playerId, boolean white) {
        this.playerId = playerId;
        this.white = white;
    }
}
