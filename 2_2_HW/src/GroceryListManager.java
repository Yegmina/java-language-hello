import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, Double> groceryList;
    private final HashMap<String, String> categoryMap;
    // NEW for 2.2.4
    private final HashMap<String, Integer> quantityMap;

    public GroceryListManager() {
        this.groceryList  = new HashMap<>();
        this.categoryMap  = new HashMap<>();
        this.quantityMap  = new HashMap<>();
    }

    public void addItem(String item, double cost) {
        if (cost < 0) {
            System.out.println("Invalid Cost for " + item + "; not added");
            return;
        }
        groceryList.put(item, cost);
    }

    public void addItem(String item, double cost, String category) {
        if (cost < 0) {
            System.out.println("Invalid Cost for " + item + "; not added");
            return;
        }
        groceryList.put(item, cost);
        categoryMap.put(item, category);
    }

    //new for 2.2.3
    public void addItem(String item, double cost, String category, int quantity) {
        if (cost < 0) {
            System.out.println("Invalid Cost for " + item + "; not added");
            return;
        }
        if (quantity < 0) {
            System.out.println("Invalid Quantity for " + item + "; not added");
            return;
        }
        groceryList.put(item, cost);
        categoryMap.put(item, category);
        quantityMap.put(item, quantity);
    }

    // remove from all maps in memory, every part
    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {
            categoryMap.remove(item);
            quantityMap.remove(item);
            System.out.println(item + " removed.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("Your grocery list is empty.");
            return;
        }
        int i = 1;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            String name     = entry.getKey();
            Double cost     = entry.getValue();
            String category = categoryMap.get(name);
            System.out.println(
                    i++ + ". " + name + " - " + String.format("%.2f", cost)+ (category != null ? " [" + category + "]" : "")
            );
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (double cost : groceryList.values()) {
            total += cost;
        }
        return total;
    }

    public void displayByCategory(String category) {
        int count = 0;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            String name    = entry.getKey();
            Double cost    = entry.getValue();
            String catOfIt = categoryMap.get(name);
            if (catOfIt != null && catOfIt.equalsIgnoreCase(category)) {
                if (count == 0) {
                    System.out.println("Items in category \"" + category + "\":");
                }
                count++;
                System.out.println( "  " + count + ". " + name + " - " + String.format("%.2f", cost)+"$");
            }
        }
        if (count == 0) {
            System.out.println("No items found in category \"" + category + "\".");
        }
    }

    // new for 2.2.4
    public void updateQuantity(String item, int newQuantity) {
        if (!groceryList.containsKey(item)) {
            System.out.println(item + " not found; cannot update quantity.");
            return;
        }
        if (newQuantity < 0) {
            System.out.println("Invalid new quantity for " + item);
            return;
        }
        quantityMap.put(item, newQuantity);
        System.out.println(item + " quantity updated to " + newQuantity);
    }

//new 2.2.4
        public void displayAvailableItems() {
        int count = 0;
        for (String name : groceryList.keySet()) {
            Integer qty = quantityMap.get(name);
            if (qty != null && qty > 0) {
                if (count == 0) {
                    System.out.println("Available items:");
                }
                count++;
                System.out.println("  " + count + ". " + name + " - qty: " + qty);
            }
        }
        if (count == 0) {
            System.out.println("No items with positive quantity.");
        }
    }

    public HashMap<String, Double> getGroceryList() {
        return groceryList;
    }
    public void setGroceryList(HashMap<String, Double> newList) {
        this.groceryList = new HashMap<>(newList);
        this.categoryMap.clear();
        this.quantityMap.clear();
    }

    public static void main(String[] args) {
        GroceryListManager myList = new GroceryListManager();

        myList.addItem("Apple",   1.29, "Fruits",  5);
        myList.addItem("Banana",  0.59, "Fruits", 10);
        myList.addItem("Milk",    2.49, "Dairy",   0);
        myList.addItem("Cheese",  3.99, "Dairy",   2);
        myList.addItem("Bagel",   1.49, "Bakery",  4);

        System.out.println("Full list:");
        myList.displayList();

        System.out.println("\nTotal cost: "
                + String.format("%.2f", myList.calculateTotalCost()) + " $"
        );

        System.out.println();
        myList.displayByCategory("Fruits");
        myList.displayByCategory("Bakery");
        System.out.println();

        System.out.println("Updating quantities...");
        myList.updateQuantity("Milk", 3);
        myList.updateQuantity("Eggs",  6);  // 0

        System.out.println();
        myList.displayAvailableItems();
    }
}