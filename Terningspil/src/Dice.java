import java.util.Random;

public class Dice {
    private Random dice = new Random();
    private int dice1;
    private int dice2;

    public int[] getDice1() {
        this.dice1 = dice.nextInt(6) + 1;
        this.dice2 = dice.nextInt(6) + 1;
        return new int[]{dice1, dice2};
    }
}
