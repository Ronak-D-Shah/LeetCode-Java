/**
 * LeetCode Problem: 80. Remove Duplicates from Sorted Array II
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Approach:
 * - Use two pointers: one for reading (`i`) and one for writing (`insertPos`).
 * - Allow each element to appear at most twice.
 * - Only copy the current element to `insertPos` if:
 *     - We’ve written fewer than 2 elements, OR
 *     - The current number is not equal to the number at `insertPos - 2`.
 * - This ensures that at most two copies of any number are retained.
 *
 * Time Complexity: O(n), where n is the length of nums
 * Space Complexity: O(1), in-place modification
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        if (nums.length <= 2) return nums.length;

        int insertPointer = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[insertPointer-2]) {
                // if (insertPointer > nums.length) return insertPointer - 1;
                nums[insertPointer] = nums[i];
                insertPointer += 1;
            }
        }

        return insertPointer;
    }
}