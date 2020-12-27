package cn.keaper.p124;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,2,3},
            new Integer[]{-10,9,20,null,null,15,7},
            new Integer[]{2},
            new Integer[]{-2},
            new Integer[]{-2,2}

    );

    @Test
    public void maxPathSum() {
        cases.forEach(c -> System.out.println(solution.maxPathSum(TreeBuilder.buildTree(c))));
    }
}