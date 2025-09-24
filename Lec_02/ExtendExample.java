public class Shape {

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


public class Circle extends Shape {

    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void getArea() {
        return Math.PI * this.radius * this.radius;
    }


}