package cn.keaper.p111;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{3, 9, 20, null, null, 15, 7},
            new Integer[]{3, 9},
            new Integer[]{3},
            new Integer[]{}
    );

    @Test
    public void minDepth() {
        cases.forEach(c -> {
            System.out.println(solution.minDepth(TreeBuilder.buildTree(c)));
            System.out.println(solution.minDepth1(TreeBuilder.buildTree(c)));
            System.out.println();
        });

    }
}