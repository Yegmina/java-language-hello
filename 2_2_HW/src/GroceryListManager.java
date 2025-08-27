import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, Double> groceryList;

    public GroceryListManager() {
        this.groceryList = new HashMap<>();
    }

    public void addItem(String item, double cost) {
        if (cost<0) {
            System.out.println("Invalid Cost for"+item+"not added");
            return;
        }
        groceryList.put(item, cost);
    }

    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {
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
            System.out.println( i+++". "+ entry.getKey()+ " "+entry.getValue()+"$");
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

    public HashMap<String, Double> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(HashMap<String, Double> newList) {
        this.groceryList = new HashMap<>(newList);
    }

    public static void main(String[] args) {
        GroceryListManager myList = new GroceryListManager();

        myList.addItem("Tomato", 2.49);
        myList.addItem("Cheese", 3.75);
        myList.addItem("Pepsi", 1.99);
        myList.addItem("Milk", 2.29);
        myList.addItem("-Milk", -2.29);

        System.out.println("Current list:");
        myList.displayList();

        System.out.println("Total cost: "+ myList.calculateTotalCost()+"$");

        System.out.println("\nIs milk in the list? " + myList.checkItem("Milk"));
        System.out.println("Removing Milk...");
        myList.removeItem("Milk");
        System.out.println("Is milk in the list? " + myList.checkItem("Milk"));

        System.out.println("\nUpdated list:");
        myList.displayList();
        System.out.printf("New total cost: "+ myList.calculateTotalCost()+" $");
    }
}