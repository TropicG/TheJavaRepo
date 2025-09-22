import java.sql.SQLOutput;
import java.util.Arrays;

public class SwitchExample {

    public static void main(String[] args) {

        String foodForToday = "RAMEN";
        System.out.println(oldSwitchFoodGrader(foodForToday));
        System.out.println(jave15FoodGrader(foodForToday));
        System.out.println(switchPatternMatchingStringConvert("Hello"));
    }

    private static String oldSwitchFoodGrader(String food) {

        String grade;
        switch(food) {
            case "PIZZA":
                grade = "NICE!";
                break;
            case "RAMEN":
                grade = "OOH FANCY!";
                break;
            default:
                grade = "IF YOU REALL WANT TO...";
                break;
        }

        return grade;
    }

    private static String jave15FoodGrader(String food) {

        //switch can be used to assign a value to a variable
        //depending on different outcomes
        String grade = switch(food) {
            case "PIZA" -> "NICE";
            case "RAMEN" -> "OOOOH OKAY!";
            default -> "IF YOU REALLY WANT TO...";
        };

        return grade;
    }

    private static String switchPatternMatchingStringConvert(Object inputObject){

        //depending the value of InputObject the switch statement creates a local variable
        //to perform its operation
        //Notes: This works only for references types a.k.a object
        return switch(inputObject) {
            case char[] charArray -> Arrays.toString(charArray);
            case Integer i -> "" + i;
            case String s -> "Are you really converting string to a string";
            case null -> "Null reference";
            default -> "It is none of the know data types";
        };
    }
}
