/**
 * LeetCode Problem: 142. Linked List Cycle II
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Approach:
 * - Use Floyd’s Cycle Detection Algorithm (Tortoise and Hare) to detect a cycle.
 * - First, detect if a cycle exists by moving two pointers (slow and fast).
 * - If a cycle exists, reset one pointer to the head and move both one step at a time.
 * - The point where they meet is the start of the cycle.
 *
 * Why this works:
 * - Let the length from head to cycle start be `L1`
 * - Let the distance from cycle start to meeting point be `L2`
 * - Let the cycle length be `C`
 * - When slow and fast meet, fast has moved 2x steps and slow x steps:
 *      2x = x + kC → x = kC → both have moved `k` full cycles inside the loop.
 * - Resetting one pointer to head and moving both at same speed ensures
 *   they meet at the cycle start after `L1` steps.
 *
 * Time Complexity: O(n), where n is the number of nodes in the list
 * Space Complexity: O(1), constant space
 */

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Step 2: Find the start of the cycle
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start; // This is the node where the cycle begins
            }
        }

        return null; // No cycle
    }
}
