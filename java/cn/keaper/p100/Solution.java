package cn.keaper.p100;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * build tree by the way like level traverse
     */
    public static TreeNode buildTree(Integer[] tree){
        if (tree.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.left = new TreeNode(tree[index]);
                queue.add(current.left);
            }else {
                current.left = null;
            }
            index++;

            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.right = new TreeNode(tree[index]);
                queue.add(current.right);
            }else {
                current.right = null;
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nodeList1 = new Integer[]{};
        Integer[] nodeList2 = new Integer[]{1};
        TreeNode tree1 = buildTree(nodeList1);
        TreeNode tree2 = buildTree(nodeList2);
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(tree1,tree2));
    }
}
