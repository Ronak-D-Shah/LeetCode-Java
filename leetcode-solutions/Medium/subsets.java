/**
 * LeetCode Problem: 78. Subsets
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/subsets/
 * 
 * Approach:
 * - Use backtracking (recursive DFS) to explore all possible subsets.
 * - At each recursive level, decide whether to include the current element.
 * - Add the current subset to the result list.
 * 
 * Time Complexity: O(2^n * n)
 * - There are 2^n possible subsets.
 * - Each subset can take up to O(n) to copy.
 * 
 * Space Complexity: O(2^n * n)
 * - For storing all subsets in the result list.
 */

import java.util.*;
 
class Solution {
    public List<List<Integer>> subsets(int[] nums) { 

        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from index 0
        backtrack(result, nums, 0, new ArrayList<>());
        return result;
    }
 
    public void backtrack(List<List<Integer>> result, int[] nums, int current, List<Integer> curr) {
        // Add the current subset
        result.add(new ArrayList<>(curr));
 
        // Explore further elements
        for (int i = current; i < nums.length; i++) {
            curr.add(nums[i]);                         // Include nums[i]
            backtrack(result, nums, i + 1, curr);      // Recurse on remaining elements
            curr.remove(curr.size() - 1);              // Backtrack to explore the next option
        }
    }
}
 