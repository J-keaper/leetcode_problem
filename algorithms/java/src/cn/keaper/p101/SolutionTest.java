package cn.keaper.p101;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void isSymmetric() {
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{})));
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{1})));
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2,2})));
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2})));
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2,3})));
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2,2,3,4,4,3})));
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2,2,3,null,null,3})));
        System.out.println(solution.isSymmetric(TreeBuilder.buildTree(new Integer[]{1,2,2,3,null,null,3,1})));
    }
}