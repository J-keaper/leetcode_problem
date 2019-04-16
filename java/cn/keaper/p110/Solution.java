package cn.keaper.p110;

import cn.keaper.tree.integer.TreeBuilder;
import cn.keaper.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Solution {
    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return res;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l - r) > 1){
            res = false;
            return 0;
        }
        return 1 + Integer.max(l,r);
    }


    /**
     * 这种方法会存在重复的树遍历
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced1(root.left) && isBalanced1(root.right) &&
                Math.abs(height1(root.left) - height1(root.right)) <= 1;
    }

    public int height1(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Integer.max(height1(root.left),height1(root.right));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.isBalanced(TreeBuilder.buildTree(new Integer[]{1,2,2,3,3,null,null,4,4})));
        System.out.println(solution.isBalanced(TreeBuilder.buildTree(new Integer[]{1,2,2,3,null,null,3,4,null,null,4})));
    }
}
