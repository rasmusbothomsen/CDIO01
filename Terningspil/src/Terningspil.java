import java.util.Scanner;



public class Terningspil {

    public static void main(String[] args) {
        startgame();
        Scanner scan = new Scanner(System.in);
        System.out.print("Spiller 1 indtast dit navn: ");
        Player player1 = new Player(scan.nextLine());
        System.out.print("Spiller 2 indtast dit navn: ");
        Player player2 = new Player(scan.nextLine());
        Dice dice = new Dice();
        dice.getDice();

        regler();
        is40(player1);





    }
    private static void startgame(){
        System.out.println("Velkommen til terningespillet");

    }
    private static boolean is40(Player a){
        if (a.getPoint()<40) return false;
        else true;
    }

    //Demo flow start

    private static boolean toEndGame(Player a){
        if ;
        else return true;

    //Demo flow slut

    private static void regler() {
        System.out.println("Man vinder ved at opnå 40 point og efterfølgende slå to ens.");
        System.out.println("Når man slår to ens får vedkommende en ekstra tur");
        System.out.println("Ved slag af to en'ere mister vedkommende alle deres point - dog gælder ovenstående stadig.");
    }





}
