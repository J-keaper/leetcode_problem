package cn.keaper.review.p108;

import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;

import java.util.Arrays;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if(l > r){
            return null;
        }
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        Arrays.asList(
                new int[]{-10,-3,0,5,9},
                new int[]{1,2,3,4,5},
                new int[]{1,2,3,4,5,6},
                new int[]{1,2,3,4,5,6,7},
                new int[]{1,2,3,4,5,6,7,8},
                new int[]{1,2,3,4,5,6,7,8,9}
                ).forEach(c -> {
            TreePrinter.printTree(new Solution().sortedArrayToBST(c));
            System.out.println();
        });
    }
}
