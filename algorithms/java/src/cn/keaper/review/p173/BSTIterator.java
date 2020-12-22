package cn.keaper.review.p173;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    private List<Integer> inOrder = new ArrayList<>();
    private int index;

    public BSTIterator(TreeNode root) {
        index = 0;
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        inOrder.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return inOrder.get(index++);
    }

    public boolean hasNext() {
        return index < inOrder.size();
    }

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(TreeBuilder.buildTree(new Integer[]{7,3,15,null,null,9,20}));
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
