import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LRUCache {

    private final Map<Integer, DoubleLinkedListNode> keys;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private final int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        keys = new HashMap<>(capacity);
    }

    public int get(int key) {

        if(!keys.containsKey(key)) {
            return -1;
        }

        DoubleLinkedListNode node = keys.get(key);
        // update the order
        removeNode(node);
        setHead(node);
        return node.val;
    }

    public void set(int key, int value) {

        if(keys.containsKey(key)) {
            // update the value
            DoubleLinkedListNode node = keys.get(key);
            node.val = value;

            // update the order
            removeNode(node);
            setHead(node);
        } else {
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            if(keys.size() == capacity) {
                // remove the least recently used node
                removeTail();
            }
            // simply put the node
            keys.put(key, node);

            // update the order
            setHead(node);
        }
    }

    private void removeTail() {
        if(tail == null) {
            return;
        }

        keys.remove(tail.key);
        tail = tail.prev;
        if(tail != null) {
            tail.next = null;
        }
    }

    private void removeNode(DoubleLinkedListNode node) {

        DoubleLinkedListNode next = node.next;
        DoubleLinkedListNode prev = node.prev;

        if(prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if(next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }

    private void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.prev = null;

        if(head != null) {
            head.prev = node;
        }

        head = node;

        if(tail == null) {
            tail = node;
        }
    }

    private class DoubleLinkedListNode {

        private DoubleLinkedListNode prev;
        private DoubleLinkedListNode next;
        private int key;
        private int val;

        public DoubleLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(1);

        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

//        for(int val = 1; val <= 3; val++) {
//            cache.set(val, val);
//        }
//
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));

        System.out.println();
    }
}
