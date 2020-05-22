package cn.keaper.p105;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if(pl > pr){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        if(pl == pr){
            return root;
        }
        int leftLen = 0;
        while (il + leftLen <= ir && inorder[il + leftLen] != root.val){
            leftLen++;
        }
        root.left = buildTree(preorder, pl + 1, pl + leftLen, inorder, il, il + leftLen - 1);
        root.right = buildTree(preorder, pl + leftLen + 1, pr, inorder, il + leftLen + 1, ir);
        return root;
    }

}
