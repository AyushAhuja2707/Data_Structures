import java.util.HashMap;

public class LongestSumSubarray {
    public static int longestSubarrayWithSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];

            // If cumulative sum equals the target, the subarray starts from index 0
            if (cumulativeSum == target) {
                maxLength = i + 1;
            }

            // If (cumulativeSum - target) exists, calculate the subarray length
            if (map.containsKey(cumulativeSum - target)) {
                maxLength = Math.max(maxLength, i - map.get(cumulativeSum - target));
            }

            // Add cumulativeSum to the map if not already present
            map.putIfAbsent(cumulativeSum, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases including negative numbers
        int[] nums = { 2, -2, 3, 1, -4, 2, 3 };
        int target = 3;

        int result = longestSubarrayWithSum(nums, target);
        System.out.println("Length of the longest subarray: " + result);
    }
}
