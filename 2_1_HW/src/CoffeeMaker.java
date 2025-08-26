
public class CoffeeMaker {

    private boolean isOn;
    private String coffeeType;
    private int amount;


    public CoffeeMaker() {
        this.isOn = false;
        this.coffeeType = "normal";
        this.amount = 40;
    }


    public void pressOnOff() {
        this.isOn = !this.isOn;
    }


    public boolean isOn() {
        return this.isOn;
    }


    public void setCoffeeType(String type) {
        // This is not type-safe. A user could pass any string.
        // We can add a check to make it safer.
        if (this.isOn && (type.equalsIgnoreCase("normal") || type.equalsIgnoreCase("espresso") || type.equalsIgnoreCase("latte"))) {
            this.coffeeType = type.toLowerCase();
        }
    }


    public String getCoffeeType() {
        return this.coffeeType;
    }


    public void setAmount(int ml) {
        if (this.isOn && ml >= 10 && ml <= 80) {
            this.amount = ml;
        }
    }


    public int getAmount() {
        return this.amount;
    }
}