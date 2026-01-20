package creational.factory;

import creational.builder.ShapeType;

public interface Shape {
    void draw();

    default Shape of(ShapeType shapeType) {
        return switch(shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
        };
    }
}
