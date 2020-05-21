package cn.keaper.p199;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,2,3,null,4,8,null,5,6},
            new Integer[]{1,2,3,null,9,4,8,null,5,6},
            new Integer[]{1,2,3,null,5,null,4}
    );

    @Test
    public void rightSideView() {
        cases.forEach(c -> System.out.println(solution.rightSideView(TreeBuilder.buildTree(c))));
    }
}