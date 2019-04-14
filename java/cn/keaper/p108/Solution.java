package cn.keaper.p108;

import cn.keaper.tree.integer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution {

    /**
     * split in the middle
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums,int l, int r){
        if(r - l < 0){
            return null;
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = sortedArrayToBST(nums,l,m - 1);
        root.right = sortedArrayToBST(nums,m + 1,r);
        return root;
    }


    private static void printTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                System.out.print(node.val + ",");
            }else {
                System.out.print("null,");
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printTree(solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1,2,3}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1,2}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{}));
        System.out.println();
    }

}
