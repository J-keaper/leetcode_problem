package cn.keaper.p143;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,4,5,6},
            new int[]{1,2,3,4,5},
            new int[]{1,2,3},
            new int[]{1,2},
            new int[]{1},
            new int[]{}
    );


    @Test
    public void reorderList() {
        cases.forEach(c -> {
            ListNode head = ListBuilder.build(c);
            solution.reorderList(head);
            ListPrinter.print(head);
        });

    }
}