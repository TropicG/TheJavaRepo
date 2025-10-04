
import comparators.Car;
import comparators.CarByNameComparator;
import comparators.CarByTopSpeedDescComparator;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String... args) {

        //creating the cars
        Car ferrari = new Car("JKJ123", 200, "red", "Ferrari");
        Car mercedes = new Car("R1-HX", 250, "black", "Mercedes");
        Car bwm = new Car("XN-Z1", 300, "black", "BWM");
        Car audi = new Car("XD-11", 220, "white", "Audi");

        //adding the cars into the arrayList
        List<Car> carList = new ArrayList<>();

        carList.add(ferrari);
        carList.add(mercedes);
        carList.add(bwm);
        carList.add(audi);

        //sorting by topSpeed, this is the natural order defined from compareTo from Car class
        System.out.println("Sorting by topSpeed");
        Collections.sort(carList);
        for(Car car : carList) {
            System.out.println(car);
        }

        //sorting using the already created comparator
        System.out.println("Sorting by brandName");
        Collections.sort(carList, new CarByNameComparator());
        Iterator<Car> iteratorBrandName = carList.iterator();
        while(iteratorBrandName.hasNext()) {
            System.out.println(iteratorBrandName.next());
        }

        //sorting using the already created comparator
        System.out.println("Sorting by topSpeed in descending order");
        Collections.sort(carList, new CarByTopSpeedDescComparator());
        Iterator<Car> iteratorTopSpeedDesc = carList.iterator();
        while(iteratorTopSpeedDesc.hasNext()) {
            System.out.println(iteratorTopSpeedDesc.next());
        }

        //creating a map and adding everything to it
        Map<Car, Integer> carMap = new HashMap<>();

        carMap.put(ferrari, 120);
        carMap.put(mercedes, 250);
        carMap.put(bwm, 300);
        carMap.put(audi, 100);

        //printing all the Enties inside the Map
        System.out.println("Printing all the cars inside HashMap");
        for(Map.Entry<Car, Integer> entry : carMap.entrySet()) {
            System.out.println(entry.getKey() + " and value of " + entry.getValue());
        }

        // craeting a TreeMap and the entries are going to be sorted based on natural order
        Map<Car, Integer> carSortedMap = new TreeMap<>();
        carSortedMap.putAll(carMap);
        System.out.println("Pringn the entries in the TreeMap");
        for(Map.Entry<Car, Integer> entry : carSortedMap.entrySet()) {
            System.out.println(entry.getKey() + " and value of " + entry.getValue());
        }

        // creating a TreeMap and the entries are going to be sorted based on the given comparator
        Map<Car, Integer> carMapSortedByName = new TreeMap<>(new CarByNameComparator());
        carMapSortedByName.putAll(carMap);
        System.out.println("Pringn the entries in the TreeMap sorting based on name");
        for(Map.Entry<Car, Integer> entry : carMapSortedByName.entrySet()) {
            System.out.println(entry.getKey() + " and value of " + entry.getValue());
        }
    }
}
