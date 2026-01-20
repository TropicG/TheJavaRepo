package behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    // the broker will hold data to all the classes that implemented order and have a stock data with them
    private final List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    // all of the orders will be executed here
    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
