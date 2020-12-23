package cn.keaper.review.p110;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

public class Solution {

    private boolean balance;

    public boolean isBalanced(TreeNode root) {
        balance = true;
        height(root);
        return balance;
    }

    int height(TreeNode root) {
        if (root == null || !balance) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            balance = false;
        }
        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isBalanced(TreeBuilder.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(new Solution().isBalanced(TreeBuilder.buildTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        System.out.println(new Solution().isBalanced(TreeBuilder.buildTree(new Integer[]{})));
        System.out.println(new Solution().isBalanced(TreeBuilder.buildTree(new Integer[]{1})));
        System.out.println(new Solution().isBalanced(TreeBuilder.buildTree(new Integer[]{1, 2})));
        System.out.println(new Solution().isBalanced(TreeBuilder.buildTree(new Integer[]{1, 2, null, 3})));

    }
}
