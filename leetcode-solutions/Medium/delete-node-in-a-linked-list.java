/**
 * LeetCode Problem: 237. Delete Node in a Linked List
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * Approach:
 * - We're only given the node to be deleted, not the head of the list.
 * - Since we can't access the previous node, we copy the value from the next node into the current one.
 * - Then we bypass the next node by pointing current node's `next` to `next.next`.
 * - This effectively removes the next node, but the current node takes on its value.
 * 
 * Constraints:
 * - The node to delete is not the tail node.
 * - All values in the list are unique.
 *
 * Time Complexity: O(1) – constant time since we do a fixed number of operations.
 * Space Complexity: O(1) – no extra space used.
 */

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void deleteNode(ListNode node) {
        // Copy the value from the next node into this node
        node.val = node.next.val;

        // Bypass the next node
        node.next = node.next.next;
    }
}
