interface Adorable extends Loveable, Likeable {
    // this interface inherits both like() and love() methods and does not declare any new methods
    // any class that will implement it is required to implement both like() and love() methods or decleare itself as abstract
}