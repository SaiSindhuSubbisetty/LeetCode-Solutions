import java.util.HashMap;
class LRUCache {
    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key,int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final HashMap<Integer,Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
         // initialize dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value; //updating the value
            remove(node);
            insertAtHead(node);
        }
        else{
            if(map.size() == capacity)
            {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            insertAtHead(newNode);
        }
        
    }

    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node)
    {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */