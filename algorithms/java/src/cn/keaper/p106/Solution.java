package cn.keaper.p106;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if(il > ir){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pr]);
        if (il == ir){
            return root;
        }
        int leftLen = 0;
        while (il + leftLen <= ir && inorder[il + leftLen] != root.val){
            leftLen++;
        }
        root.left = buildTree(inorder, il, il + leftLen - 1, postorder, pl, pl + leftLen - 1);
        root.right = buildTree(inorder, il + leftLen + 1, ir, postorder, pl + leftLen,  pr - 1);
        return root;
    }

}
