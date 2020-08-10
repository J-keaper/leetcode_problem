package cn.keaper.p98;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.Stack;

public class Solution {



    /**
     * 一棵树是BST需要满足如下条件：
     * 1. 左子树和右子树都是BST
     * 2. 根结点的值大于左子树中的所有节点的值，即大于左子树中的最大值
     * 3. 根结点的值小于右子树中的所有节点的值，即小于右子树中的最小值
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean validLeft = root.left == null || max(root.left) < root.val;
        boolean validRight = root.right == null || min(root.right) > root.val;
        return validLeft && validRight && isValidBST(root.left) && isValidBST(root.right);
    }


    private int min(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        if(root.left != null && root.right != null){
            return Integer.min(root.val, Integer.min(min(root.left), min(root.right)));
        }
        if(root.left != null){
            return Integer.min(min(root.left), root.val);
        }
        return Integer.min(min(root.right), root.val);
    }


    private int max(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        if(root.left != null && root.right != null){
            return Integer.max(root.val, Integer.max(max(root.left), max(root.right)));
        }
        if(root.left != null){
            return Integer.max(max(root.left), root.val);
        }
        return Integer.max(max(root.right), root.val);
    }


    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 对于一颗树，维护一个区间范围，表示这棵树中的节点的合法范围
     * 如果根结点的值不在区间范围内则不是一颗BST，如果在的话，
     * 递归判断左子树和右子树，同时更新区间范围
     */
    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if(root == null) {
            return true;
        }
        if(root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    /**
     * BST的中序遍历一定是升序的，遍历过程中如果不是升序则不满足
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;  // 中序遍历序列的前一个元素
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre >= root.val){
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }



}
