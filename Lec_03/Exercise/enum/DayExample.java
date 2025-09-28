

class DaysExample {
    
    private Day day;

    public DaysExample(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        String message = switch(day) {
            case MONDAY -> "Mondays are bad";
            case FRIDAY -> "Fridays are better.";
            case SATURDAY, SUNDAY -> "Weekends are best.";
            default -> "Midweek days are so-so";
        };
        
        System.out.println(message);
    }


    public static void main(String... args) {

        DaysExample example = new DaysExample(Day.TUESDAY);
        example.tellItLikeItIs();

        // the values() method is a special method added by the compiler
        Day[] days = Days.values();
        System.out.println(Arrays.toString(days)) //  [SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY]

        // The name must match exactly the identifier used to declare the enum constant in this type
        System.out.println(Day.valueOf("Monday")); // MONDAY
        System.out.println(Day.MONDAY.getAbbrevation());  // Mon.
    }
}