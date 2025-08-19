import java.util.Scanner;

public class BinaryValues {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number = input.nextLine();
        //System.out.println(number.length());
        int decimal = 0;
        for  (int i = 0; i < number.length(); i++) {
            decimal= (int) (decimal+(((int) (number.charAt(i)))-48) * Math.pow(2,number.length()-i-1)); //49 for 1 and 48 for 0 in asci
        }
        System.out.println(decimal);

    }
}
