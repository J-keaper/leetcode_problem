package cn.keaper.utils.tree.integer;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    /**
     * build tree by the way like level traverse
     */
    public static TreeNode buildTree(Integer[] tree){
        if (tree.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.left = new TreeNode(tree[index]);
                queue.add(current.left);
            }else {
                current.left = null;
            }
            index++;

            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.right = new TreeNode(tree[index]);
                queue.add(current.right);
            }else {
                current.right = null;
            }
            index++;
        }
        return root;
    }
}
