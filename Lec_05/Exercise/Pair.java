public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return this.key;
    }

    public void setVale(V value) {
        this.value = value;
    }

    public V getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(2, "Two");

        Pair<String, Integer> pair3 = new Pair<>("String", 3);

        System.out.println(pair1);
        System.out.println(pair2);

        System.out.println(Util.areEqual(pair1,pair2));
       // System.out.println(Util.areEqual(pair1,pair3)); this wont compile
    }
}

class Util {
    public static <K,V> boolean areEqual(Pair<K, V> pair1, Pair<K,V> pair2) {
        return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
    }
}