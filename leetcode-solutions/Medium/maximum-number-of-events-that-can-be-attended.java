/**
 * LeetCode Problem: 1353. Maximum Number of Events That Can Be Attended
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 *
 * Approach:
 * - Greedy + Min Heap (PriorityQueue).
 * - Sort events by start day.
 * - Use a min-heap to always attend the event that ends the earliest.
 * - For each day from the earliest start to latest end:
 *    - Add all events starting today to the heap.
 *    - Remove events from heap that already ended.
 *    - Attend the event with the smallest end day (pop from heap).
 *
 * Time Complexity: O(N log N), where N is the number of events
 *   - Sorting: O(N log N)
 *   - Heap operations across all days: O(N log N)
 * Space Complexity: O(N) for the heap
 */

import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // Sort by start day
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = 0, i = 0, n = events.length, attended = 0;

        while (i < n || !minHeap.isEmpty()) {
            // Move to the next day with events or pending events in heap
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            // Add all events starting today
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]); // Push end day
                i++;
            }

            // Remove events that have already ended
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event today (with the earliest end)
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }

            day++; // Move to the next day
        }

        return attended;
    }
}
