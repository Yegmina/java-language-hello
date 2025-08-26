
public class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker();

        myCoffeeMaker.pressOnOff();

        if (myCoffeeMaker.isOn()) {
            System.out.println("Coffee maker is on");
        }

        myCoffeeMaker.setCoffeeType("espresso");
        myCoffeeMaker.setAmount(50);

        System.out.println("Coffee type is " + myCoffeeMaker.getCoffeeType());
        System.out.println("Coffee amount is " + myCoffeeMaker.getAmount() + " ml");

        myCoffeeMaker.pressOnOff();

        if (!myCoffeeMaker.isOn()) {
            System.out.println("Coffee maker is off");
        }
    }
}