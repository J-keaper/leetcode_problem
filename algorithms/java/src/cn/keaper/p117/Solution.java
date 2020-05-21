package cn.keaper.p117;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Solution {

    /**
     * 使用队列进行层次遍历，栈顶元素即为临近的next
     * @see cn.keaper.p116.Solution#connect
     */
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node top = queue.poll();
                if(i < count - 1){
                    top.next = queue.peek();
                }
                if(top.left != null){
                    queue.add(top.left);
                }
                if(top.right != null){
                    queue.add(top.right);
                }
            }
        }
        return root;
    }

    /**
     * 遍历每层节点时，将下一层的节点连接起来
     * @see cn.keaper.p116.Solution#connect2
     */
    public Node connect2(Node root) {
        Node cur = root, nextHead = new Node(); // cur表示遍历每一层时的节点，nextHead表示当前层下一层的头节点
        while (cur != null){
            Node nextTail = nextHead;  // 下一层的尾节点
            while (cur != null){  // 遍历每一层节点
                if(cur.left != null){   // 将左孩子添加到下一层的链表中
                    nextTail.next = cur.left;
                    nextTail = nextTail.next;
                }
                if(cur.right != null){   // 将右孩子添加到下一层的链表中
                    nextTail.next = cur.right;
                    nextTail = nextTail.next;
                }
                cur = cur.next;  // 遍历一个节点，next已经在上一层设置过了
            }
            if(nextTail == nextHead) break; // 下一层没有节点，退出
            cur = nextHead.next;  // 准备遍历下一层节点
        }
        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
