/**
 * LeetCode Problem: 141. Linked List Cycle
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/linked-list-cycle/
 *
 * Approach:
 * - Use Floyd’s Cycle Detection Algorithm (Tortoise and Hare).
 * - Initialize two pointers: slow moves one step, fast moves two steps.
 * - If there's a cycle, they will eventually meet inside the cycle.
 * - If fast reaches null (end of list), there is no cycle.
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

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;  
        ListNode fast = head.next;   

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;           // If fast reaches the end, no cycle
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true; // slow and fast met → cycle exists
    }
}
