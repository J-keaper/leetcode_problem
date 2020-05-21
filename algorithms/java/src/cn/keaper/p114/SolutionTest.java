package cn.keaper.p114;

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
            new Integer[]{1,2,5,3,4,null,6},
            new Integer[]{1,2,5,3,4,null,6}

    );

    @Test
    public void flatten() {
        cases.forEach(c -> {
            TreeNode root = TreeBuilder.buildTree(c);
            solution.flatten(root);
            TreePrinter.printTree(root);
            System.out.println();
        });


    }
}