import java.util.Scanner;

public class TemperatureCalculator
{
    //sr about naming conventions, I assume it is not a problem how I name variables and methods
    public static void main(String[] args)
    {
        final Scanner reader = new Scanner(System.in);

        System.out.print("Give me temperature in fahrenheit: ");
        String input_line=reader.nextLine();

        int fahrenheit = Integer.parseInt(input_line); //yeah, assume that user is not stupid to write sth random like characters, we just parse as int

        F2C(fahrenheit);

    }
    public static void F2C(float fahrenheit) {
        float celcius = (fahrenheit - 32) * 5 / 9;
        double celcius_rounded = Math.round(celcius*10)/10.0; // here I used rounding, not just formating the output because formating just round to floor, but we need to have correct math formating for temperature calculation

        System.out.println("Celcius is " + celcius_rounded);


    }

}
