public class BankAccount {

    private int balance = 100;

    public int transfer(int amount) {
        balance += amount;
        return balance;
    }
}