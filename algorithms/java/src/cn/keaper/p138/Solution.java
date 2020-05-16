package cn.keaper.p138;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class Solution {

    /**
     * 1. 首先将每个元素复制一遍插入当前元素之后
     * 2. 根据原元素的random设置复制出来的元素的random值
     * 3. 分离为两个链表
     */
    public Node copyRandomList(Node head) {
        Node node = head;
        while (node != null){
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }

        node = head;
        while (node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        Node dummy = new Node(-1);
        dummy.next = head;

        Node prev = dummy, cur = dummy.next;
        while (cur != null){
            prev.next = cur.next;
            cur.next = cur.next.next;

            prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }

}
