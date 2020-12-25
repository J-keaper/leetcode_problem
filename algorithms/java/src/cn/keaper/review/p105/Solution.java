package cn.keaper.review.p105;

import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    public TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il ,int ir) {
        if(pl > pr || il > ir){
            return null;
        }
        int pos = indexOf(inorder, il, ir, preorder[pl]);
        int leftLen = pos - il;
        TreeNode root = new TreeNode(preorder[pl]);
        root.left = buildTree(preorder, pl + 1, pl + leftLen, inorder, il, il + leftLen - 1);
        root.right = buildTree(preorder, pl + leftLen + 1, pr, inorder, il + leftLen + 1, ir);
        return root;
    }

    private int indexOf(int[] order, int l, int r, int target){
        for (int i = l; i <= r; i++) {
            if(order[i] == target){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        TreePrinter.printTree(new Solution().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

}
