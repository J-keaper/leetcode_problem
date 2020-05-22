package cn.keaper.p105;

import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{3,9,20,15,7},
            new int[]{9,3,15,20,7}
    );

    @Test
    public void buildTree() {
        for (int i = 0; i < cases.size(); i+=2) {
            TreeNode root = solution.buildTree(cases.get(i), cases.get(i+1));
            TreePrinter.printTree(root);
        }
    }
}