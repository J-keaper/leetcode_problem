package cn.keaper.p100;

import cn.keaper.tree.integer.TreeBuilder;
import cn.keaper.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    public static void main(String[] args) {
        Integer[] nodeList1 = new Integer[]{};
        Integer[] nodeList2 = new Integer[]{1};
        TreeNode tree1 = TreeBuilder.buildTree(nodeList1);
        TreeNode tree2 = TreeBuilder.buildTree(nodeList2);
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(tree1,tree2));
    }
}
