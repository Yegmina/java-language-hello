import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements you want in the array: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        System.out.println("Enter the elements you want in the array line by line: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer: ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        Result result = getMaxSumSubArray(arr);
        System.out.println("Maximum sum: " + result.maxSum);
        System.out.println("Integers: " + (result.startIndex + 1) + "-" + (result.endIndex + 1));
    }

    public static int getSumArray(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static Result getMaxSumSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentSum = getSumArray(arr, i, j);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return new Result(maxSum, startIndex, endIndex);
    }

    static class Result { //inner class
        int maxSum;
        int startIndex;
        int endIndex;
        Result(int maxSum, int startIndex, int endIndex) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }
}