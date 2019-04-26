package cn.keaper.p100;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void isSameTree() {
        Integer[] nodeList1 = new Integer[]{};
        Integer[] nodeList2 = new Integer[]{1};
        TreeNode tree1 = TreeBuilder.buildTree(nodeList1);
        TreeNode tree2 = TreeBuilder.buildTree(nodeList2);
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(tree1,tree2));
    }
}