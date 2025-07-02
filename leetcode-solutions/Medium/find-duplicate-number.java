/**
 * LeetCode Problem: 287. Find the Duplicate Number
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Approach:
 * - Treat the array as a linked list: index as node, nums[i] as next pointer
 * - Apply Floyd’s Cycle Detection to find the entrance of the cycle
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle using slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];

        // Move slow by 1 step, fast by 2 steps until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to the cycle (duplicate number)
        slow = nums[0]; // reset slow to beginning

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // duplicate number
    }
}
