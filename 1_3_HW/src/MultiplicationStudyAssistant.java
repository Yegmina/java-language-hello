import java.util.Scanner;

public class MultiplicationStudyAssistant {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome in program that helps u master multiptication. Are u ready to get the highest score at the school? Nice, lets start practise");
        boolean win=false;
        int QUOTA=10;
        while (!win) {
            System.out.println("Try to answer to this set of questions: ");
            int score = 0;
            for(int i=1;i<=QUOTA;i++) {
                int a = random10(), b = random10();
                System.out.println(Integer.toString(i)+ ". " + Integer.toString(a) + " * " + Integer.toString(b) + "= ?");
                int answer = scanner.nextInt();
                if (answer == a * b) {
                    score++;
                    System.out.println("this is correct anser! Your score is " + score);

                } else {
                    System.out.println("this is wrong! Your score is still " + score + " Correct answer was " + a * b);
                }
            }
            win=score>=QUOTA;


        }
        System.out.println("CONGRATS! You answered is correct for every question in the task list! Now you are ready to get A+ or 12/12 or 5/5 or whatever u have at ur school! ");
    }
    public static int random10() {
        return (int) (Math.random() * 10) + 1;
    }
}
