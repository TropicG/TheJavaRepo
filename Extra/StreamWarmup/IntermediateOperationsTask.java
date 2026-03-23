// Demonstrate all key intermediate operations: filter, map, flatMap, distinct, sorted, peek, limit, and skip.

import java.util.Comparator;
import java.util.List;

public class IntermediateOperationsTask {

    public static void main(String[] args) {

        List<Integer> nums = List.of(5, 3, 8, 1, 9, 2, 3, 7, 5, 1);

        // filter - keep elements matching predicate
        System.out.print("filter > 4: ");
        nums.stream().filter(n -> n > 4).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // map - transforms each element
        System.out.print("map *2 :");
        nums.stream().map(n ->  n*2).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // distinct - remove duplicates
        System.out.print("distinct: ");
        nums.stream().distinct().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // sorted - natural order
        System.out.print("sorted: ");
        nums.stream().distinct().sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // sorted - reverse order
        System.out.print("sorted reverse: ");
        nums.stream().distinct().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));

    }

}
