//this class declares which classes are going to be his children
public abstract sealed class Shape permits Circle, Rectangle, Parallelogram, WeirdShape {...} 

// this is okay
public final clas Circle extends Shape {...}
public final class Parallelogram extends Shape {...}

//this is okay 
public sealed class Rectangle exnteds Shape permits Square {...}
public final class Shape exnteds Rectangle {...}

//this is okay
public non-sealed class WeirdShape exnteds Shape {...}


//this is not okay
public class Triangle exnteds Shape {...}