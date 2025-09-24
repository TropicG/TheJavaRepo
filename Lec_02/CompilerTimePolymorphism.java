class Calculator {
    public add(int a, int b) {
        return a + b;
    }

    public add(int a, int b, int c) {
        return a + b + c; 
    }
}

class Main{

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        //here the compiler knows which method to invoke during compilation time
        System.out.println(calc.add(1,2));

        //here again the compiler static binds the proper method for invocation
        System.out.println(calc.add(1,2,3));

    }

}