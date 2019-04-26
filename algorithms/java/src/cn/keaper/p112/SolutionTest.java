package cn.keaper.p112;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void hasPathSum() {
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{}),0));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2}),2));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,3}),5));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,3}),4));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3}),4));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3}),5));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3}),6));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3,4}),4));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3,4}),8));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),26));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),17));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),18));

    }
}