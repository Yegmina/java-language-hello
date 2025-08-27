import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();
    public GroceryListManager() {
        this.groceryList = new ArrayList<>();
    }
    public void addItem(String item){
        this.groceryList.add(item);
    }
    public void removeItem(String item){
        this.groceryList.remove(item);
    }
    public void displayList(){
        for (int i=0; i<this.groceryList.size();i++) {
            System.out.println(i+1+"."+this.groceryList.get(i));
        }
    }
    public ArrayList<String> getGroceryList(){
        return this.groceryList;
    }
    public void setGroceryList(ArrayList<String> groceryList){
        this.groceryList=groceryList;
    }
    public boolean checkItem(String item){
        for (int i = 0; i < this.groceryList.size(); i++) {
            if (item.equalsIgnoreCase(this.groceryList.get(i))) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        GroceryListManager myList=new GroceryListManager();
        myList.addItem("Tomato");
        myList.addItem("Cheese");
        myList.addItem("Pepsi");
        myList.addItem("SthElselol");
        System.out.println("I need to buy: "+myList.getGroceryList().size()+"items");
        myList.displayList();
        System.out.println("is milk here? "+myList.checkItem("Milk"));
        System.out.println("is tomato here?"+myList.checkItem("Tomato"));
        System.out.println("removing tomaaattoooooo");
        myList.removeItem("Tomato");
        System.out.println("is tomato here?"+myList.checkItem("Tomato"));
        System.out.println("I need to buy: "+myList.getGroceryList().size()+"items");
        myList.displayList();

    }

}