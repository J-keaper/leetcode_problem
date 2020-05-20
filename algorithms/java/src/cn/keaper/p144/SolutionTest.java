package cn.keaper.p144;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1, null, 2, 3},
            new Integer[]{1,3,4,5,null,2,3}
    );

    @Test
    public void preorderTraversal() {
        cases.forEach(c -> {
            List<Integer> res = solution.preorderTraversal(TreeBuilder.buildTree(c));
            res.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    @Test
    public void preorderTraversal2() {
        cases.forEach(c -> {
            List<Integer> res = solution.preorderTraversal2(TreeBuilder.buildTree(c));
            res.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    @Test
    public void preorderTraversal3() {
        cases.forEach(c -> {
            List<Integer> res = solution.preorderTraversal3(TreeBuilder.buildTree(c));
            res.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }
}