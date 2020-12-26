package cn.keaper.p111;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right != null){
            return 1 + Integer.min(minDepth(root.left),minDepth(root.right));
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        return 1 + minDepth(root.left);
    }

    /**
     * BFS
     */
    public int minDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null){
                    return level;
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            level++;
        }
        return level;
    }
 }
