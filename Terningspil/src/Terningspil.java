import java.util.Scanner;


public class Terningspil {
private static boolean is40;
private static boolean endgame;
private static boolean player1Won;
private static boolean player2Won;

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

    private static boolean isSame(int[] diceThrow){
        if(diceThrow[0]==diceThrow[1]){
            return true;
        }else return false;
    }







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

public static void playTurn(Player player,Dice dice){
        boolean turnOver;
        int[]playerThrow;
        int[]lastThrow={0,0};
        turnOver=false;
        while(!turnOver) {
            pressToPlay(player);
            playerThrow = dice.getDice();
            if (isSame(playerThrow) && playerThrow[0] == 1) {
                System.out.println("Du har slået 2 1'ere og mister alle dine point");
                player.setPoint(0);
            }
            else if(isSame(playerThrow)){
                player.addPoint(playerThrow[0]+playerThrow[1]);
                System.out.println("Du har slået 2 ens og får en tur mere");
                lastThrow=playerThrow;
            }
            else if(isSame(playerThrow)&&playerThrow[0]==6){
                System.out.println("Hvis du slår 2 6'ere igen vinder du");
                player.addPoint(playerThrow[0]+playerThrow[1]);
                if(lastThrow[0]==6&&lastThrow[1]==6){
                    System.out.println("Du har slået 2 6'ere i træk og vinder");
                    if(player.getPlayerNumber()==1) {player1Won=true; turnOver=true;}
                    else if(player.getPlayerNumber()==2) {player2Won=true; turnOver=true;}
                }
            }
            if(!isSame(playerThrow)){
                player.addPoint(playerThrow[0]+playerThrow[1]);
                turnOver=true;

            }
        }

}


















}
