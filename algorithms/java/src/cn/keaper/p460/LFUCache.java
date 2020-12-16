package cn.keaper.p460;


import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(), tail = new Node();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head.before = null;
        head.after = tail;
        tail.before = head;
        tail.after = null;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        incrCountAndMove(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            incrCountAndMove(node);
        }else {
            if(map.size() >= capacity){
                Node last = tail.before;
                remove(last);
                map.remove(last.key);
            }
            Node node = new Node(key, value, 0);
            addToTail(node);
            incrCountAndMove(node);
            map.put(key, node);
        }
    }

    private void incrCountAndMove(Node node){
        node.count++;
        Node cur = node;
        while (cur != head && node.count >= cur.count){
            cur = cur.before;
        }
        if(cur == node){
            return;
        }
        remove(node);

        node.before = cur;
        node.after = cur.after;
        cur.after.before = node;
        cur.after = node;
    }

    private void addToTail(Node node){
        node.before = tail.before;
        node.after = tail;
        tail.before.after = node;
        tail.before = node;
    }


    private void remove(Node node){
        node.before.after = node.after;
        node.after.before = node.before;
    }

    static class Node{
        int key, value, count;
        Node before, after;

        public Node() {
        }

        public Node(int key, int value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }

        public Node(int key, int value, int count, Node before, Node after) {
            this.key = key;
            this.value = value;
            this.count = count;
            this.before = before;
            this.after = after;
        }
    }
}
