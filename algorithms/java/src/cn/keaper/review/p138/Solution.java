package cn.keaper.review.p138;

public class Solution {

    public Node copyRandomList(Node head) {
        Node node = head;
        while (node != null){
            Node copy = new Node(node.val);
            Node next = node.next;
            node.next = copy;
            copy.next = next;
            node = next;
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


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
