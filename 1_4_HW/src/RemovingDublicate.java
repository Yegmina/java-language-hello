import java.util.Scanner;

public class RemovingDublicate {
    public static void main(String[] args)
    {
        System.out.println("Enter the size of the array: ");
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt( sc.nextLine() );
        int[] arr = new int[size];
        System.out.println("Enter the integers into the array:");
        int ii=0;
        for (int i = 0; i < arr.length; i++){
            System.out.println("Enter integer "+Integer.toString(i+1)+":");
            int current=Integer.parseInt( sc.nextLine() );
            if (!isInArray(arr, current)) {
                arr[ii] = current;
                ii++;
            }
        }
        printArray(arr, 0, ii);


    }
    public static void printArray(int[] arr, int start, int end)
    {
        for (int i=start; i<end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static boolean isInArray(int[] arr, int number)
    {
        for (int index = 0; index < arr.length; index++)
        {
            if (arr[index] == number)
            {
                return true;
            }
        }
        return false;

    }
}
