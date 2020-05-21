package cn.keaper.p103;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Solution {

    /**
     * 层序遍历，每遍历一层调整一下插入结果的顺序
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node != null){
                    if((level & 1) == 1){
                        levelList.add(0, node.val);
                    }else {
                        levelList.add(node.val);
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            level++;
            if(!levelList.isEmpty()){
                res.add(levelList);
            }
        }
        return res;
    }

}
