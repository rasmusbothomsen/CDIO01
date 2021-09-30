
import java.time.Duration;
import java.time.Instant;

public class Classtester {
    public static void  main(String[]args) throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(500);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
        Dice dice = new Dice();
        int[] slag = dice.getDice();
        System.out.println(slag[0]+" "+slag[1]);
    }
}
