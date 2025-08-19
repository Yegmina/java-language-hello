import java.util.Scanner;

public class Triangle
{
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the first leg of the triangle");
        String a = scan.nextLine();
        System.out.println("Please enter the second leg of the triangle");
        String b = scan.nextLine();
        String[] args_for_pif={a,b}; // yeah I know that it is not neces here, we could just transfer a and b instead of array
        System.out.println("hypotenuse of the triangle equal " + PifagorCalculator(args_for_pif));
    }
    public static float PifagorCalculator(String[] args) {
        float a,b;
        try {
            a = Float.parseFloat(args[0]);
            b = Float.parseFloat(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Input was not a number, Pifagor formula only with numbers");
            throw new RuntimeException(e);
        }
        if (a<0 || b<0) {
            System.out.println("Error, length cannot be negative, it is triangle, not algebra!");
        }
        float c;
        try {c = (float) Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2));} catch (ArithmeticException e) {System.out.println("unexpected exception happens during hypothenusa calculation"+ e); throw new RuntimeException(e);}
        return c;
    }
}
