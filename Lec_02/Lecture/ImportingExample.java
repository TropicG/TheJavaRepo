package com.myexample.ImportingExample;

//importing class ArrayList since we are going to use them
import java.util.ArrayList;

public class ImportingExample {
    public static void main(String[] args) {
        
        ArrayList<String> names = new ArrayList<>();

        //if we didnt imported ArrayList we would have used this line of code
        //ArrayList<String> names = new java.util.ArrayList<>();

        names.add("Someone");
    }
}