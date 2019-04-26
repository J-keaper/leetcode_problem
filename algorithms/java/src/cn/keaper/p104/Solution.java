package cn.keaper.p104;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Integer.max(maxDepth(root.left),maxDepth(root.right));
    }
}