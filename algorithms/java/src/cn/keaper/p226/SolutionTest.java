package cn.keaper.p226;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreePrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{4,2,7,1,3,6,9},
            new Integer[]{4,2,7,1,3},
            new Integer[]{4,2,7,null,null,1,3,6,9},
            new Integer[]{}
        );

    private Solution solution = new Solution();

    @Test
    public void invertTree() {
        cases.forEach(c -> TreePrinter.printTree(solution.invertTree(TreeBuilder.buildTree(c))));
    }
}