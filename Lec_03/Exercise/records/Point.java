public record Point(int x, int y) {}

public class PointDemo {

    public static void main(String... args) {
        Point p = new Point{-1, 2};

        //the getter methods here have the same name as the fields
        System.out.println(p.x() + ", " + p.y());
    }
}