package cn.keaper.review.p106;

import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }


    public TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl ,int pr) {
        if(il > ir || pl > pr){
            return null;
        }
        int pos = indexOf(inorder, il, ir, postorder[pr]);
        int leftLen = pos - il;
        TreeNode root = new TreeNode(postorder[pr]);
        root.left = buildTree(inorder, il, il + leftLen - 1, postorder, pl, pl + leftLen - 1);
        root.right = buildTree(inorder, il + leftLen + 1, ir, postorder, pl + leftLen, pr - 1);
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
        TreePrinter.printTree(new Solution().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }

}
