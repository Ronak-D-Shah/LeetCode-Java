/**
 * LeetCode Problem: 138. Copy List with Random Pointer
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Approach:
 * - We use a HashMap to keep a mapping between original nodes and their corresponding copied nodes.
 * - First pass: Create all new nodes and store them in the map.
 * - Second pass: Assign the `next` and `random` pointers to the copied nodes using the map.
 *
 * Why this works:
 * - Since each node can have random pointers pointing anywhere (even back or forward),
 *   a HashMap helps maintain a reference of the original node → copied node.
 * - This allows us to safely assign all `random` and `next` pointers without confusion.
 *
 * Time Complexity: O(n), where n is the number of nodes in the list
 * Space Complexity: O(n), for the HashMap storing node mapping
 */

import java.util.HashMap;

class Solution {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node current = head;
        HashMap <Node, Node> map = new HashMap <>();

        while (current != null) {
            map.put (current, new Node (current.val));
            current = current.next;
        }

        current = head;

        while (current != null) {
            Node copy = map.get (current);
            copy.next = map.get (current.next);
            copy.random = map.get (current.random);
            current = current.next;
        }

        return map.get (head);
    }
}