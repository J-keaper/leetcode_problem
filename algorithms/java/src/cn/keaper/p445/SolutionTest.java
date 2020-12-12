package cn.keaper.p445;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{7,2,4,3},{5,6,4}},
            new int[][]{{7,2,4,3},{9}},
            new int[][]{{5},{6}}
    );

    @Test
    public void addTwoNumbers() {
        cases.forEach(c -> ListPrinter.print(solution.addTwoNumbers(ListBuilder.build(c[0]),ListBuilder.build(c[1]))));
    }
}