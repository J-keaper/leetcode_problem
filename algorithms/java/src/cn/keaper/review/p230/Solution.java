package cn.keaper.review.p230;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

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


    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root).get(k - 1);
    }


    public int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(--k == 0) return pop.val;
            root = pop.right;
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(TreeBuilder.buildTree(new Integer[]{3,1,4,null,2}),2));
        System.out.println(new Solution().kthSmallest1(TreeBuilder.buildTree(new Integer[]{3,1,4,null,2}),2));

        System.out.println(new Solution().kthSmallest(TreeBuilder.buildTree(new Integer[]{5,3,6,2,4,null,null,1}),3));
        System.out.println(new Solution().kthSmallest1(TreeBuilder.buildTree(new Integer[]{5,3,6,2,4,null,null,1}),3));
    }
}
