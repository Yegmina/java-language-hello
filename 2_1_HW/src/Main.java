//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        /* Variable myCar is a reference to an object that belongs to class Car.
         * After this declaration, however, it is not yet referring to any real object.
         */
        Car myCar;
        /* Car class constructor Car() is called.
         * The returned reference to a newly created object is assigned to variable myCar
         */
        myCar = new Car(5,10);
    }
}