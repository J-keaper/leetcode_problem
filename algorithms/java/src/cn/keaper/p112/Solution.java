package cn.keaper.p112;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class Solution {

    /**
     * 通常递归中需要判断叶子节点时，左右子树不能同等对待，因为子树为null时不是叶子节点
     */


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        int diff = sum - root.val;
        if(root.left != null && root.right != null){
            return hasPathSum(root.left,diff) || hasPathSum(root.right,diff);
        }
        if(root.left == null){
            return hasPathSum(root.right,diff);
        }
        return hasPathSum(root.left,diff);
    }
}
