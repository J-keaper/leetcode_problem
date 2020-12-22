package cn.keaper.review.p145;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }


    /**
     * 迭代
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root, prev = null;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();

            if(node.right == null || node.right == prev){
                res.add(node.val);
                prev = node;
                node = null;
            }else {
                stack.push(node);
                node = node.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().postorderTraversal(TreeBuilder.buildTree(new Integer[]{1,null,2,3})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().postorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,null,2,3})).toArray(new Integer[]{})));

        System.out.println(Arrays.toString(new Solution().postorderTraversal(TreeBuilder.buildTree(new Integer[]{})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().postorderTraversal1(TreeBuilder.buildTree(new Integer[]{})).toArray(new Integer[]{})));

        System.out.println(Arrays.toString(new Solution().postorderTraversal(TreeBuilder.buildTree(new Integer[]{1})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().postorderTraversal1(TreeBuilder.buildTree(new Integer[]{1})).toArray(new Integer[]{})));

        System.out.println(Arrays.toString(new Solution().postorderTraversal(TreeBuilder.buildTree(new Integer[]{1,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().postorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,2})).toArray(new Integer[]{})));

        System.out.println(Arrays.toString(new Solution().postorderTraversal(TreeBuilder.buildTree(new Integer[]{1,null,2})).toArray(new Integer[]{})));
        System.out.println(Arrays.toString(new Solution().postorderTraversal1(TreeBuilder.buildTree(new Integer[]{1,null,2})).toArray(new Integer[]{})));
    }
}
