package cn.keaper.review.p102;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            while (!queue.isEmpty() && size-- > 0){
                TreeNode poll = queue.poll();
                if(poll != null){
                    level.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if(!level.isEmpty()){
                res.add(level);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().levelOrder(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7}));
        res.forEach(c -> {
            c.forEach(i -> System.out.print(i + ","));
            System.out.println();
        });
    }


}
