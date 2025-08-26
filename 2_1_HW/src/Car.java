public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;

    private int targetSpeed;
    private boolean isCruiseControlOn;

    public static final int MIN_CRUISE_SPEED = 40;
    public static final int MAX_CRUISE_SPEED = 140;


    public Car(String typeName) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;
        this.isCruiseControlOn = false;
        this.targetSpeed = MIN_CRUISE_SPEED;
    }

    public Car(double gasolinelevel, double speed) {
        this.gasolineLevel = gasolinelevel;
        this.speed = speed;
        this.isCruiseControlOn = false;
        this.targetSpeed = MIN_CRUISE_SPEED;
    }


    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 5;
            gasolineLevel -= 0.5;
        } else {
            speed = 0;
        }
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
        }
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        if (typeName == null) {
            return "null";
        }
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }


    public void setTargetSpeed(int speed) {
        if (speed >= MIN_CRUISE_SPEED && speed <= MAX_CRUISE_SPEED) {
            this.targetSpeed = speed;
        } else {
            System.out.println("Error: Target speed must be between " +
                    MIN_CRUISE_SPEED + " and " + MAX_CRUISE_SPEED + " km/h.");
        }
    }


    public int getTargetSpeed() {
        return this.targetSpeed;
    }


    public void turnOffCruiseControl() {
        this.isCruiseControlOn = false;
    }


    public boolean turnOnCruiseControl() {
        if (gasolineLevel <= 0) {
            System.out.println("Cannot engage cruise control: Out of gas!");
            return false;
        }

        this.isCruiseControlOn = true;
        System.out.println("Cruise control engaging... Adjusting speed.");

        while (this.isCruiseControlOn && Math.abs(this.speed - this.targetSpeed) > 1) {
            if (gasolineLevel <= 0) {
                System.out.println("Ran out of gas while adjusting speed!");
                this.speed = 0;
                turnOffCruiseControl();
                return false;
            }

            if (this.speed < this.targetSpeed) {
                accelerate();
            } else if (this.speed > this.targetSpeed) {
                decelerate(5);
            }
        }

        if (!this.isCruiseControlOn) {
            return false;
        }

        this.speed = this.targetSpeed;
        return true;
    }
}