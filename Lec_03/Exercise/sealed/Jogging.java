//specifically this class can be inherited by a non-limited number of classes
public non-sealed class Jogging implements Exercise {

    private static final int JOGGING_CALORIES = 450;

    @Override
    public int getCaloriesBurnt() {
        return JOGGING_CALORIES;
    }

}