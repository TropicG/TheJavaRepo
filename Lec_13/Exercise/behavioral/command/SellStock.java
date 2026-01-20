package behavioral.command;

public class SellStock implements Order {
    // each different command will hold reference to the object it has to execute the command on
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
