import java.util.Scanner;



public class Terningspil {

    public static void main(String[] args) {
        startgame();
        Scanner scan = new Scanner(System.in);
        System.out.println("Spiller 1 indtast dit navn: ");
        Player player1 = new Player(scan.nextLine());
        System.out.println("Spiller 2 indtast dit navn: ");
        Player player2 = new Player(scan.nextLine());






    }
    private static void startgame(){
        System.out.println("Velkommen til terningespillet");

    }






}
