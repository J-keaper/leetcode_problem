package cn.keaper.review.p101;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2,2,3,4,4,3})));
        System.out.println(new Solution().isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2,2,null,3,null,3})));
    }
}