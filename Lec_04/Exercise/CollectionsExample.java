
import comparators.Car;

import java.sql.SQLOutput;
import java.util.*;

public class CollectionsExample {

    private static void exploreCollections() {

        // creating an arrayList and adding its members
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(20);
        arrayList.add(5);
        arrayList.add(-20);
        arrayList.add(91);
        arrayList.add(0);
        System.out.println(arrayList); // [20, 5, -20, 91, 0]

        //sorting and outputing to console
        Collections.sort(arrayList);
        System.out.println(arrayList); // [-20, 0, 5, 20, 91]

        //sorting with reverse order and outputing
        Collections.sort(arrayList, Collections.reverseOrder());
        System.out.println(arrayList); // [91, 20, 5, 0, -20]

        //showing index of element before and after using binary search
        System.out.println(arrayList.indexOf(20)); // 1
        Collections.sort(arrayList);
        System.out.println(arrayList); // [-20, 0, 5, 20, 91]
        System.out.println(Collections.binarySearch(arrayList, 20)); // 3

        // shuffling a collection
        Collections.shuffle(arrayList);
        System.out.println(arrayList); // random shuffle everytime

        // creating ArrayList and LinkedList
        List<String> from = new ArrayList<>();
        from.add("foo");
        from.add("boo");
        List<String> to = new LinkedList<>();
        to.add("brum");
        to.add("viiiii");
        to.add("hamster");

        //copying the information from the one into the another
        Collections.copy(to, from);
        System.out.println(to); // [foo, boo, hamster]
        System.out.println(from); // [foo, boo]

        //all of the elements inside to will be "a"
        Collections.fill(to, "a");
        System.out.println(to); // [a, a, a]

        //creating new arrayList
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(-2);
        list.add(22);

        //reversing the list and after that swapping their elements
        Collections.reverse(list);
        System.out.println(list); // [22, -2, 10]
        Collections.swap(list, 0,1);
        System.out.println(list); // [-2, 22, 10]

        // creating a List using .of and using Collcetions.max, Collections.min and Collections.frequency
        List<Integer> listInteger = List.of(1,2, -40, 1, 10, 22);
        System.out.println(Collections.min(listInteger)); // -40
        System.out.println(Collections.max(listInteger)); // 22
        System.out.println(Collections.frequency(listInteger,2)); // 1

        //exercising static .of methods of interfaces
        List<Integer> listOf = List.of(32,1,3,1,2);
        Set<Integer> setOf = Set.of(1,2,3,4);

        // with this static method we can only insert up to ten entries
        Map<Integer, String> mapof = Map.of(
                123, "Car",
                324, "Bycicle"
        );

        // with this static method we can insert unlimited number of times
        Map<Integer, String> mapOfEntries = Map.ofEntries(
                Map.entry(123, "Car"),
                Map.entry(413, "F")
        );

        // Since Java 19, static factory methods for creating hash-based collections
        Set<String> setString = HashSet.newHashSet(10);
    }

    //find the distinct words
    private static void findDistinctWords(String[] words) {
        Set<String> stringSet = new HashSet<>();

        for(String word : words) {
            stringSet.add(word);
        }

        System.out.println(stringSet);
    }

    // removing words that are equal to filterWord
    private static void filterWords(Collection<String> words, String filterWord) {
        Iterator<String> iterator = words.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().contains(filterWord)) {
                iterator.remove();
            }
        }
    }

    private static Map<String, List<Car>> carsByBrandNames(Collection<Car> cars) {
        Map<String, List<Car>> carsByBrandName = new HashMap<>();

        for(Car car : cars) {
            String brand = car.getBrand();

            //this guarantees that every brand name will be inserted before calling .get
            carsByBrandName.putIfAbsent(brand, new ArrayList<>());
            carsByBrandName.get(brand).add(car);
        }

        return carsByBrandName;
    }

    public static void main(String... args) {
        exploreCollections();
        findDistinctWords(new String[] {"car", "cat", "dog", "cat", "dog"}); // 3 distinct words: [car, cat, dog]
        List<String> words = new ArrayList<>(Arrays.asList("car", "cat", "dog"));
        String fillerWord = "car";
        filterWords(words, fillerWord);
        System.out.println(words); // [dog]

        //creating the cars
        Car ferrari = new Car("JKJ123", 200, "red", "Ferrari");
        Car mercedes = new Car("R1-HX", 250, "black", "Mercedes");
        Car bwm = new Car("XN-Z1", 300, "black", "BWM");
        Car audi = new Car("XD-11", 220, "white", "Audi");

        var carsByBrand = carsByBrandNames(List.of(ferrari, mercedes, bwm, audi));

        for (String brand : carsByBrand.keySet()) {
            System.out.println(brand + "--> " + carsByBrand.get(brand));
        }

    }
}
