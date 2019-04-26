package cn.keaper.p108;

import cn.keaper.utils.tree.integer.TreeNode;

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

}
