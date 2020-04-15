package cn.keaper.p876;

import cn.keaper.utils.list.integer.ListBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void middleNode() {
        System.out.println(solution.middleNode(ListBuilder.build()));
        System.out.println(solution.middleNode(ListBuilder.build(1)).val);
        System.out.println(solution.middleNode(ListBuilder.build(1,2)).val);
        System.out.println(solution.middleNode(ListBuilder.build(1,2,3)).val);
        System.out.println(solution.middleNode(ListBuilder.build(1,2,3,4)).val);
        System.out.println(solution.middleNode(ListBuilder.build(1,2,3,4,5)).val);
        System.out.println(solution.middleNode(ListBuilder.build(1,2,3,4,5,6)).val);
        System.out.println(solution.middleNode(ListBuilder.build(1,2,3,4,5,6,7)).val);
    }
}