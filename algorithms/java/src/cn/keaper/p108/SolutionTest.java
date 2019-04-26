package cn.keaper.p108;

import org.junit.Test;

import static cn.keaper.utils.tree.integer.TreePrinter.printTree;

public class SolutionTest {


    @Test
    public void sortedArrayToBST() {
        Solution solution = new Solution();
        printTree(solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1,2,3}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1,2}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{1}));
        System.out.println();
        printTree(solution.sortedArrayToBST(new int[]{}));
        System.out.println();

    }
}