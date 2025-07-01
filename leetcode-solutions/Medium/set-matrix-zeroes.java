/**
 * LeetCode Problem: 73. Set Matrix Zeroes
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * Approach:
 * - Use the first row and first column as markers to track which rows/cols should be zeroed.
 * - Use two booleans to remember if the first row or column should be zeroed at the end.
 * - Traverse the matrix twice:
 *   1. First pass: mark the zeros
 *   2. Second pass: apply zeroes based on markers
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        if (isFirstColZero) {
            for (int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}