package cn.keaper.p104;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxDepth() {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{1})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{1,2})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7,1})));
    }
}