import java.util.Scanner;

public class NamesGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter int number of names to generate: ");
        String input = scanner.nextLine();
        final int amountofnames= Integer.parseInt(input);
        for (int i = 0; i < amountofnames; i++) {
            System.out.println(getFullName());
        }
    }
    public static String getRandomIndexValue(String[] array) {
        try {
            double randomnum = Math.random();
            int randomindex = (int) (randomnum * array.length);
            if (randomindex == array.length) {
                System.out.println("not even sure if it is possible hah");
                return "too lucky";
            } else if (randomindex < array.length) { //as I understand we will only get from [0 to array*length-1), so only this things happens
                return array[randomindex];
            } else {
                throw new Error("unexpected random index, probably bug in randomindex calculation");
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public static String getFirstName() {
        final String[] firstNames={"1firstName", "2firstName", "3firstName"};
        return getRandomIndexValue(firstNames);

    }
    public static String getLastName() {
        final String[] lastNames={"1lastName", "2lastName", "3lastName"};
        return getRandomIndexValue(lastNames);
    }
    public static String getFullName() {
        final String name=getFirstName()+" "+getLastName();
        return name;
    }

}
