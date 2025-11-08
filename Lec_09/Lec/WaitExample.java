public synchronized void withdrawCreditPayment(double monthFee) {
    while(this.balance < monthFee) {

        try {
            this.wait();
        } catch (InterruptedException e) {

        }

        balance -= monthFee;
    }
}