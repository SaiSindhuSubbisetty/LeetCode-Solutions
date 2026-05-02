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
    HashMap<Node,Node> visitedList = new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return null;
        }
        if(this.visitedList.containsKey(head))
        {
            return this.visitedList.get(head);
        }
        Node node = new Node(head.val,null,null);
        this.visitedList.put(head,node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
        
    }
}