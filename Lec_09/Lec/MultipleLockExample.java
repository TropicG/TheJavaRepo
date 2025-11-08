public void multipleLocks() {

    synchronized(Lock1) {

        synchronized(Lock2) {

            synchronized(Lock3) {

            }
        }
    }
}