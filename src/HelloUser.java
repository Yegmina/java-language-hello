import java.util.Scanner;

public class HelloUser
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your name: ");
        final String name=reader.nextLine();

        System.out.println("Hello, "+name+"!");
        final String name2=reader.nextLine();

        System.out.println("Hello, "+name2+"!");
    }
}
