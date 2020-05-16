package cn.keaper.p146;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * 原理类似 LinkedHashMap
 * 使用两种数据结构，双向链表和Map
 * Map用来实现快速查询
 * 双向链表用来维护访问先后顺序，实现快速淘汰元素，访问元素会将元素添加至链表头部，淘汰元素从链表末尾淘汰
 *
 */
class LRUCache {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(),tail = new Node(); // 用来维护一个链表，最常访问的在最前面

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.before = null;
        head.after = tail;
        tail.before = head;
        tail.after = null;
    }

    /**
     * 访问之后需要将访问到的节点移动到链表头部
     */
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node value = map.get(key);
        moveToHead(value);
        return value.value;
    }

    /**
     * 如果存在需要替换旧值，并移动至链表头部
     * 如果不存在，则需要新建节点加入，如果容量满了，先进行淘汰
     * 插入节点至头部
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            moveToHead(old);
            return;
        }
        if(map.size() >= capacity){
            removeTail();
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addToHead(node);
    }

    /**
     * 移动一个节点到头部
     * 1. 删除当前节点
     * 2. 将当前节点加到头部
     */
    private void moveToHead(Node node){
        node.before.after = node.after;
        node.after.before = node.before;

        node.after = head.after;
        head.after.before = node;
        head.after = node;
        node.before = head;
    }

    /**
     * 删除末尾的节点
     */
    private void removeTail(){
        remove(tail.before);
    }

    /**
     * 从链表中删除一个节点
     */
    private void remove(Node node){
        node.before.after = node.after;
        node.after.before = node.before;
        map.remove(node.key);
    }

    /**
     * 添加一个节点到链表头部
     */
    private void addToHead(Node node){
        node.after = head.after;
        head.after.before = node;
        head.after = node;
        node.before = head;
        map.put(node.key, node);
    }


    public static class Node {
        int key, value;
        Node before, after;

        Node(){}
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
}