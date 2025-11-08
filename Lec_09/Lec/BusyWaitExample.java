public void withdrawCreditPayment(double monthFee) {
    while (this.balance < monthFee) {
        // it stays in the cycle, until we have money 
        Thread.sleep(1_000);
    }
    balance -= monthFee;
}