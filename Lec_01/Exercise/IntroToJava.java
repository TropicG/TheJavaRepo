import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;

public class IntroToJava {

    public static void main(String[] args) {

        exploreString();
        exploreStringBuilder();
        exploreArrays();
    }


    private static void exploreString() {

        System.out.println("============1: String pool");
        String literalOne = "FMI"; // goes to stringPool
        String literalTwo = "FMI"; // since "FMI" is already in the stringPool, then literalTwo points to the same object as literalOne

        System.out.println(literalOne == literalTwo); // will print true

        String newString = new String("FMI"); // new object allocated into heap
        System.out.println(literalOne == newString); // will return false, since they point to different objects
        System.out.println(literalOne.equals(newString)); // will return true, they are the same content

        String intern = newString.intern(); // newString's string will be added to string pool and the reference is going to be returned
        System.out.println(literalOne == newString); //will return false, since newStrign after .internt needs to have a string assigned to it
        System.out.println(literalOne == intern); //will return true



        System.out.println("==============2 : Splitting and printing string to console");


        int year = 2024;
        String message = "Current year is ";

        //Since strints are immutable so this will create a new string object and some garbage
        message += year; // the other one may be deleted from the garbage collector

        String[] words = message.split(" "); // words = ["Current", "year", "is", "2024"]
        System.out.println(words); // this is not going to print human readable information
        System.out.println(Arrays.toString(words)); // will print "[Current, year, is, 2024]"


        System.out.println("==============3: Indexation and iteration of an array");

        String example = "Example";
        char secondChar = example.charAt(1); // valid way to get a literal from a string, string[1] is not working

        char[] chars = example.toCharArray(); // chars = ['E', 'x', 'a', 'm', 'p', 'l', 'e']

        //2 ways to iterate the array
        for(int i = 0;  i < chars.length; i++){
            System.out.println(chars[i]);
        }

        for(char ch : chars){
            System.out.println(ch);
        }

        System.out.println("=====================4: String conversion");


        String backToStr0 = chars.toString(); // this calls the object method .toString() and is going to assaign to backToStr0 completely different thing
        String backToStr1 = String.valueOf(chars); // this assigns "Example"
        String backToStr2 = Arrays.toString(chars); // this assigns "[E, x, a, m, p, l, e]"


        System.out.println("================= 5: More String operations");

        String lower = "WhatEveR".toLowerCase(); // "whatever"
        String upper = "Whatever".toUpperCase(); // "WHATEVER"

        String reverse = new StringBuilder(lower).reverse().toString();

        // replaces the first argument with the second one
        String replaced = "cut".replace('c', 'p');

        // takes a substring from a string and returns it as a String
        String substring = "Anaconda".substring(2,6); // "acon"

        // checks if the passed string is contained in a string
        boolean containsCo = substring.contains("co"); // yes

        // checks if the String starts with the passed arguments
        boolean StartsWithB = substring.startsWith("b"); // false

        // checks if the String ends with the passed arguments
        boolean endsWithOn = substring.endsWith("on"); // true

        // returns the index of the met string
        int indexOfN = "Coconut".indexOf("n"); // 4
        int length = "Coconut".length();

        System.out.println("=============== 6: Content check over a String ");

        boolean isEmpty = "".isEmpty(); // self-explanatory
        boolean isNotEmpty = " ".isEmpty(); // self-explanatory
        boolean isBlank = "   ".isBlank(); // checks if there are only whitespaces
        boolean equalIgnoringCapitalization = "Java".equalsIgnoreCase("JaVA"); // compares content of strings with ignoring of cases

    }

    public static void exploreStringBuilder() {

        //we only use StringBuilder when we expect the String to be manipulated
        StringBuilder oddNumbers = new StringBuilder();
        for(int i = 0; i < 20; i++){
            if(i % 2 != 0) {
                oddNumbers.append(i).append(" ");
            }
        }

        // or something like this
        StringBuilder word = new StringBuilder("racecar");
        boolean isPalindrome = word.equals(word.reverse());

        //the compiler is smart enough to optimize this and make it to
        //String feelings = new StringBuilder().append("I").append("<3").append("Java");
        String feelings = "I" + "<3" + "Java";
    }

    public static void exploreArrays() {

        int[] array; // this is just the declaration, no memory is allocated
        array = new int[5]; // this is the initialization, now we have array = {0,0,0,0,0}

        String[] stringArray = {"apple", "banana", "cherry"}; // this array is declared and initilized

        char[] charArray = new char[]{'a', 'b'}; // this declaration and initialization is also valid

        int length = stringArray.length; // NOTE: when we are dealing with array length is a data member
        // But when we are dealing with string we use .length()

        long[][] longMatrix = new long[10][10]; // 10x10 matrix is initilized
        double[][] doubleMatrix = new double[10][]; // array with 10 arrays initilized, but no elements inside
        for(int i = 0; i < doubleMatrix.length; i++){
            doubleMatrix[i] = new double[20]; // now every array has capacity of 20 elements
        }

        int[] intArray = {1,6,7,3};
        Arrays.sort(intArray); // this method is used to sort a collection
        String[] animals = {"cats", "dog", "bird"};
        Arrays.sort(animals, Collections.reverseOrder()); // to this method for sorting we can also add how to sort

        // Searches for the second argument in the array passed as first argument with binary search
        int index = Arrays.binarySearch(intArray, 7);

        //Copies the array given as an argument and returns an array with the same content
        int[] copy = Arrays.copyOf(intArray, intArray.length);
        boolean areEqual = Arrays.equals(intArray, copy);  // compares the contens of the two arrays

        //the output is going to be "[elem1,elem2,elem3,elem4, ..., elemn]"
        System.out.println(Arrays.toString(copy));

        //To compare two (or more) dimensional arrays of objects we use .deepEquals()
        char[][] currentBoard = {{'X', 'O', 'X'}, {'X', 'O', 'O'}, {'X', 'X', 'O'}};
        char[][] winBoard = {{'X', 'O', 'X'}, {'X', 'O', 'O'}, {'X', 'X', 'O'}};
        boolean isWining = Arrays.deepEquals(currentBoard, winBoard);
    }

}
