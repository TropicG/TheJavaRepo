class Shape(){
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override 
    void draw(){
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override 
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class InstanceofExample {

    public static void main(String.. args) {

        Shape[] shapes = new Shape[] {
            new Circle(),
            new Rectangle(),
            new Circle(),
            new Rectangle()
        };

        // this was the old school-way
        for(Shape shape : shapes) {

            if(shape instanceof Circle) {
                System.out.println("Circle detected");
                Circle cirle = (Circle) shape;
                circle.draw();
            }
            else if(shape instanceof Rectangle){
                System.out.println("Rectangle detected");
                Rectangle rectangle = (Rectangle) shape;
                rectangle.draw();
            }
            else {
                System.out.println("Unknown shape detected.");
                shape.draw();
            }
        }
    }
}