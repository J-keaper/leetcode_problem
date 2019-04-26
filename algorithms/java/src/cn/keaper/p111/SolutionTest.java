package cn.keaper.p111;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void minDepth() {
        Solution solution = new Solution();
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{3,9})));
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{3})));
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{})));
    }
}