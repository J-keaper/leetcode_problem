package cn.keaper.review.p116;

import java.util.*;

public class Solution {

    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                Node poll = queue.poll();
                poll.next = size == 0 ? null : queue.peek();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }



    public Node connect1(Node root) {
        Node node = root, head = new Node();
        while (node != null){
            Node tail = head;
            while (node != null){
                if(node.left != null){
                    tail.next = node.left;
                    tail = tail.next;
                }
                if(node.right != null){
                    tail.next = node.right;
                    tail = tail.next;
                }
                node = node.next;
            }
            if(tail == head) break;
            node = head.next;
        }
        return root;
    }


    public static void main(String[] args) {
        List<Integer[]> cases = Arrays.asList(
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
}