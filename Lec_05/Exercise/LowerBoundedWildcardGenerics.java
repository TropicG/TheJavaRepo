interface Shape {
    double area();
}

class Rectangle implements Shape, Comparable<Shape>{

    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return this.width * this.length;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.area(), other.area());
    }

    @Override
    public String toString() {
        return "Rectangle[Area=" + area() + "]";
    }
}

class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public String toString() {
        return "Square[Area=" + area() + "]";
    }
}

class ShapeUtils {


    //this method accepts type of T which extends Shape (the basest class) and has implemented Comparable with a type
    // that is a parent of T
    public static <T extends Shape & Comparable<? super T>> T findLargestShape(T[] shapes) {
        T largest = shapes[0];

        for(T shape : shapes) {
            if(shape.compareTo(largest) > 0) {
                largest = shape;
            }
        }

        return largest;
    }

    //here coding to an interface is achieved and it is very flexible
    //If above we have implemented Rectangle with Comparable<Rectangle> it would have accepted only Rectangles
    //buutt Square is a rectangle as well
}

public class LowerBoundedWildcardGenerics {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4, 5);
        Rectangle rect2 = new Rectangle(2, 3);
        Square square1 = new Square(3);
        Square square2 = new Square(4);

        Shape[] shapes = {rect1, rect2, square1, square2};
        Rectangle[] rectangles = {rect1, rect2, square1, square2};
        Square[] squares = {square1, square2};

        // Find the largest shape
        //Shape largestShape = ShapeUtils.findLargestShape(shapes); // Won't compile: not every shape is comparable
        Shape largestRectangle = ShapeUtils.findLargestShape(rectangles);
        Shape largestSquare = ShapeUtils.findLargestShape(squares);

        System.out.println(largestRectangle);
        System.out.println(largestSquare);
    }
}
