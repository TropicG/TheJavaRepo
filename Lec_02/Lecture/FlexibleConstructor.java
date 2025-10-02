public class Range{

    private final int start;
    private final int end;

    public Range(int start, int end){


        //we perform check based on the passed argumetns to decide what are we going to do
        if(start > end) {
            throw new IllegalArgumentException();
        }

        //assigning to data members
        this.start = start;

        super();

        this.end = end;
    }
}