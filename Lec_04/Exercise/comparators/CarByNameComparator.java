package comparators;

import java.util.Comparator;

public class CarByNameComparator implements Comparator<Car> {

    @Override
    public int compare(Car first, Car second) {
        return first.getBrand().compareTo(second.getBrand());
    }

}
