/**
 * LeetCode Problem: 26. Remove Duplicates from Sorted Array
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Approach:
 * - Use two pointers: one (i) for the position of the last unique element,
 *   and one (j) to scan the rest of the array.
 * - If nums[j] != nums[i], then it's a new unique element.
 *   Increment i and copy nums[j] to nums[i].
 * - After the loop, i + 1 is the number of unique elements.
 *
 * Time Complexity: O(n), where n is the number of elements in the array
 * Space Complexity: O(1), in-place modification
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        
        int insertPointer = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertPointer] = nums[i];
                insertPointer++;
            }
        }

        return insertPointer;
    }
}