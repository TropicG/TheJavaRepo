public void depositMoney(BankAcoount acc, double amount) {

    // this is the critical section, only one thread for bank acount can execute the code in the synchronized section
    synchronized(acc) { // here for monitor is used the object acc 
        acc.deposit(amount);
    }
}