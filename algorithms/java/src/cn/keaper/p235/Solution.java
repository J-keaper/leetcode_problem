package cn.keaper.p235;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != p && root != q){
            if((p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)){
                return root;
            }
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
        }
        return root;
    }
}
