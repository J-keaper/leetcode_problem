package cn.keaper.p199;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class Solution {

    /**
     * 使用BFS层次遍历，每层只保留最后一个值
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Integer last = null;
            for (int i = 1 ; i <= size ; i ++){
                TreeNode top = queue.poll();
                if(top != null){
                    last = top.val;
                    queue.add(top.left);
                    queue.add(top.right);
                }
            }
            if(last != null){
                res.add(last);
            }
        }
        return res;
    }

}
