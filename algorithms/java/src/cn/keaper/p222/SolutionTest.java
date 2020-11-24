package cn.keaper.p222;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,2,3,4,5,6},
            new Integer[]{1,2,3,null,null,4,5,6},
            new Integer[]{1,2,3,4,null,5,6,null, 8,9}

            );



    @Test
    public void countNodes() {
        cases.forEach(c -> System.out.println(solution.countNodes(TreeBuilder.buildTree(c))));
    }
}