package cn.keaper.p111;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right != null){
            return 1 + Integer.min(minDepth(root.left),minDepth(root.right));
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        return 1 + minDepth(root.left);
    }
 }
