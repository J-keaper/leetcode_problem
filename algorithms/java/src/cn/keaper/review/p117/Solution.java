package cn.keaper.review.p117;

import cn.keaper.utils.tree.integer.TreeNode;
import com.sun.tools.corba.se.idl.constExpr.Not;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                Node poll = queue.poll();
                poll.next = size > 0 ? queue.peek() : null;
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }


    public Node connect1(Node root) {
        Node node = root, nextHead = new Node(-1);
        while (node != null){
            Node nextTail = nextHead;
            while (node != null){
                if(node.left != null){
                    nextTail.next = node.left;
                    nextTail = nextTail.next;
                }
                if(node.right != null){
                    nextTail.next = node.right;
                    nextTail = nextTail.next;
                }
                node = node.next;
            }
            if(nextHead == nextTail) break;
            node = nextHead.next;
        }
        return root;
    }



    public static void main(String[] args) {
        List<Integer[]> cases = Arrays.asList(
                new Integer[]{1,2,3,4,5,null,7},
                new Integer[]{1,2,3,4,5,6,7},
                new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}
        );

        cases.forEach(c -> {
            Node root = Node.buildTree(c);
            new Solution().connect(root);
            System.out.println(root);
        });

        cases.forEach(c -> {
            Node root = Node.buildTree(c);
            new Solution().connect1(root);
            System.out.println(root);
        });
    }
}


class Node {
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
    
    public static Node buildTree(Integer[] tree){
        if (tree.length == 0) {
            return null;
        }
        Node root = new Node(tree[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.left = new Node(tree[index]);
                queue.add(current.left);
            }else {
                current.left = null;
            }
            index++;

            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.right = new Node(tree[index]);
                queue.add(current.right);
            }else {
                current.right = null;
            }
            index++;
        }
        return root;
    }
};