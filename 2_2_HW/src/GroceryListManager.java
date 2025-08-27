import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {

    private HashMap<String, Double> groceryList;
    private final HashMap<String, String> categoryMap;

    public GroceryListManager() {
        this.groceryList  = new HashMap<>();
        this.categoryMap  = new HashMap<>();
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

    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {
            categoryMap.remove(item);
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
                    i++ + ". " + name + " - " + cost + (category != null ? " [" + category + "]" : "")
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

    /** NEW 4-r 2-2-2*/
    public void displayByCategory(String category) {
        int count = 0;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            String name     = entry.getKey();
            Double cost     = entry.getValue();
            String catOfIt  = categoryMap.get(name);
            if (catOfIt != null && catOfIt.equalsIgnoreCase(category)) {
                if (count == 0) {
                    System.out.println("Items in category \"" + category + "\":");
                }
                count++;
                System.out.println("  " + count + ". " + name + " - " + String.format("%.2f", cost)+"$");            }
        }
        if (count == 0) {
            System.out.println("No items found in category \"" + category + "\".");
        } else if (count<0) {
            System.out.println("WTFFFFFFF");
        }
    }

    public HashMap<String, Double> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(HashMap<String, Double> newList) {
        this.groceryList = new HashMap<>(newList);
        this.categoryMap.clear();
    }

    public static void main(String[] args) {
        GroceryListManager myList = new GroceryListManager();

        myList.addItem("Apple",   1.29, "Fruits");
        myList.addItem("Banana",  0.59, "Fruits");
        myList.addItem("Milk",    2.49, "Dairy");
        myList.addItem("Cheese",  3.99, "Dairy");
        myList.addItem("Bagel",   1.49, "Bakery");

        System.out.println("Full list:");
        myList.displayList();

        System.out.println("\nTotal cost: " + String.format("%.2f", myList.calculateTotalCost())+" $");

        System.out.println();
        myList.displayByCategory("Fruits");
        myList.displayByCategory("Bakery");
        myList.displayByCategory("Meat");  //0

        System.out.println("\nRemoving Banana…");
        myList.removeItem("Banana");

        System.out.println();
        myList.displayByCategory("Fruits");
    }
}