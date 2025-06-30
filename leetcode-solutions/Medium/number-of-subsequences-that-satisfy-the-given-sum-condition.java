/**
 * LeetCode Problem: 1498. Number of Subsequences That Satisfy the Given Sum Condition
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * 
 * Approach:
 * - Sort the array
 * - Use two pointers (left, right)
 * - For each valid window [left, right] where nums[left] + nums[right] <= target,
 *   all subsets of (right - left) elements can form valid subsequences
 * - Use precomputed powers of 2 for fast count
 * 
 * Time Complexity: O(n log n) — due to sorting and two-pointer scan
 * Space Complexity: O(n) — for pow2 array
 */


import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array

        int right = nums.length - 1;
        int left = 0;
        int count = 0;
        int [] pow2 = new int [nums.length]; // Precompute powers of 2 up to n-1

        pow2[0] = 1;

        // Fill pow2[i]
        for (int i = 1; i <= nums.length - 1; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // Two-pointer approach
        while (left <= right) {

            if (nums[right] + nums[left] > target) {
                right--; // Too big, try smaller max
            } else {
                count = (count + pow2[right - left]) % MOD; // If current min + max is within target, count subsequences
                left++;
            }
        }

        return count;
    }
}