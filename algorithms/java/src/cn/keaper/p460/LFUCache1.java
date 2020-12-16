package cn.keaper.p460;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 首先需要一个Map用来记录 key -> value
 * 另外显然，我们需要记录每个元素的访问次数
 * 淘汰的时候我们需要知道淘汰哪个元素，所以我们需要记录访问的最小次数
 *
 * 由于可能存在不同的key具有相同的访问次数，对于这种情况又要求使用LRU算法删除
 *
 * 所以我们用另外一个map来记录访问次数到元素的映射，元素可能有多个，并且多个元素要以LRU方式组织
 * 淘汰时淘汰最小访问次数对应的LRU列表的的最后一个节点即可
 */
public class LFUCache1 {

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Map<Integer, DList> freq = new HashMap<>();
    private int minFreq = Integer.MAX_VALUE;

    public LFUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(capacity == 0){
            return -1;
        }
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        afterAccess(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            afterAccess(node);
        }else {
            if(map.size() >= capacity){
                DList minFreqList = freq.get(minFreq);
                Node toRemove = minFreqList.tail.before;
                minFreqList.removeLast();
                map.remove(toRemove.key);
            }
            Node node = new Node(key, value, 1);
            afterInsert(node);
            map.put(key, node);
        }
    }

    void afterInsert(Node node){
        freq.putIfAbsent(node.count, new DList());
        freq.get(node.count).offerFirst(node);
        minFreq = 1;
    }

    void afterAccess(Node node){
        DList oldList = freq.get(node.count);
        oldList.remove(node);
        if(oldList.isEmpty() && minFreq == node.count){
            minFreq++;
        }
        node.count++;
        freq.putIfAbsent(node.count, new DList());
        freq.get(node.count).offerFirst(node);
    }

    static class DList{
        Node head = new Node(),tail = new Node();

        public DList() {
            head.before = null;
            head.after = tail;
            tail.before = head;
            tail.after = null;
        }

        private boolean isEmpty(){
            return head.after == tail;
        }

        private void offerFirst(Node node){
            node.after= head.after;
            node.before = head;
            head.after.before = node;
            head.after = node;
        }

        private void removeLast(){
            remove(tail.before);
        }

        private void remove(Node node){
            node.before.after = node.after;
            node.after.before = node.before;
        }

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
