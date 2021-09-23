package calculate.src.main.java.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用hash算法的LRU
 */
public class HashLRU {

    private class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;

    public HashLRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode(-1, -1);
        this.tail = new DLinkedNode(-1, -1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addNodeAtHead(node);
            return;
        }
        if (size == capacity) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        DLinkedNode newNode = new DLinkedNode(key, value);
        cache.put(key, newNode);
        addNodeAtHead(newNode);
        size++;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNodeAtHead(node);
        return node.value;
    }

    public void remove(int key) {
        if (size == 0) {
            return;
        }
        DLinkedNode node = cache.get(key);
        if (node != null) {
            removeNode(node);
            size--;
        }
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNodeAtHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    public void sysOut() {
        for (Map.Entry<Integer, DLinkedNode> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + "              " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        HashLRU hashLRU = new HashLRU(4);
        hashLRU.put(1, 1);
        hashLRU.put(2, 2);
        hashLRU.put(3, 3);
        hashLRU.put(4, 4);
        System.out.println(hashLRU.get(1));
        hashLRU.put(5, 5);
        hashLRU.sysOut();
    }

}
