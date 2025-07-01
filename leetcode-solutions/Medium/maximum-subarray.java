/**
 * LeetCode Problem: 53. Maximum Subarray
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/maximum-subarray/
 * 
 * Approach:
 * - Use Kadane's Algorithm to find the max sum in a single pass.
 * - At each index, decide whether to extend the previous subarray or start new from current index.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0]; // Initialize with the first element
        int maxSum = nums[0];     // Max sum found so far

        for (int i = 1; i < nums.length; i++) {
            // Decide to add current element to previous sum or start new
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update max sum if current is better
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
 