public void method1() {
    synchronized(this){
        method2();
    }
}

public synchronized void method2() {
    //...
}