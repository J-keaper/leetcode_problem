package cn.keaper.review.p146;

import java.util.HashMap;

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node value = map.get(key);
        moveToFirst(value);
        return value.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToFirst(node);
        }else {
            if(map.size() >= capacity){
                Node node = tail.prev;
                remove(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertFirst(node);
        }
    }


    void moveToFirst(Node node){
        remove(node);
        insertFirst(node);
    }

    void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void insertFirst(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }



    static class Node{
        int key;
        int value;
        Node prev;
        Node next;


        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));;    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));;    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));;    // return -1 (not found)
        System.out.println(lRUCache.get(3));;    // return 3
        System.out.println(lRUCache.get(4));;    // return 4


        lRUCache = new LRUCache(1);
        lRUCache.put(2,1);
        System.out.println(lRUCache.get(2));
        lRUCache.put(3,2);
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
    }
}
