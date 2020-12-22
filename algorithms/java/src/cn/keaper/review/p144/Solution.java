package cn.keaper.review.p144;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }


    /**
     * 迭代
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().preorderTraversal(TreeBuilder.buildTree(new Integer[]{1,null,2,3})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,null,2,3})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal(TreeBuilder.buildTree(new Integer[]{})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal1(TreeBuilder.buildTree(new Integer[]{})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal(TreeBuilder.buildTree(new Integer[]{1})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal1(TreeBuilder.buildTree(new Integer[]{1})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal(TreeBuilder.buildTree(new Integer[]{1,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal(TreeBuilder.buildTree(new Integer[]{1,null,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().preorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,null,2})).toArray(new Integer[]{})));
    }
}
