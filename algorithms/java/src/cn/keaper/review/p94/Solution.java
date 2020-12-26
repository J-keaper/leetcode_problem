package cn.keaper.review.p94;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.*;

public class Solution {

    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    /**
     * 迭代
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }




    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().inorderTraversal(TreeBuilder.buildTree(new Integer[]{1,null,2,3})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,null,2,3})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal(TreeBuilder.buildTree(new Integer[]{})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal1(TreeBuilder.buildTree(new Integer[]{})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal(TreeBuilder.buildTree(new Integer[]{1})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal1(TreeBuilder.buildTree(new Integer[]{1})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal(TreeBuilder.buildTree(new Integer[]{1,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal(TreeBuilder.buildTree(new Integer[]{1,null,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().inorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,null,2})).toArray(new Integer[]{})));

    }
}