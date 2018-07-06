package OrderingImitation.Process;

import OrderingImitation.Item;
import OrderingImitation.Order;

public class CustomerImitation
{
    public static void main(String[] args)
    {
        Item item1 = new Item("Big Mac");
        Item item2 = new Item("Big Tasty");
        Item item3 = new Item("Fries");
        Item item4 = new Item("Coca Cola");
        Order order = new Order(item1, item2, item3);
        order.addItem(item4);
        order.addItem(new Item("Mac Chicken"));
        order.showItems();
    }
}
