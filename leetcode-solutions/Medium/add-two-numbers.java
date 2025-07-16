/**
 * LeetCode Problem: 2. Add Two Numbers
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/add-two-numbers/
 *
 * Approach:
 * - Traverse both linked lists.
 * - Add the values of corresponding nodes plus carry.
 * - Use a dummy head to simplify list creation.
 * - Continue until both lists are done and carry is 0.
 *
 * Time Complexity: O(max(m, n)), where m and n are lengths of l1 and l2
 * Space Complexity: O(max(m, n)) for the result list
 */

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode dummy = res;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            dummy.next = new ListNode(sum % 10, null);
            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return res.next;
    }
}