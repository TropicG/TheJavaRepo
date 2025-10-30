// one parameter
(String name) -> System.out.println("Hello + " name );

// type inference 
(name) -> System.out.println("Hello + " + name); // here Java knows that name is String

// omit ()
name -> System.out.println("Hello + " + name); // Since we have only parameter we can skip the () brackets


// three parameters, in an explicit form
(int a, int b, int c) -> a + b + c;

// type inference
(a,b,c) -> a + b + c; // Java knows that a b c are ins

// empty body
{} -> {} // doesnt accept any parameters and doesnt do anything

// omit {} and the return as tehre is single expression in the body
(a,b) -> a + b // dont forget, the compiler automatically adds return

// muktiple expressions in the body
(a, b) -> {a = 5; b = 2; return a + b;} // since there are more than 1 statemetns we are required to use {}
// dont forget since we use return we must have {} as well

// body on multiple liens
(a, b) -> {
    a = 5;
    b = 2;
    return a + b;
}
