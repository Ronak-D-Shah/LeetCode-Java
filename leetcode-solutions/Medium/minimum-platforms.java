/**
 * GeeksforGeeks Problem: Minimum Platforms
 * Difficulty: Medium
 * 
 * Link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/
 *
 * Approach:
 * - Sort both arrival and departure arrays.
 * - Use two pointers to traverse the arrays:
 *   - If next train arrives before the current one departs, increment platform count.
 *   - Else, a train has departed, so reduce the platform count.
 * - Keep track of the maximum platforms needed at any time.
 *
 * Time Complexity: O(n log n), due to sorting
 * Space Complexity: O(1), ignoring input arrays
 */

import java.util.Arrays;

// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int minPlatforms = 0;
        int i = 1;
        int j = 0;
        int currPlatforms = 1;
        int n = arr.length;
        
        if (n == 1) return 1;
        
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                currPlatforms++;
                i++;
            } else {
                currPlatforms--;
                j++;
            }
            minPlatforms = Math.max(minPlatforms, currPlatforms);
        }
        
        return minPlatforms;
    }
}
