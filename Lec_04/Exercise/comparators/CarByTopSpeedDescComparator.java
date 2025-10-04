package comparators;

import java.util.Comparator;

public class CarByTopSpeedDescComparator implements Comparator<Car> {

    @Override
    public int compare(Car first, Car second) {
        return Integer.compare(second.getTopSpeed(), first.getTopSpeed());
    }
}
