public class NamesSorter {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peter", "Anastasia", "Mike");
        Collections.sort(names, new Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(names);
    }
}