/**
 * LeetCode: 21. Merge Two Sorted Lists
 * Difficulty: Easy
 * 
 * Approach:
 * - Use a dummy node to start the merged list
 * - Use a pointer to compare and attach smaller nodes from list1 and list2
 * - Continue until one list is exhausted
 * - Attach the remaining nodes from the other list
 * 
 * Time Complexity: O(m + n) where m and n are lengths of list1 and list2
 * Space Complexity: O(1) — in-place merging (ignoring output list)
 */

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            } else if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }
        if (list1 == null) {
            curr.next = list2;
        }
        if (list2 == null) {
            curr.next = list1;
        }
        return dummy.next;
    }
}