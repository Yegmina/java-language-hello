import java.util.Scanner;

public class FinOldWeightSystem {
    // Conversion constants
    public static final double GRAMS_PER_LUOTI = 13.28;
    public static final int LUOTI_PER_NAULA = 32;
    public static final int NAULA_PER_LEIVISKA = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Weight (g): ");
        double grams;
        try {
            grams = scanner.nextDouble();
        }
        catch(Exception e) {System.out.println("try to use another input, it should be number. if u used . or , in number, try to switch"+e); throw e;}
        if (grams < 0) { System.out.print("Weight cannot be negative, we are not flying");}
        double totalLuoti = grams / GRAMS_PER_LUOTI;

        int leiviska = (int) (totalLuoti / (LUOTI_PER_NAULA * NAULA_PER_LEIVISKA));

        double luotiAfterLeiviska = totalLuoti - (leiviska * NAULA_PER_LEIVISKA * LUOTI_PER_NAULA);

        int naula = (int) (luotiAfterLeiviska / LUOTI_PER_NAULA);

        double luoti = luotiAfterLeiviska - (naula * LUOTI_PER_NAULA);

        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n", grams, leiviska, naula, luoti);
    }
}