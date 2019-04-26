package cn.keaper.p107;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private List<Integer[]> cases = Arrays.asList(
        new Integer[]{},
        new Integer[]{1},
        new Integer[]{1,2},
        new Integer[]{1,2,3},
        new Integer[]{1,2,3,4},
        new Integer[]{3,9,20,null,null,15,7},
        new Integer[]{3,9,20,5,null,null,15,7,10,null,null,20},
        new Integer[]{3,9,20,5,null,null,15,null,7,10,null,null,20},
        new Integer[]{3,9,20,5,null,null,15,null,null,null,7,10,null,null,20}
    );

//        []
//        [[1]]
//        [[2], [1]]
//        [[2, 3], [1]]
//        [[4], [2, 3], [1]]
//        [[15, 7], [9, 20], [3]]
//        [[20], [7, 10], [5, 15], [9, 20], [3]]
//        [[20], [7, 10], [5, 15], [9, 20], [3]]
//        [[20], [10], [7], [5, 15], [9, 20], [3]]

    private Solution solution = new Solution();

    @Test
    public void levelOrderBottom() {
        cases.forEach(o -> System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(o))));
    }

    @Test
    public void levelOrderBottom3() {
        cases.forEach(o -> System.out.println(solution.levelOrderBottom3(TreeBuilder.buildTree(o))));
    }

    @Test
    public void levelOrderBottom2() {
        cases.forEach(o -> System.out.println(solution.levelOrderBottom2(TreeBuilder.buildTree(o))));
    }

    @Test
    public void levelOrderBottom1() {
        cases.forEach(o -> System.out.println(solution.levelOrderBottom1(TreeBuilder.buildTree(o))));
    }
}