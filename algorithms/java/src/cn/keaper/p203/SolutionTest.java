package cn.keaper.p203;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private List<Case> cases = Arrays.asList(
            new Case(new int[]{1,2,6,3,4,5,6},6),
            new Case(new int[]{1,2,6,3,4,5,6},1),
            new Case(new int[]{1,2,6,3,4,5},5),
            new Case(new int[]{1,1,1,1,2,1,1,6,1,4,5,1},1),
            new Case(new int[]{1,1,1,1},1),
            new Case(new int[]{1},1)
    );

    private Solution solution = new Solution();

    @Test
    public void removeElements() {
        cases.forEach(c -> ListPrinter.print(solution.removeElements(ListBuilder.build(c.list),c.val)));
    }

    @Test
    public void removeElements1() {
        cases.forEach(c -> ListPrinter.print(solution.removeElements1(ListBuilder.build(c.list),c.val)));
    }

    private class Case{
        int [] list;
        int val;

        Case(int[] list, int val) {
            this.list = list;
            this.val = val;
        }
    }

}