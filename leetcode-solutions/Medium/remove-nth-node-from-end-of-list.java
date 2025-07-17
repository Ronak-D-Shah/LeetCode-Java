/**
 * LeetCode: 19. Remove Nth Node From End of List
 * Difficulty: Medium
 * 
 * Approach:
 * - Use a dummy node before head to simplify deletion
 * - Move fast pointer n steps ahead
 * - Then move both fast and slow together until fast reaches end
 * - Now slow is at (n+1)th from the end, so remove slow.next
 * 
 * Time Complexity: O(L), where L is the length of the list
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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return dummy.next;
    }
}

//[1,2,3,4,5]
// dum1 = 5
// dum2 = 3