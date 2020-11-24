package cn.keaper.p222;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void countNodes() {
        IntStream.rangeClosed(0,20).mapToObj(i -> IntStream.rangeClosed(1,i).boxed().toArray(Integer[]::new)).forEach(c -> {
            System.out.println(solution.countNodes(TreeBuilder.buildTree(c)));
            System.out.println(solution.countNodes1(TreeBuilder.buildTree(c)));
            System.out.println();
        });
    }

    @Test
    public void getHeight() {
        System.out.println(solution.getHeight(TreeBuilder.buildTree(new Integer[]{1,2,3,4,5,6})));
        System.out.println(solution.getHeight(TreeBuilder.buildTree(new Integer[]{1,2,3,4})));
        System.out.println(solution.getHeight(TreeBuilder.buildTree(new Integer[]{1,2,3})));

    }

    @Test
    public void exist() {
        TreeNode root = TreeBuilder.buildTree(new Integer[]{1,2,3,4,5,6});
        int h = solution.getHeight(root);

        System.out.println(solution.exist(root, h, 4));
        System.out.println(solution.exist(root, h, 5));
        System.out.println(solution.exist(root, h, 6));
        System.out.println(solution.exist(root, h, 7));

    }
}