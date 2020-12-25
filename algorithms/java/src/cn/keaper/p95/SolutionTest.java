package cn.keaper.p95;

import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class SolutionTest {

    private Solution solution = new Solution();


    @Test
    public void generateTrees() {
        IntStream.rangeClosed(0, 5).forEach(i -> {
            List<TreeNode> res = solution.generateTrees(i);
            res.forEach(r -> {
                TreePrinter.printTree(r);
                System.out.println();
            });
            System.out.println();
        });
    }
}