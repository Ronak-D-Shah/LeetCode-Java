/**
 * LeetCode 560: Subarray Sum Equals K
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Approach:
 * - Use prefix sums to avoid nested loops.
 * - Use a HashMap to store prefix sum frequencies.
 * - For each element, check if (current prefixSum - k) has been seen before.
 * - If yes, those previous occurrences form valid subarrays ending at current index.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: sum 0 occurs once

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}