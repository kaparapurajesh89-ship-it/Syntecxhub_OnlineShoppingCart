import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store item prices
        HashMap<String, Double> items = new HashMap<>();

        items.put("Laptop", 50000.0);
        items.put("Mobile", 20000.0);
        items.put("Headphones", 2000.0);
        items.put("Mouse", 500.0);

        // Store cart items
        ArrayList<String> cart = new ArrayList<>();

        // Store quantities
        HashMap<String, Integer> quantity = new HashMap<>();

        int choice;

        do {

            System.out.println("\n===== Online Shopping Cart =====");
            System.out.println("1. View Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Total Price");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nAvailable Items:");

                    for (String item : items.keySet()) {
                        System.out.println(item + " - Rs." + items.get(item));
                    }

                    break;

                case 2:

                    System.out.print("Enter Item Name: ");
                    String itemName = sc.nextLine();

                    if (items.containsKey(itemName)) {

                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        cart.add(itemName);
                        quantity.put(itemName, qty);

                        System.out.println("Item Added to Cart");

                    } else {
                        System.out.println("Item Not Available");
                    }

                    break;

                case 3:

                    System.out.println("\n===== Your Cart =====");

                    if (cart.isEmpty()) {
                        System.out.println("Cart is Empty");
                    } else {

                        for (String item : quantity.keySet()) {

                            System.out.println(
                                item + 
                                " | Quantity: " + quantity.get(item) +
                                " | Price: Rs." + items.get(item)
                            );
                        }
                    }

                    break;

                case 4:

                    double total = 0;

                    for (String item : quantity.keySet()) {

                        total = total + 
                               (items.get(item) * quantity.get(item));
                    }

                    System.out.println("Total Price = Rs." + total);

                    break;

                case 5:

                    System.out.println("Thank You for Shopping!");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}