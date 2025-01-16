class Solution {

    // Function to swap two elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to reverse a subarray in the array
    static void rev(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Function to find next permutation
    static void ans(int[] arr) {
        // Step 1: Find the dip (first decreasing element from the right)
        int idx = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no dip found, array is in descending order, reverse the whole array
        if (idx == -1) {
            rev(arr, 0, arr.length - 1);
            return;
        }

        // Step 2: Find the smallest element greater than arr[idx] from the right
        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                swap(arr, i, idx);
                break;
            }
        }

        // Step 3: Reverse the suffix (subarray after idx)
        rev(arr, idx + 1, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 4, 3, 2, 0, 0 };
        ans(arr); // Call to find the next permutation
        // Print the result
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
