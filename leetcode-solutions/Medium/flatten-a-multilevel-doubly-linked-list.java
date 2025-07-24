/**
 * LeetCode Problem: 430. Flatten a Multilevel Doubly Linked List
 * Difficulty: Medium
 *
 * Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * Approach:
 * - Use an iterative Depth-First Search approach with a stack.
 * - Traverse the list with a pointer. If a node has a child:
 *   - Push the node's next onto a stack (if it exists) to reconnect later.
 *   - Connect the current node to its child and nullify the child pointer.
 * - When reaching the end of a level and the stack is not empty,
 *   pop from the stack and continue the traversal.
 *
 * Time Complexity: O(n), where n is the total number of nodes in all levels.
 * Space Complexity: O(n), in the worst case we store all next pointers on the stack.
 */
import java.util.*;

class Solution {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        // Node dummy = new Node(0);
        // dummy = dummy.next;
        // Node child = dummy.child;
        // Node next = dummy.next;

        // if (child != null) {
        //     dummy.next = child;
        //     child = dummy.child;
        // }

        // return head;

        if (head == null) return head;

        Stack<Node> stack = new Stack<>();

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                // curr = curr.next;
            }
            if (curr.next == null && !stack.isEmpty()) {
                Node currFromStack = stack.pop();
                curr.next = currFromStack;
                currFromStack.prev = curr;
                // curr = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}