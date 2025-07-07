/**
 * LeetCode Problem: 88. Merge Sorted Array
 * Difficulty: Easy
 *
 * Link: https://leetcode.com/problems/merge-sorted-array/
 *
 * Approach:
 * - Use three pointers starting from the end of the arrays
 * - Fill in nums1 from the back to avoid overwriting elements
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          // Pointer for nums1's last valid element
        int j = n - 1;          // Pointer for nums2's last element
        int k = m + n - 1;      // Pointer for final position in nums1

        // Merge while both arrays have elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]; // Place nums1[i] and move pointer
            } else {
                nums1[k--] = nums2[j--]; // Place nums2[j] and move pointer
            }
        }

        // If any elements are left in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}