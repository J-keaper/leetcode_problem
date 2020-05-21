package cn.keaper.p116;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,2,3,4,5,null,7},
            new Integer[]{1,2,3,4,5,6,7},
            new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}
    );

    @Test
    public void connect() {
        cases.forEach(c -> {
            Solution.Node root = buildTree(c);
            solution.connect(root);
            System.out.println(root);
        });
    }

    @Test
    public void connect2() {
        cases.forEach(c -> {
            Solution.Node root = buildTree(c);
            solution.connect2(root);
            System.out.println(root);
        });
    }


    public static Solution.Node buildTree(Integer[] tree){
        if (tree.length == 0) {
            return null;
        }
        Solution.Node root = new Solution.Node(tree[0]);
        Queue<Solution.Node> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            Solution.Node current = queue.poll();
            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.left = new Solution.Node(tree[index]);
                queue.add(current.left);
            }else {
                current.left = null;
            }
            index++;

            if(index >= tree.length){
                break;
            }
            if(tree[index] != null){
                current.right = new Solution.Node(tree[index]);
                queue.add(current.right);
            }else {
                current.right = null;
            }
            index++;
        }
        return root;
    }

}