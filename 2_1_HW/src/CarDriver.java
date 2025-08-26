public class CarDriver {
    public static void main(String[] args) {
        System.out.println(" Test Case 1: Successful Cruise Control");
        Car myCar = new Car("Toyota Camry");
        myCar.fillTank();
        System.out.println("Initial Speed: " + myCar.getSpeed() + " km/h");
        System.out.println("Setting target speed to 100 km/h.");
        myCar.setTargetSpeed(100);

        System.out.println("Engaging cruise control...");
        boolean success = myCar.turnOnCruiseControl();

        if (success) {
            System.out.println("Cruise control engaged successfully!");
            System.out.println("Final Speed: " + myCar.getSpeed() + " km/h");
            System.out.println("Target Speed: " + myCar.getTargetSpeed() + " km/h");
        } else {
            System.out.println("Cruise control failed to engage.");
            System.out.println("Final Speed: " + myCar.getSpeed() + " km/h");
        }
        myCar.turnOffCruiseControl();
        System.out.println("Cruise control is now off.");

        System.out.println("\n-------------\n");

        System.out.println("test Case 2: Failure (No Gas) ");
        Car emptyCar = new Car("Old Clunker");
        System.out.println("Car has " + emptyCar.getGasolineLevel() + " fuel.");
        System.out.println("Initial Speed: " + emptyCar.getSpeed() + " km/h");
        System.out.println("Setting target speed to 80 km/h.");
        emptyCar.setTargetSpeed(80);

        System.out.println("Engaging cruise control...");
        success = emptyCar.turnOnCruiseControl();

        if (success) {
            System.out.println("Cruise control engaged successfully!");
        } else {
            System.out.println("Cruise control failed to engage, as expected.");
            System.out.println("Final Speed: " + emptyCar.getSpeed() + " km/h");
        }

        System.out.println("\n-------------------------------------\n");

        System.out.println("Test Case 3: Failure (Invalid Target Speed)");
        myCar.setTargetSpeed(200);
        System.out.println("Attempted to set target speed to 200 km/h.");
        System.out.println("Current target speed is: " + myCar.getTargetSpeed() + " km/h (Should not have changed from 100).");
    }
}