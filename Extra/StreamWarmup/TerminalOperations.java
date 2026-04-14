// Demonstrate all key terminal operations: forEach, count, sum, min, max, findFirst, anyMatch, allMatch, noneMatch, and reduce.

import java.util.Arrays;
import java.util.List;

public class TerminalOperations {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 7, 2, 9, 1, 5, 8, 3, 6);

        // Remember, Terminal operations trigger the entire pipeline -> without them, nothing runs

        // forEach -> terminal operations passes by all the elements in the stream
        System.out.println("for each: ");
        nums.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // count -> terminal operation passess by all the elements and sums them
        System.out.println("coutn: " + nums.stream().count());

        // sum -> sums all the elemnts in the stream
        // Elements in the list are of Integer type, not int, that is why we need to map first in order to call sum
        System.out.println("sum: " + nums.stream().mapToInt(Integer::intValue).sum());

        // Remember, min(), max(), average() and other methods returns Optional
        // always check with isPresnet() or orElse() !!!!

        // min -> gets the min element in the stream
        System.out.println("min: " + nums.stream().mapToInt(Integer::intValue).min().orElse(0));

        // max -> gets the max element in the stream
        System.out.println("max: " + nums.stream().mapToInt(Integer::intValue).max().orElse(0));

        // average -> returns the avarage sum of the elements in the stream
        System.out.println("average: " + nums.stream().mapToInt(Integer::intValue).average().orElse(0));

        // anyMatch -> returns boolean if any of the elements in the stream match the given predicate
        System.out.println("anyMathc: " + nums.stream().anyMatch(n -> n < 8));

        // allMatch -> returns boolean if all of the elements in the stream match the given predicate
        System.out.println("allMatch: " + nums.stream().allMatch(n -> n > 0));

        // noneMatch -> returns boolean if all of the elements do not match the given predicate
        System.out.println("noneMatch: " + nums.stream().noneMatch(n -> n > 100));

        // findFirst -> returns the first element in the stream
        System.out.println("findFirst > 5: " + nums.stream().filter(n -> n > 5).findFirst().orElse(0));

        // reduce -> combine all elements into one value
        int product = nums.stream().reduce(1, (a, b) -> a * b);
        System.out.println("reduce (*): " + product);

        String joined = List.of("Java","is","great").stream()
                .reduce("", (a, b) -> a.isEmpty() ? b : a + " " + b);
        System.out.println("reduce (+) : " + joined);
    }
}
