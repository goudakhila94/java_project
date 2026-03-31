package review_1;
import java.util.*;

public class FoodDeliveryApp_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        FoodDeliverySystem_ system = new FoodDeliverySystem_();

        int choice;

        do
        {
            System.out.println("\n---- FOOD DELIVERY SYSTEM ----");
            System.out.println("1 Place Order");
            System.out.println("2 Show Orders");
            System.out.println("3 Search Order");
            System.out.println("4 Show Menu");
            System.out.println("5 Search Menu Item");
            System.out.println("6 Show Restaurants");
            System.out.println("7 Search Restaurant By Name");
            System.out.println("8 Sort Restaurants By Rating");
            System.out.println("10 Remove Order from Cart");
            System.out.println("11 Undo Remove");
            System.out.println("12 Process Preparation Queue");
            System.out.println("13 Process Delivery Queue");
            System.out.println("14 Show Order History");
            System.out.println("9 Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: system.placeOrder(); break;
                case 2: system.showOrders(); break;
                case 3: system.searchOrder(); break;
                case 4: system.showMenu(); break;
                case 5: system.searchMenu(); break;
                case 6: system.showRestaurants(); break;
                case 7: system.searchRestaurant(); break;
                case 8: system.sortRestaurants(); break;
                case 10: system.removeOrderFromCart(); break;
                case 11: system.undoRemove(); break;
                case 12: system.processPreparationQueue(); break;
                case 13: system.processDeliveryQueue(); break;
                case 14: system.showOrderHistory(); break;
                case 9: System.out.println("Program Closed"); break;
                default: System.out.println("Invalid Choice");
            }

        } while(choice != 9);
    }
}
