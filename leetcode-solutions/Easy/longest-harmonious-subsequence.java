/**
 * LeetCode Problem: 594. Longest Harmonious Subsequence
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/longest-harmonious-subsequence/
 * 
 * Approach:
 * - Use a HashMap to count the frequency of each number in the array.
 * - For each number in the map, check if (num + 1) exists in the map.
 * - If it does, the length of the harmonious subsequence is count(num) + count(num + 1).
 * - Track the maximum such value and return it.
 * 
 * Time Complexity: O(n) — one pass to count, one pass to check neighbors
 * Space Complexity: O(n) — to store the frequency map
 */

import java.util.*;
 
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countFreq = new HashMap<>();
        
        for (int num : nums) {
            countFreq.put(num, countFreq.getOrDefault(num, 0) + 1);
        }

        int result = 0;

        for (int num : countFreq.keySet()) {
            if (countFreq.containsKey(num + 1)) {
                result = Math.max(result, countFreq.get(num) + countFreq.get(num + 1));
            }
        }

        return result;
    }
}
 