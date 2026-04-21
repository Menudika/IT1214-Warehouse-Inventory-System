import java.util.ArrayList;
import java.util.Scanner;

// ----------- Item Class -----------
class Item {
    private String itemId;
    private String itemName;
    private int quantity;
    private double price;

    // Constructor
    public Item(String itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString
    public String toString() {
        return "ID: " + itemId +
               ", Name: " + itemName +
               ", Quantity: " + quantity +
               ", Price: " + price;
    }
}

// ----------- Inventory Class -----------
class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    // Add item
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    // Remove item
    public void removeItem(String itemId) {
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                items.remove(item);
                System.out.println("Item removed!");
                return;
            }
        }
        System.out.println("Item not found!");
    }

    // Update quantity
    public void updateQuantity(String itemId, int quantity) {
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                item.setQuantity(quantity);
                System.out.println("Quantity updated!");
                return;
            }
        }
        System.out.println("Item not found!");
    }

    // Search item
    public void searchItem(String keyword) {
        for (Item item : items) {
            if (item.getItemId().equals(keyword) ||
                item.getItemName().equalsIgnoreCase(keyword)) {
                System.out.println(item);
                return;
            }
        }
        System.out.println("Item not found!");
    }

    // Display all
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}

// ----------- Main Class -----------
public class Warehouse {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Warehouse Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");

            // Handle invalid input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    inventory.addItem(new Item(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    inventory.removeItem(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String updateId = sc.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    inventory.updateQuantity(updateId, newQty);
                    break;

                case 4:
                    System.out.print("Enter ID or Name: ");
                    inventory.searchItem(sc.nextLine());
                    break;

                case 5:
                    inventory.displayItems();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
