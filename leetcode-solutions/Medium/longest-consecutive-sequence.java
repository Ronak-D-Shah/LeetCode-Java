/**
 * LeetCode 128: Longest Consecutive Sequence
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Approach:
 * - Use a HashSet to store all unique elements
 * - Iterate through the set
 *   - If current number is the start of a sequence (i.e., num - 1 doesn't exist)
 *   - Expand forward to count the length of the sequence
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Store all elements in a HashSet for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Check each number in set
        for (int num : numSet) {
            // Only start a sequence if (num - 1) is not in set
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Expand forward
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}