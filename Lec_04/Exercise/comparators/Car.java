package comparators;

import java.lang.String;
import java.util.Objects;

public class Car implements Comparable<Car> {

    private String vin;
    private int topSpeed;
    private String color;
    private String brand;

    public Car(String vin, int topSpeed, String color, String brand) {
        this.vin = vin;
        this.topSpeed = topSpeed;
        this.color = color;
        this.brand = brand;
    }

    public int getTopSpeed() {
        return this.topSpeed;
    }

    public String getColor() {
        return this.color;
    }

    public String getBrand() {
        return this.brand;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;

        Car car = (Car) o;
        return Objects.equals(this.vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.vin);
    }

    @Override
    public int compareTo(Car other) {
        // This methods returns a 0 when poth the ids are equal, -1 when they have the same topSpeed
        // and 1 when this.topSpeed is higher

        // Remember this method needs to be consistent with equals

        if(this.vin.equals(other.vin)) {
            return 0;
        }
        else if(this.topSpeed == other.topSpeed) {
            return 0;
        }

        //returns 1 if this.topSpeed is higher
        return Integer.compare(this.topSpeed, other.topSpeed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", topSpeed=" + topSpeed +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}