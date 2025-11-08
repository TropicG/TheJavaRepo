static void incrementOpCount() {

    //here we cannot used this as a monitor, since we have a static method meaning we need to use something that is found in every instance of this class
    //BankAccount.class does to job for us
    synchronized(BankAccount.class) {
        opCount++;
    }
}

// the whole method is syncrhonised, JVM adds the lock synchronized(BankAccount.class) 
static synchronized void incrementOpCount() {
    opCount++;
}