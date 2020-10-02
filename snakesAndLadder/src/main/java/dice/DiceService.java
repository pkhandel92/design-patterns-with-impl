package dice;

import java.util.Random;

public class DiceService {
    public int rollDice(){
        return new Random().nextInt(6)+1;
    }
}
