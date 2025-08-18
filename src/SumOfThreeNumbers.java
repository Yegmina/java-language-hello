import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());
        float sum = first + second + third;
        FunComands.say("The sum of the numbers is " + Math.round(sum));

        FunComands.say("The product of the numbers is " + (first * second * third));
        FunComands.say("The average of the numbers is " + (sum/3));

    }
}