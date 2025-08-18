import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        adventofcodetype(4);

        System.out.println("Hey! If you re interested, enter the tree height: ");

        Scanner scanner = new Scanner(System.in);
        int numberLines = 0;


        numberLines = scanner.nextInt(); //assuming user is writing int
        scanner.close();


        adventofcodetype(numberLines);

    }
    public static void adventofcodetype(int n) {
        // n is number of lines in Christmas tree
        String local_line="";

        for (int i=0; i<n; i++){
            local_line=" ".repeat(n-i) + "*".repeat(1+i*2);
            FunComands.say(local_line);

        }

    }

}


