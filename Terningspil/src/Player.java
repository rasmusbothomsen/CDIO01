
    public class Player {
        private String name;
        private int point;

        public int getPlayerNumber() {
            return playerNumber;
        }

        private int playerNumber;



        public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    public void addPoint(int point) {
        this.point += point;
    }

    public String getName() {
        return name;
    }


    public Player(String name,int playerNumber){
        this.name=name;
        this.playerNumber=playerNumber;
        this.point=0;
    }
}



