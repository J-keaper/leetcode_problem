package cn.keaper.review.p98;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.*;

public class Solution {



    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = inOrder(root);
        for (int i = 1; i < inOrder.size(); i++) {
            if(inOrder.get(i) <= inOrder.get(i-1)){
                return false;
            }
        }
        return true;
    }

    List<Integer> inOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(inOrder(root.left));
        res.add(root.val);
        res.addAll(inOrder(root.right));
        return res;
    }

    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Integer prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(prev != null && pop.val <= prev){
                return false;
            }
            prev = pop.val;
            root = pop.right;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root, long min, long max) {
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValidBST2(root.left, min, root.val) && isValidBST2(root.right, root.val, max);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isValidBST(TreeBuilder.buildTree(new Integer[]{})));
        System.out.println(new Solution().isValidBST1(TreeBuilder.buildTree(new Integer[]{})));
        System.out.println(new Solution().isValidBST2(TreeBuilder.buildTree(new Integer[]{})));


        System.out.println(new Solution().isValidBST(TreeBuilder.buildTree(new Integer[]{2,1,3})));
        System.out.println(new Solution().isValidBST1(TreeBuilder.buildTree(new Integer[]{2,1,3})));
        System.out.println(new Solution().isValidBST2(TreeBuilder.buildTree(new Integer[]{2,1,3})));

        System.out.println(new Solution().isValidBST(TreeBuilder.buildTree(new Integer[]{2,1})));
        System.out.println(new Solution().isValidBST1(TreeBuilder.buildTree(new Integer[]{2,1})));
        System.out.println(new Solution().isValidBST2(TreeBuilder.buildTree(new Integer[]{2,1})));

        System.out.println(new Solution().isValidBST(TreeBuilder.buildTree(new Integer[]{2,1,4,null,null,3})));
        System.out.println(new Solution().isValidBST1(TreeBuilder.buildTree(new Integer[]{2,1,4,null,null,3})));
        System.out.println(new Solution().isValidBST2(TreeBuilder.buildTree(new Integer[]{2,1,4,null,null,3})));

        System.out.println(new Solution().isValidBST(TreeBuilder.buildTree(new Integer[]{2,1,4,null,null,5})));
        System.out.println(new Solution().isValidBST1(TreeBuilder.buildTree(new Integer[]{2,1,4,null,null,5})));
        System.out.println(new Solution().isValidBST2(TreeBuilder.buildTree(new Integer[]{2,1,4,null,null,5})));

        System.out.println(new Solution().isValidBST(TreeBuilder.buildTree(new Integer[]{5,1,4,null,null,3,6})));
        System.out.println(new Solution().isValidBST1(TreeBuilder.buildTree(new Integer[]{5,1,4,null,null,3,6})));
        System.out.println(new Solution().isValidBST2(TreeBuilder.buildTree(new Integer[]{5,1,4,null,null,3,6})));

        System.out.println(new Solution().isValidBST(TreeBuilder.buildTree(new Integer[]{5,4,6,null,null,3,7})));
        System.out.println(new Solution().isValidBST1(TreeBuilder.buildTree(new Integer[]{5,4,6,null,null,3,7})));
        System.out.println(new Solution().isValidBST2(TreeBuilder.buildTree(new Integer[]{5,4,6,null,null,3,7})));
    }

}
