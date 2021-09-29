import java.util.Scanner;


public class Terningspil {
private static boolean is40;
private static Scanner scan =new Scanner(System.in);


    public static void main(String[] args) {
        is40=false;
        startgame();
        Scanner scan = new Scanner(System.in);
        System.out.print("Spiller 1 indtast dit navn: ");
        String playerName1 = scan.nextLine();
        Player player1 = new Player(playerName1,1);
        System.out.print("Spiller 2 indtast dit navn: ");
        String playerName2= scan.nextLine();
        Player player2 = new Player(playerName2,2);
        Dice dice = new Dice();
        dice.getDice();
        regler();

    }

    private static void startgame() {
        System.out.println("Velkommen til terningespillet");



    }

    private static void is40(Player a) {
        if (a.getPoint() < 40) is40=false;
        else is40=true;
    }


    private static void regler() {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Man vinder ved at opnå 40 point og efterfølgende slå to ens");
        System.out.println("Når man slår to ens får vedkommende en ekstra tur");
        System.out.println("Ved slag af to 1'ere mister vedkommende alle deres point - dog gælder ovenstående stadig");
        System.out.println("Det er også muligt at vinde ved at slå to 6'ere lige efter hinanden");
        System.out.println("Hvis man slår to 1'ere efter man har rundet de 40 point starter man forfra");
        System.out.println("--------------------------------------------------------------------------------------------");
    }



    // definerer spillerscore
    int playerScore1 = 0;
    int playerScore2 = 0;



public static void pressToPlay(Player player){
    boolean isPressed=false;
    while(!isPressed) {
        if (player.getPlayerNumber() == 1) {
            System.out.println(player.getName() + ", Tryk 1 for at kaste");
            if(scan.nextInt()==1){
                isPressed=true;
            }
        } else isPressed=false;
        if (player.getPlayerNumber() == 2) {
            System.out.println(player.getName() + ", Tryk 2 for at kaste");
            if(scan.nextInt()==2){
                isPressed=true;
            }
            else isPressed=false;
        }
    }
}


















}
