import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        final Scanner scaner = new Scanner(System.in);
        System.out.println("Please enter the first coef:");
        String l1=scaner.nextLine();
        System.out.println("Please enter the second coef:");
        String l2=scaner.nextLine();
        System.out.println("Please enter the third coef:");
        String l3=scaner.nextLine();

        double a,b,c;
        try{
            a=Double.parseDouble(l1);
            b=Double.parseDouble(l2);
            c=Double.parseDouble(l3);
        } catch(NumberFormatException e){
            System.out.println("Please enter a number, check your input, try different way and restart");
            return;

        }
        String[] roots=solver(a,b,c);
        System.out.printf("Answer is: ");
        if (roots.length<2) {
        System.out.println(roots[0]);
        }
        else {
            System.out.print(roots[0]+" and "+roots[1]);
        }
    }
    public static String[] solver(double a, double b, double c) {
        double D = Math.pow(b, 2) - 4 * a * c;
        if (D < 0) {
            return new String[] {"No real roots"};
        }
        double sqrtD = Math.sqrt(D);
        double x1 = (-b + sqrtD) / (2 * a);
        double x2 = (-b - sqrtD) / (2 * a);
        x1=(double)Math.round(x1*100)/100;
        x2=(double)Math.round(x2*100)/100;
        return new String[] {Double.toString(x1), Double.toString(x2)};
    }

}
