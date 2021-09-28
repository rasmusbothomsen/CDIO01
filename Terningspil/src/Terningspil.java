import java.util.Scanner;



public class Terningspil {
private static boolean is40;
private static boolean endOfGame;
private static Scanner scan =new Scanner(System.in);

    public static void main(String[] args) {
        is40=false;
        startgame();
        System.out.print("Spiller 1 indtast dit navn: ");
        String player1Name = scan.nextLine();
        Player player1 = new Player(player1Name);
        System.out.print("Spiller 2 indtast dit navn: ");
        String player2Name = scan.nextLine();
        Player player2 = new Player(player2Name);
        Dice dice = new Dice();

        while (!endOfGame) {
            playTurn(player1, dice);
            playTurn(player2,dice);
        }
    }

    private static void startgame() {
        System.out.println("Velkommen til terningespillet");

    }

    private static void rules() {
        System.out.println("\nMan vinder ved at opnå 40 point og efterfølgende slå to ens");
        System.out.println("Når man slår to ens får vedkommende en ekstra tur");
        System.out.println("Ved slag af to 1'ere mister vedkommende alle deres point - dog gælder ovenstående stadig");
        System.out.println("Det er også muligt at vinde ved at slå to 6'ere lige efter hinanden");
        System.out.println("Hvis man slår to 1'ere efter man har rundet de 40 point starter man forfra\n");
    }

    public static void playTurn(Player a, Dice dice) {
        int[] slag;
        int[] lastThrow = {0, 0};
        boolean isPlayerTurn = true;
        while (isPlayerTurn) {
            System.out.println("Det er " + a.getName() + " tur" + "\n" + "Tryk for at kaste");
            slag = dice.getDice();
            System.out.println("Du slog " + slag[0] + " og " + slag[1]);
            if (isSame(slag) && slag[0] == 1) {
                System.out.println("Ærgeligt du slog 2 1'ere, du mister alle dine point");
                a.setPoint(0);
            } else if (isSame(slag)) {
                System.out.println("Tillykke 2 ens, du får en ekstra tur");
                a.addPoint(slag[0] + slag[1]);
                lastThrow = slag;
            } else if (isSame(slag) && slag[0] == 6 && lastThrow[0] == 6 && lastThrow[1] == 6) {
                endOfGame = true;
            } else {
                a.addPoint(slag[0] + slag[1]);
                isPlayerTurn = false;
            }
            System.out.println("Spiller " + a.getName() + " har " + a.getPoint() + " points" + "\n");
            is40(a);
        }
    }
    public static boolean isSame(int[] a) {
        return a[0] == a[1];
    }



    private static void is40(Player a) {
        if (a.getPoint() < 40) is40=false;
        else is40=true;
    }






}
