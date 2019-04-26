package cn.keaper.p110;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void isBalanced() {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.isBalanced(TreeBuilder.buildTree(new Integer[]{1,2,2,3,3,null,null,4,4})));
        System.out.println(solution.isBalanced(TreeBuilder.buildTree(new Integer[]{1,2,2,3,null,null,3,4,null,null,4})));
    }

    @Test
    public void isBalanced1() {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced1(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.isBalanced1(TreeBuilder.buildTree(new Integer[]{1,2,2,3,3,null,null,4,4})));
        System.out.println(solution.isBalanced1(TreeBuilder.buildTree(new Integer[]{1,2,2,3,null,null,3,4,null,null,4})));
    }
}