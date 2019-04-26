package cn.keaper.p101;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }


    /**
     * judge two tree if is symmetric
     */
    public boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val
                && isSymmetric(root1.left,root2.right)
                && isSymmetric(root1.right,root2.left);
    }
}
