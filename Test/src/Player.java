public class Player {
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    public void addPoint(int point) {
        this.point += point;
    }
    private int point;

    public String getName() {
        return name;
    }

    private String name;

    public Player(String name){
        this.name=name;
        this.point=0;
    }
}

