package cn.keaper.p129;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{},
            new Integer[]{1},
            new Integer[]{1,null,2},
            new Integer[]{1,2,3},
            new Integer[]{4,9,0,5,1},
            new Integer[]{4,9,0,5,1,2}
    );

    @Test
    public void sumNumbers() {
        cases.forEach(c -> System.out.println(solution.sumNumbers(TreeBuilder.buildTree(c))));
    }

}