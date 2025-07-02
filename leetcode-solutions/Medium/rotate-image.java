/**
 * LeetCode Problem: 48. Rotate Image
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/rotate-image/
 * 
 * Approach:
 * - Step 1: Transpose the matrix (convert rows to columns)
 * - Step 2: Reverse each row to get 90 degree clockwise rotation
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) — in-place
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (top right triangle)
        // Swap elements at (i, j) with (j, i) for i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap elements across diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    // Helper function to reverse elements in a row
    private void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left < right) {
            // Swap left and right
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;

            left++;
            right--;
        }
    }
}