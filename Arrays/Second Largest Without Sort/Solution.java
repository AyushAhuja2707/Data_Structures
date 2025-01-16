import java.util.Scanner;

class Solution {
    // Method to find the second largest element in an array
    public int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        // Step 1: Find the maximum element
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Step 2: Find the second largest element
        int secondLargest = -1; // Assume -1 if no second largest exists
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        // Input: Number of elements
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Input: Array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the second largest element
        try {
            int secondLargest = solution.getSecondLargest(arr);
            System.out.println("The second largest element is: " + secondLargest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
