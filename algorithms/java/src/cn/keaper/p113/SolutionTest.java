package cn.keaper.p113;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Case> cases = Arrays.asList(
            new Case(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}, 22)
    );

    @Test
    public void pathSum() {
        cases.forEach(c -> {
            List<List<Integer>> res = solution.pathSum(TreeBuilder.buildTree(c.tree), c.sum);
            res.forEach(System.out::println);
            System.out.println();
        });
    }

    static class Case {
        Integer[] tree;
        int sum;

        public Case(Integer[] tree, int sum) {
            this.tree = tree;
            this.sum = sum;
        }
    }
}