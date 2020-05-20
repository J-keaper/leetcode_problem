package cn.keaper.p94;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,null,2,3},
            new Integer[]{1,3,4,5,null,2,3}
    );

    @Test
    public void inorderTraversal() {
        cases.forEach(c -> {
            List<Integer> res = solution.inorderTraversal(TreeBuilder.buildTree(c));
            res.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }


    @Test
    public void inorderTraversal2() {
        cases.forEach(c -> {
            List<Integer> res = solution.inorderTraversal2(TreeBuilder.buildTree(c));
            res.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    @Test
    public void inorderTraversal3() {
        cases.forEach(c -> {
            List<Integer> res = solution.inorderTraversal3(TreeBuilder.buildTree(c));
            res.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }
}