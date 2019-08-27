package cn.keaper.p257;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{},
            new Integer[]{1},
            new Integer[]{1,2},
            new Integer[]{1,2,null,3,null,4},
            new Integer[]{1,2,3,null,5},
            new Integer[]{1,2,6,4,3,null,5,7}
    );

    private Solution solution = new Solution();

    @Test
    public void binaryTreePaths() {
        cases.forEach(c -> {
            List<String> res = solution.binaryTreePaths(TreeBuilder.buildTree(c));
            System.out.println(Arrays.toString(res.toArray()));
        });
    }
}