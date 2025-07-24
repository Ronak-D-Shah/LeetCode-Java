/**
 * LeetCode Problem: 61. Rotate List
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/rotate-list/
 *
 * Approach:
 * - First, handle edge cases (empty list, single node, or k == 0).
 * - Find the length of the list and make the list circular by connecting the tail to head.
 * - Compute the effective rotations needed: k % length.
 * - Find the new tail: (length - k % length - 1)th node.
 * - Set the new head to newTail.next and break the circle by setting newTail.next = null.
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode dummy = head;
        int length = 1;
        while (dummy.next != null) {
            dummy = dummy.next;
            length++;
        }
        // System.out.println(length);
        int position = k % length;

        if (position == 0) return head;
        ListNode newHead = head;
        for (int i = 0; i < length - position - 1; i++) {
            newHead = newHead.next;
        }
        ListNode next = newHead.next;
        newHead.next = null;
        dummy.next = head;
        return next;
    }
}