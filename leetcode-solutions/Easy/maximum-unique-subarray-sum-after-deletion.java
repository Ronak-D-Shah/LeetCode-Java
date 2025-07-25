import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem: Maximum Unique Subarray Sum After Deletion
 * Difficulty: Easy
 *
 * Link: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/
 *
 * Approach:
 * - The problem allows us to "delete any number of elements" and then "select a subarray". This implies that we can effectively pick any subsequence of the original array and then find a contiguous sub-subsequence from it.
 * - The key to maximizing the sum while ensuring uniqueness is to realize that:
 * 1. Negative numbers will always decrease the sum if they are included.
 * 2. Zeroes will not change the sum.
 * 3. Duplicate numbers (positive, negative, or zero) make the subarray non-unique.
 * - Therefore, to maximize the sum, we should aim to include only unique positive numbers.
 *
 * Algorithm:
 * 1. **Handle Non-Positive Numbers:** Iterate through the `nums` array to find the maximum element. If this maximum element is less than or equal to 0, it means all numbers in the array are non-positive. In this specific case, the maximum unique subarray sum will simply be this largest single element, as including any other non-positive numbers or forming a subarray would only result in a sum less than or equal to that single maximum element.
 * 2. **Sum Unique Positive Numbers:** If there is at least one positive number in `nums`, our goal is to sum all unique positive numbers present in the array. We use a `HashSet` to keep track of the positive numbers we've already added to our `currentSum`.
 * - Iterate through `nums`.
 * - For each number:
 * - If the number is positive and has not been added to our `currentSum` before (i.e., it's not in the `seen` set), add it to `currentSum` and mark it as seen in the `HashSet`.
 * - If the number is non-positive (negative or zero), or if it's a positive number that has already been seen, we effectively "delete" it by simply ignoring it.
 * 3. The final `currentSum` will be the maximum sum of a unique subarray.
 *
 * Why this works:
 * - By "deleting" (ignoring) all non-positive numbers and duplicate positive numbers, we are effectively constructing a new conceptual array composed only of unique positive elements. From this conceptual array, the maximum unique subarray sum will be the sum of all its elements, as all elements are positive and unique, thus contributing positively to the sum.
 *
 * Time Complexity: O(n), where n is the length of `nums`. We iterate through the array at most twice (once to find the max value, and once to sum unique positive numbers). `HashSet` operations (add, contains) take O(1) on average.
 * Space Complexity: O(k), where k is the number of unique positive elements in `nums`. In the worst case, k can be up to n, so O(n). Given the constraints (-100 <= nums[i] <= 100), the space complexity for the `HashSet` would be O(1) effectively, as there are at most 100 possible positive unique values.
 */

class Solution {
    public int maxSum(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // int sum = 0;
        // int maxNeg = Integer.MAX_VALUE;

        // if (nums.length == 1) {
        //     return sum += nums[0];
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] < 0) {
        //         maxNeg = Math.max(maxNeg, nums[i]);
        //     }
        //     if (set.contains(nums[i])) {
        //         continue;
        //     }
        //     else {
        //         set.add(nums[i]);
        //         sum = Math.max(sum, sum + nums[i]);
        //     }
        // }

        // return Math.min(sum, maxNeg);


        
        // Step 1: Handle the case where all numbers are non-positive.
        // In this scenario, the maximum unique subarray sum will be the largest single element,
        // as including any other negative/zero numbers would only decrease or maintain the sum.
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        if (maxVal <= 0) {
            return maxVal;
        }

        // Step 2: If there are positive numbers, we want to sum all unique positive numbers.
        // Negative numbers and duplicate positive numbers should be "deleted" (ignored).
        Set<Integer> seen = new HashSet<>();
        int currentSum = 0;

        for (int num : nums) {
            // Only consider positive numbers that haven't been seen before
            if (num > 0 && !seen.contains(num)) {
                currentSum += num;
                seen.add(num);
            }
        }

        return currentSum;
    }
}