/**
 * LeetCode Problem: 40. Combination Sum II
 * Difficulty: Medium
 *
 * Link: https://leetcode.com/problems/combination-sum-ii/
 *
 * Approach:
 * - Sort the array to handle duplicates
 * - Backtrack while skipping repeated elements at the same depth
 * - Only use each number once (move to next index)
 *
 * Time: O(2^n)
 * Space: O(n) + result list
 */

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack (candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    public void backtrack (int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0){
            result.add (new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same recursive level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Stop recursion if current number exceeds target
            if (candidates[i] > target) break;
            
            current.add (candidates[i]);
            backtrack (candidates, target - candidates[i], i + 1, current, result);
            current.remove (current.size() - 1);
            
        }
    }
}