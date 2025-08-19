import java.util.Scanner;

public class PrimeNumberGen {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Prime Numbers Generator, give start num");
        final int start=scan.nextInt();
        System.out.println("Prime Numbers Generator, give end num");
        final int end=scan.nextInt();
        if (start > end) {
            System.out.println("Got start more than end num, should be start<end");
            return;
        }
        for(int i=start;i<=end;i++) {
            if (isPrime(i)) {
                System.out.printf(i+" ");
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n<=1)
            return false;
        for (int i=2; i<Math.sqrt(n); i++) { //well not the most efficient method, but should be fine for the assignment because input lim not specifiend and max mem/time also
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
