package cn.keaper.p129;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class Solution {

    private int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        if(root == null){
            return sum;
        }
        dfs(root);
        return sum;
    }

    void dfs(TreeNode root){
        if(root.left == null && root.right == null){
            sum += root.val;
        }
        if(root.left != null){
            root.left.val = root.left.val + root.val * 10;
            dfs(root.left);
        }
        if(root.right != null){
            root.right.val = root.right.val + root.val * 10;
            dfs(root.right);
        }
    }
}
