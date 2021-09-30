
import java.util.Scanner;

public class Terningspil {
private static boolean is40;
private static boolean endgame;
private static boolean player1Won;
private static boolean player2Won;

private static final Scanner scan =new Scanner(System.in);

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
        player2.setPoint(37);        player1.setPoint(37);

        while (!endgame){
            if(player1.getPoint()<40) {
                playTurn(player1, dice);
            }
            if(player1Won&&!endgame){
                endGameTurn(player1,dice);
            }
            if(endgame){
                break;
            }
            if (player2.getPoint()<40) {
                playTurn(player2, dice);
            }
            if(player2Won&&!endgame){
                endGameTurn(player2,dice);
            }
            if(endgame){
                break;
            }
            if(player1Won){
                endGameTurn(player1,dice);
            }
            if(endgame){
                break;
            }
            if (player2Won){
                endGameTurn(player2,dice);
            }
            if(!endgame) {
                is40(player1);
                is40(player2);
            }
        }
        whoWon(player1,player2);
        System.out.println("Vil i spille igen? y/n");
        String playAgain = scan.nextLine();
        if (playAgain.charAt(0)=='y'){
            restartGame();
            main(null);
        }
    }

    private static void startgame() {
        System.out.println("Velkommen til terningespillet");
regler();
    }
    private static void is40(Player a) {
        if (a.getPoint() < 40) is40=false;
        else {
            if(a.getPlayerNumber()==1){
                is40=true;
                player1Won=true;
            }
            else if(a.getPlayerNumber()==2){
                is40=true;
                player2Won=true;
            }
        }
    }
    private static void printPoints(Player player){
        System.out.println(player.getName()+" Har nu "+player.getPoint()+" Points\n");
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
        return diceThrow[0] == diceThrow[1];
    }
    public static void restartGame(){
        player2Won=false;
        player1Won=false;
        endgame=false;
        is40=false;
    }
public static void pressToPlay(Player player){
    boolean isPressed=false;
    boolean rightButton=false;
    while(!isPressed) {
        if (player.getPlayerNumber() == 1) {
            System.out.println(player.getName() + ", Tryk 1 for at kaste");
            String buttonPressed = scan.nextLine();
            if (buttonPressed.charAt(0)=='1') rightButton=true;
            if(rightButton){
                isPressed=true;
            }
        }
        if (player.getPlayerNumber() == 2) {
            System.out.println(player.getName() + ", Tryk 2 for at kaste");
            String buttonPressed = scan.nextLine();
            if (buttonPressed.charAt(0)=='2') rightButton=true;
            if(rightButton){
                isPressed=true;
            }
        }
    }
}

public static void endGameTurn(Player player, Dice dice){
        int[] playerThrow;
        pressToPlay(player);
        playerThrow= dice.getDice();
    System.out.println("Du slog "+playerThrow[0]+" og "+playerThrow[1]);
    if(isSame(playerThrow)&&playerThrow[0]!=1){
            endgame=true;
            switch (player.getPlayerNumber()){
                case 1:
                    player1Won=true;
                    player2Won=false;

                    break;
                case 2:
                    player2Won=true;
                    player1Won=false;
                    break;
                default:
                    break;
            }

        }else if(isSame(playerThrow)&&playerThrow[0]==1){
            System.out.println("Du slog desværre 2 en'ere. Du har nu 0 point\n Du får en ekstra tur");
            player.setPoint(0);
            endgame=false;
            playTurn(player,dice);
        switch (player.getPlayerNumber()){
            case 1:
                player1Won=false;
                player2Won=true;

                break;
            case 2:
                player2Won=false;
                player1Won=true;
                break;
            default:
                break;
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
            System.out.println("Du slog "+playerThrow[0]+" og "+playerThrow[1]);
            if(lastThrow[0]==6&&lastThrow[1]==6&&playerThrow[0]==6&&playerThrow[1]==6){
                System.out.println("Du har slået 2 6'ere i træk og vinder");
                if(player.getPlayerNumber()==1) {player1Won=true; turnOver=true; endgame=true;}
                else if(player.getPlayerNumber()==2) {player2Won=true; turnOver=true; endgame=true;}
            }
            if (isSame(playerThrow) && playerThrow[0] == 1) {
                System.out.println("Du har slået 2 1'ere og mister alle dine point");
                player.setPoint(0);
            }
            else if(isSame(playerThrow)&&playerThrow[0]==6){
                System.out.println("Hvis du slår 2 6'ere igen vinder du");
                player.addPoint(playerThrow[0]+playerThrow[1]);
                printPoints(player);
                lastThrow=playerThrow;
            }
            else if(isSame(playerThrow)){
                player.addPoint(playerThrow[0]+playerThrow[1]);
                System.out.println("Du har slået 2 ens og får en tur mere");
                printPoints(player);
                lastThrow=playerThrow;
            }

            if(!isSame(playerThrow)){
                player.addPoint(playerThrow[0]+playerThrow[1]);
                printPoints(player);
                turnOver=true;

            }

            if(player.getPoint()>=40&&!turnOver) {
                if (player.getPlayerNumber() == 1) {
                    player1Won = true;
                } else player2Won = true;
                turnOver = true;

            }
        }
}

public static void whoWon(Player a, Player b){
        if(player1Won){
            System.out.println("Tillykke til "+a.getName()+". du har vundet");
        }
        if(player2Won){
            System.out.println("Tillykke til "+b.getName()+". du har vundet");
        } if(!player2Won&&!player1Won) System.out.println("Noget gik galt");
}



















}
