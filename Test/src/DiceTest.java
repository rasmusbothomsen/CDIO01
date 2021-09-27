import java.util.Random;

public class DiceTest {
    private static void main(String[]args){
        //Player player1 = new Player()
        int dice2;
        int dice1;

        int count=0;
        while(count<1000) {
            Random dice = new Random();
            dice1 = dice.nextInt(6) + 1;
            dice2 = dice.nextInt(6) + 1;
            System.out.println(dice1 + "\t" + dice2 + "\n");
            count++;
        }

    }
}
