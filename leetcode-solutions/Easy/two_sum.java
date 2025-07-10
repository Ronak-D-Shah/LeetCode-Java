/**
 * LeetCode Problem: 1. Two Sum
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/two-sum/
 * 
 * Approach:
 * - Use a HashMap to store num -> index
 * - For each number, check if its complement exists in the map
 * - If found, return [map.get(complement), current index]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;
 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementMap.containsKey(complement)) {
                result[0] = complementMap.get(complement);
                result[1] = i;
                return result;
            } else {
                complementMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}