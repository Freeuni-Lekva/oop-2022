package shared;

@Author(
        name = "Free",
        email = "uni@edu.ge"
)
public class Point {
    @Author(name = "asd", email = "qwe")
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Author(name = "qwe", email = "asdasd")
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y));
    }

    // public double distance(double ox, double oy) {
//        return Math.sqrt((x - ox) * (x - ox) + (y - oy) * (y - oy));
//    }
}
