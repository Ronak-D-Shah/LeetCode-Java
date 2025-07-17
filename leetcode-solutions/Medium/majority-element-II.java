/**
 * LeetCode Problem: 229. Majority Element II
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/majority-element-ii/
 * 
 * Approach:
 * - Extended Boyer-Moore Voting Algorithm
 * - There can be at most 2 elements that appear more than n/3 times
 * - First pass to find potential candidates
 * - Second pass to validate their actual frequency
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // First Pass: Find potential candidates
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second Pass: Verify counts of the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();

        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        return result;
    }
}
