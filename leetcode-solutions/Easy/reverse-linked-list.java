/**
 * LeetCode: 206. Reverse Linked List
 * Difficulty: Easy
 *
 * Approach: Iterative
 * - Use three pointers: prev, curr, next.
 * - At each step, reverse the curr.next to point to prev.
 * - Move the pointers one step forward.
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

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}