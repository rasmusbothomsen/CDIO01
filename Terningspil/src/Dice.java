import java.util.Random;

public class Dice {
    public int[] get;
    private Random dice = new Random();


    public int[] getDice() {
        int dice1 = dice.nextInt(6)+1;
        int dice2 = dice.nextInt(6)+1;
        return new int[]{dice1,dice2};
    }
}
