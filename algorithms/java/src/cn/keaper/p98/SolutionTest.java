package cn.keaper.p98;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{2,1,3},
            new Integer[]{5,1,4,null,null,3,6},
            new Integer[]{10,5,15,null,null,6,20},
            new Integer[]{3,1,5,0,2,4,6,null,null,null,3}
    );

    @Test
    public void isValidBST() {
        cases.forEach(c -> {
            TreeNode tree = TreeBuilder.buildTree(c);
            System.out.println(solution.isValidBST(tree));
        });
    }

    @Test
    public void isValidBST1() {
        cases.forEach(c -> {
            TreeNode tree = TreeBuilder.buildTree(c);
            System.out.println(solution.isValidBST1(tree));
        });
    }

    @Test
    public void isValidBST2() {
        cases.forEach(c -> {
            TreeNode tree = TreeBuilder.buildTree(c);
            System.out.println(solution.isValidBST2(tree));
        });
    }
}