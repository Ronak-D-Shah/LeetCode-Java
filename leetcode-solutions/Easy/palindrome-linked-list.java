/**
 * LeetCode Problem: 234. Palindrome Linked List
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/palindrome-linked-list/
 *
 * Approach:
 * - Use fast and slow pointers to find the middle of the list.
 * - Reverse the second half of the list.
 * - Compare the first and second half node-by-node.
 * - Restore the list (optional).
 * - Return true if all nodes matched, false otherwise.
 *
 * Time Complexity: O(n), where n is the number of nodes in the list
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

    public boolean isPalindrome(ListNode head) {
        // Find middle using slow and fast pointer
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare first and second half
        while (prev != null) {
            if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}