package Interview.LRUCache;

import ArrayorList.LRUCache;

import java.util.HashMap;

public class LRUIntInt {
    private static class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void moveTohead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public void LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }

        this.moveTohead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveTohead(node);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLinkedNode node = head.post;
        while (node.post != null) {
            sb.append(node.key).append(':').append(node.value).append("-->");
            node = node.post;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUIntInt lruIntInt = new LRUIntInt();
        lruIntInt.LRUCache(3);
        lruIntInt.put(1, 1);
        lruIntInt.put(2, 2);
        lruIntInt.put(3, 3);
        lruIntInt.put(4, 4);
        System.out.println(lruIntInt);
    }
}
