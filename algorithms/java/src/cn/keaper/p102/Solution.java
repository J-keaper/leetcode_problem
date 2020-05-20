package cn.keaper.p102;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode top = queue.poll();
                if(top != null){
                    levelList.add(top.val);
                    queue.add(top.left);
                    queue.add(top.right);
                }
            }
            if(!levelList.isEmpty()){
                res.add(levelList);
            }
        }
        return res;
    }

}
