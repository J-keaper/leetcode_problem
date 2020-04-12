package cn.keaper.p543;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,2,3,4,5},
            new Integer[]{1,2,3,4,5,null,8,4},
            new Integer[]{1,2,3,4,5,null,8,null,null},
            new Integer[]{1,2,3,4,5,null,8,null,null,6,7,19,null,24}
    );

    @Test
    public void diameterOfBinaryTree() {
        cases.forEach(c -> System.out.println(solution.diameterOfBinaryTree(TreeBuilder.buildTree(c))));

    }
}