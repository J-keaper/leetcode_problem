package cn.keaper.p101;

import java.util.LinkedList;
import java.util.Queue;

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
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{})));
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{1})));
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{1,2,2})));
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{1,2})));
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{1,2,3})));
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{1,2,2,3,4,4,3})));
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{1,2,2,3,null,null,3})));
        System.out.println(solution.isSymmetric(buildTree(new Integer[]{1,2,2,3,null,null,3,1})));
    }
}
