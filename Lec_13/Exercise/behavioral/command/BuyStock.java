package behavioral.command;

public class BuyStock implements Order {
    // each different command will hold reference to the object it has to execute the command on
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
