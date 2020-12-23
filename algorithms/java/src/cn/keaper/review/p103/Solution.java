package cn.keaper.review.p103;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean order = true;
        while (!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            while (size-- > 0){
                TreeNode poll = queue.poll();
                if(poll != null){
                    if(order) level.add(poll.val);
                    else level.add(0, poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if(!level.isEmpty()){
                res.add(level);
            }
            order = !order;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().zigzagLevelOrder(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7}));
        res.forEach(c -> {
            c.forEach(i -> System.out.print(i + ","));
            System.out.println();
        });
    }

}
