//Enums extends the java.lang.Enums class implicitly, therefore you cannot extend any other class in enum
//since one class can extend only one class
public enum Day {

    SUNDAY("Sun"), MONDAY("Mon."), TUESDAY("Tu."), WEDNESDAY("Wed."), THURSDAY("Th."), FRIDAY("Fr."), SATURDAY("Sat.");

    private final String abbreviation;

    // Constructor is always private or default, you cannot createa an instance of enum using the new operator
    // otherwise it wont compail
    Day(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }


}