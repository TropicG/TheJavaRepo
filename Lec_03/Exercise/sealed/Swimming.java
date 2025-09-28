sealed class Swimming implements Exercise {

    private static final int SWIMMING_CALORIES = 650;

    @Override
    public int getCaloriesBurnt() {
            return SWIMMING_CALORIES;
    }
}

// Any subclass that is found in the same source file with a sealed class doesnt need to be mentioned in the
// pertmis clause of their parent
final class OceanSwimming extends Swimming {

    private static final int OCEAN_SWIMMING_CALORIES = 700;

    @Override
    public int getCaloriesBurnt() {
        return OCEAN_SWIMMING_CALORIES;
    }
}