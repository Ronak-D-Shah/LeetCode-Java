/**
 * LeetCode Problem: 74. Search a 2D Matrix
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Approach:
 * - Treat the matrix as a 1D sorted array of size m * n
 * - Perform binary search over the flattened index
 * - Convert 1D index to 2D using: row = mid / n, col = mid % n
 * 
 * Time Complexity: O(log(m * n))
 * Space Complexity: O(1)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;     
        int n = matrix[0].length;  

        int low = 0;
        int high = m * n - 1; 

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;     
            int col = mid % n;      

            int value = matrix[row][col];

            if (value == target) {
                return true;          // Found target
            } else if (value < target) {
                low = mid + 1;        // Search right
            } else {
                high = mid - 1;       // Search left
            }
        }
        return false;
    }
}