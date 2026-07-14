// Last updated: 14/07/2026, 16:16:33
class Solution {
    public Node copyRandomList(Node head) {
        Map <Node, Node> m = new HashMap<>();
        Node t = head;
        while(t!=null) {
            m.put(t, new Node(t.val));
            t = t.next;
        }
        Node curr = head;

        while(curr != null) {
            Node copy = m.get(curr);
            copy.next = m.get(curr.next);
            copy.random = m.get(curr.random);
            curr = curr.next;
        }
        return m.get(head);
    }
}