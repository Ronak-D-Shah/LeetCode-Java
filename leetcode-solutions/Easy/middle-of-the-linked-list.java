/**
 * LeetCode: 876. Middle of the Linked List
 * Difficulty: Easy
 * 
 * Approach:
 * - Use two pointers: slow and fast
 * - slow moves 1 step, fast moves 2 steps
 * - When fast reaches the end, slow will be in the middle
 * - If the list has even number of nodes, it returns the second middle
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast == null || fast.next == null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}