	package review_1;
	import java.util.*;
	import java.io.*;

	class FoodDeliverySystem_
	{
	    Order head = null;

	    String[] menuItems = {
	         "Pizza","Burger","Biryani","Pasta","Fried Rice",
	         "Noodles","Sandwich","French Fries","Chicken Wings","Sushi",
	         "Butter Chicken","Dosa","Idli"
	     };

	     int[] prices = {
	         250,120,200,180,
	         140,220,300,250,
	         180,240,150,200,
	         50
	     };

	    Restaurant[] restaurants = {
	        new Restaurant("Domino's",4.5),
	        new Restaurant("McDonald's",4.0),
	        new Restaurant("Biryani House",4.8),
	        new Restaurant("Pizza Hut",4.2)
	    };

	    Scanner sc = new Scanner(System.in);

	    Stack<Order> undoStack = new Stack<>();
	    Queue<Order> preparationQueue = new LinkedList<>();
	    Queue<Order> deliveryQueue = new LinkedList<>();

	    void placeOrder()
	    {
	        System.out.print("Enter Order ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Customer Name: ");
	        String name = sc.nextLine();

	        ArrayList<Item> cart = new ArrayList<>();

	        char more = 'y';

	        do
	        {
	            showMenu();

	            System.out.print("Select item number: ");
	            int choice = sc.nextInt() - 1;

	            if(choice < 0 || choice >= menuItems.length)
	            {
	                System.out.println("Invalid item!");
	                continue;
	            }

	            System.out.print("Enter quantity: ");
	            int qty = sc.nextInt();
	            sc.nextLine();

	            cart.add(new Item(menuItems[choice], prices[choice], qty));

	            System.out.print("Add another item? (y/n): ");
	            more = sc.next().toLowerCase().charAt(0);

	        } while(more == 'y');

	        Order newOrder = new Order(id,name,cart);

	        if(head == null) head = newOrder;
	        else
	        {
	            Order temp = head;
	            while(temp.next != null) temp = temp.next;
	            temp.next = newOrder;
	        }

	        preparationQueue.add(newOrder);

	        int total = calculateTotal(newOrder);

	        System.out.println("\n🎉 ORDER SUCCESSFULLY PLACED!");
	        System.out.println("💰 Total Amount: " + total);

	        printBill(newOrder);

	        saveOrderToFile(newOrder);
	    }

	    int calculateTotal(Order order)
	    {
	        int total = 0;
	        for(Item i : order.items)
	            total += i.price * i.quantity;
	        return total;
	    }

	    void printBill(Order order)
	    {
	        int total = 0;

	        System.out.println("\n------ BILL ------");
	        System.out.println("Customer: " + order.customerName);

	        for(Item i : order.items)
	        {
	            int cost = i.price * i.quantity;
	            total += cost;
	            System.out.println(i.name + " x " + i.quantity + " = " + cost);
	        }

	        System.out.println("------------------");
	        System.out.println("TOTAL: " + total);
	        System.out.println("✅ Thank you! Visit again");
	    }

	    void saveOrderToFile(Order order)
	    {
	        try
	        {
	            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\order.txt", true));

	            int total = 0;
	            String itemsData = "";

	            for(Item i : order.items)
	            {
	                int cost = i.price * i.quantity;
	                total += cost;

	                itemsData += i.name + "(" + i.quantity + ")-" + cost + "|";
	            }

	            String dateTime = java.time.LocalDateTime.now().toString();
	            String payment = "PAID";

	            bw.write(order.orderId + "," + order.customerName + "," + itemsData +
	                    "TOTAL=" + total + "," + dateTime + "," + payment);

	            bw.newLine();
	            bw.close();
	        }
	        catch(Exception e)
	        {
	            System.out.println("File Error!");
	        }
	    }

	    void showOrderHistory()
	    {
	        try
	        {
	            BufferedReader br = new BufferedReader(new FileReader("D:\\order.txt"));
	            String line;

	            System.out.println("\n📂 ORDER HISTORY:");

	            while((line = br.readLine()) != null)
	            {
	                System.out.println(line);
	            }

	            br.close();
	        }
	        catch(Exception e)
	        {
	            System.out.println("No Order History Found");
	        }
	    }

	    void showOrders()
	    {
	        Order temp = head;
	        while(temp != null)
	        {
	            System.out.println("Order ID: " + temp.orderId + " Customer: " + temp.customerName);
	            for(Item i : temp.items)
	                System.out.println("  " + i.name + " x " + i.quantity);
	            temp = temp.next;
	        }
	    }

	    void searchOrder()
	    {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();

	        Order temp = head;
	        while(temp != null)
	        {
	            if(temp.orderId == id)
	            {
	                printBill(temp);
	                return;
	            }
	            temp = temp.next;
	        }
	        System.out.println("Not Found");
	    }

	    void removeOrderFromCart()
	    {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();

	        Order temp = head, prev = null;

	        while(temp != null)
	        {
	            if(temp.orderId == id)
	            {
	                undoStack.push(temp);

	                if(prev == null) head = temp.next;
	                else prev.next = temp.next;

	                System.out.println("Order Removed");
	                return;
	            }

	            prev = temp;
	            temp = temp.next;
	        }

	        System.out.println("Order Not Found");
	    }

	    void undoRemove()
	    {
	        if(undoStack.isEmpty())
	        {
	            System.out.println("Nothing to undo");
	            return;
	        }

	        Order o = undoStack.pop();
	        o.next = head;
	        head = o;

	        System.out.println("Undo Successful");
	    }

	    void processPreparationQueue()
	    {
	        if(preparationQueue.isEmpty())
	        {
	            System.out.println("No orders in preparation");
	            return;
	        }

	        Order o = preparationQueue.poll();
	        deliveryQueue.add(o);

	        System.out.println("Order " + o.orderId + " Prepared");
	    }

	    void processDeliveryQueue()
	    {
	        if(deliveryQueue.isEmpty())
	        {
	            System.out.println("No orders to deliver");
	            return;
	        }

	        Order o = deliveryQueue.poll();
	        System.out.println("Order " + o.orderId + " Delivered to " + o.customerName);
	    }

	    void showMenu()
	    {
	        System.out.println("\n--- MENU ---");
	        for(int i=0;i<menuItems.length;i++)
	            System.out.println((i+1) + " " + menuItems[i] + " " + prices[i]);
	    }

	    void searchMenu()
	    {
	        sc.nextLine();
	        System.out.print("Enter item: ");
	        String item = sc.nextLine();

	        for(int i=0;i<menuItems.length;i++)
	        {
	            if(menuItems[i].equalsIgnoreCase(item))
	            {
	                System.out.println("Found: " + menuItems[i] + " Price: " + prices[i]);
	                return;
	            }
	        }

	        System.out.println("Item Not Found");
	    }

	    void showRestaurants()
	    {
	        for(Restaurant r : restaurants)
	            System.out.println(r.name + " Rating: " + r.rating);
	    }

	    void searchRestaurant()
	    {
	        sc.nextLine();
	        System.out.print("Enter name: ");
	        String name = sc.nextLine();

	        for(Restaurant r : restaurants)
	        {
	            if(r.name.equalsIgnoreCase(name))
	            {
	                System.out.println("Found: " + r.name);
	                return;
	            }
	        }

	        System.out.println("Not Found");
	    }

	    void sortRestaurants()
	    {
	        Arrays.sort(restaurants,(a,b)->Double.compare(b.rating,a.rating));
	        showRestaurants();
	    }
	}
