public class Classtester {
    public static void  main(String[]args){
        Dice dice = new Dice();
        int[] slag = dice.getDice();
        System.out.println(slag[0]+" "+slag[1]);
    }
}
