/**
 * LeetCode Problem: 56. Merge Intervals
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/merge-intervals/
 * 
 * Approach:
 * - Sort intervals by start time
 * - Iterate through the intervals
 *   - If current interval overlaps with last merged, merge them
 *   - Else, add current to result list
 * 
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(n) for the result list
 */

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Step 2: Iterate through intervals
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}