package cn.keaper.p230;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1, 1},
            new Integer[]{5,3,6,2,4,null,7, 1},
            new Integer[]{5,3,6,2,4,null,7, 3},
            new Integer[]{5,3,6,2,4,null,7, 6},
            new Integer[]{3,1,4,null,2 ,1},
            new Integer[]{5,3,6,2,4,null,null,1, 3}
    );

    @Test
    public void kthSmallest() {
        cases.forEach(c -> {
            TreeNode root = TreeBuilder.buildTree(Arrays.copyOf(c, c.length - 1));
            System.out.println(solution.kthSmallest(root, c[c.length-1]));
        });

    }
}