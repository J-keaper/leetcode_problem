package cn.keaper.p109;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{1,2,3,4},
            new int[]{1,2,3,4,5},
            new int[]{1,2,3,4,5,6}
    );

    @Test
    public void sortedListToBST() {
        cases.forEach(c -> {
            TreeNode tree = solution.sortedListToBST(ListBuilder.build(c));
            TreePrinter.printTree(tree);
            System.out.println();

            tree = solution.sortedListToBST1(ListBuilder.build(c));
            TreePrinter.printTree(tree);
            System.out.println();

            System.out.println();
        });
    }
}