package cn.keaper.utils.tree.integer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePrinter {

    public static void printTree(TreeNode root){
        List<String> sequence = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                sequence.add(String.valueOf(poll.val));
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                sequence.add(null);
            }
        }
        int last = sequence.size() - 1;
        while (sequence.get(last) == null) {
            last--;
        }
        System.out.println(String.join(",", sequence.subList(0, last + 1)));
    }


    public static void main(String[] args) {
      TreePrinter.printTree(TreeBuilder.buildTree(new Integer[]{1,2,3,null,null,4,5}));
    }

}
