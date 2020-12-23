package cn.keaper.p99;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,3,null,null,2},
            new Integer[]{3,1,4,null,null,2}
    );

    @Test
    public void recoverTree() {
        cases.forEach(c -> {
            TreeNode root = TreeBuilder.buildTree(c);
            solution.recoverTree(root);
            TreePrinter.printTree(root);
            System.out.println();
        });

        System.out.println();

        cases.forEach(c -> {
            TreeNode root = TreeBuilder.buildTree(c);
            solution.recoverTree1(root);
            TreePrinter.printTree(root);
            System.out.println();
        });
    }
}