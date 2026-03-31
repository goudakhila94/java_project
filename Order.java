package review_1;
import java.util.*;

public class Order
{
    int orderId;
    String customerName;
    ArrayList<Item> items;
    Order next;

    Order(int id, String name, ArrayList<Item> items)
    {
        this.orderId = id;
        this.customerName = name;
        this.items = items;
        this.next = null;
    }
}
