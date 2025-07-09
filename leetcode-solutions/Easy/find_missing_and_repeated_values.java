/**
 * LeetCode-style Problem: Find Missing and Repeated Values
 * Difficulty: Easy
 * 
 * Approach:
 * - Flatten the 2D matrix into 1D traversal
 * - Count frequencies using an array (value range: 1 to n^2)
 * - Find which value appears twice (repeated) and which doesn't appear (missing)
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1]; // Use 1-based indexing for values 1 to n^2

        // Step 1: Count frequencies of all numbers
        for (int[] row : grid) {
            for (int num : row) {
                count[num]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        // Step 2: Find the repeated and missing values
        for (int i = 1; i <= n * n; i++) {
            if (count[i] == 2) {
                repeated = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}