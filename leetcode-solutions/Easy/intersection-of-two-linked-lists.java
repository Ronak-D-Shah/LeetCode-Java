/**
 * LeetCode Problem: 160. Intersection of Two Linked Lists
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Approach:
 * - Use two pointers, one for each list (A and B).
 * - Traverse both lists. When a pointer reaches the end of a list, redirect it to the head of the other list.
 * - If the lists intersect, the pointers will meet at the intersection node after at most m + n steps.
 * - If they do not intersect, both pointers will reach null at the same time.
 *
 * Why this works:
 * - Aligns the pointers after traversing equal combined lengths (m + n).
 * - Ensures O(1) space and O(m + n) time without modifying the list.
 * 
 * Constraints:
 * - Lists do not contain cycles.
 * - Nodes before and after the intersection remain unchanged.
 *
 * Time Complexity: O(m + n), where m and n are lengths of listA and listB
 * Space Complexity: O(1) – constant space
 */

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; 
    }
}
