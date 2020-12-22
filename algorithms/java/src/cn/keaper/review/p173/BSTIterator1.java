package cn.keaper.review.p173;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 模拟中序遍历的递归形式
 */
public class BSTIterator1 {

    private Deque<TreeNode> stack;


    public BSTIterator1(TreeNode root) {
        stack = new LinkedList<>();
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }


    public int next() {
        int nextVal = stack.peek().val;
        TreeNode node = stack.poll();
        node = node.right;
        while (node != null){
            stack.push(node);
            node = node.left;
        }
        return nextVal;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        BSTIterator1 iterator = new BSTIterator1(TreeBuilder.buildTree(new Integer[]{7,3,15,null,null,9,20}));
        System.out.println(iterator.next());    // 返回 3
        System.out.println(iterator.next());    // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false



    }
}
