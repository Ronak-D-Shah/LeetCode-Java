/**
 * LeetCode Problem: 169. Majority Element
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/majority-element/
 * 
 * Approach:
 * - Use Boyer-Moore Voting Algorithm
 * - Maintain a candidate and a vote count
 * - Cancel out each different element with the candidate
 * - The majority element will remain in the end
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;      
        int candidate = 0;  

        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // set a new candidate
            }

            // Increment or decrement vote
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}