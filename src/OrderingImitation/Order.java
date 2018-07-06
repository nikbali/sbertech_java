package OrderingImitation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order
{
    private List<Item> items = new ArrayList<>();

    public Order(Item... items)
    {
        this.items.addAll(Arrays.asList(items));
    }

    public Order()
    {}

    public boolean addItem(Item item)
    {
        if(item == null) return false;
        items.add(item);
        return true;
    }

    public void showItems()
    {
        for (Item i: items)
        {
            System.out.println(i.getName());
        }
    }
}
