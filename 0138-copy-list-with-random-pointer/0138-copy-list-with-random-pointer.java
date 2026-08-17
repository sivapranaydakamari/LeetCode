/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();
        int idx = 0;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);

    }
}