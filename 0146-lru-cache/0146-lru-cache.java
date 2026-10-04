import java.util.HashMap;

class LRUCache {

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;

    HashMap<Integer, Node> map = new HashMap<>();

    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Add node at the beginning
    // Beginning = MRU
    public void add(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

        size++;
    }

    // Remove node from the list
    public void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Node is recently used,
        // so move it to MRU position
        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Remove from current position
            remove(node);

            // Update value
            node.value = value;

            // Move to MRU position
            add(node);

            return;
        }

        // Key doesn't exist
        Node newnode = new Node(key, value);

        // Space available
        if (size < capacity) {

            add(newnode);
            map.put(key, newnode);
        }

        // Cache is full
        else {

            // Last node before tail = LRU
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);

            // New node becomes MRU
            add(newnode);
            map.put(key, newnode);
        }
    }
}