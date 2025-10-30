// a very traditional way before Java 8, we should create a whole anonymous class and have to override the method compare
Collections.sort(names, new Comparator<String> {
    @Override
    public int compare(String a, String b){
        return Integer.compare(a.length(), b.length());
    }
})

// a variant of a lambda function, the parameters passes are String a and String b and we type the body of the function after -> 
// -> is just a divider for the lambda function
Collections.sort(names, (String a, String b) -> {
    return Integer.compare(a.length(), b.length());
})

// even shorter variant of a lambda funciton, if the body of the lambda function consists only of 1 line we can skip the {} brackets and return value
Collections.sort(names, (String a, String b) -> Integer.compare(a.length(), b.length()));

// even shorter variant since the compiler here uses type inference, meaning the compiler automatically defines the type of the given arg without us defining it
// 
Collections.sort(names, (a,b) -> Integer.compare(a.length(), b.length()));