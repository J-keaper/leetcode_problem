package cn.keaper.p102;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1, null, 2, 3},
            new Integer[]{1,3,4,5,null,2,3},
            new Integer[]{3,9,20,null,null,15,7}
    );

    @Test
    public void preorderTraversal() {
        cases.forEach(c -> {
            List<List<Integer>> res = solution.levelOrder(TreeBuilder.buildTree(c));
            res.forEach(level -> {
                level.forEach(i -> System.out.print(i + " "));
                System.out.println();
            });
            System.out.println("============");
        });
    }


    @Test
    public void levelOrder() {
    }
}