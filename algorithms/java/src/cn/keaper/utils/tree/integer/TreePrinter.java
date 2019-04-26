package cn.keaper.utils.tree.integer;

import java.util.LinkedList;
import java.util.Queue;

public class TreePrinter {

    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                System.out.print(node.val + ",");
            }else {
                System.out.print("null,");
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
    }


}
