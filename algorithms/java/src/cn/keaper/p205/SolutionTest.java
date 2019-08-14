package cn.keaper.p205;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<String[]> cases = Arrays.asList(
            new String[]{"egg","add"},
            new String[]{"foo","bar"},
            new String[]{"paper","title"},
            new String[]{"paper","aaaaa"}
    );

    private Solution solution = new Solution();

    @Test
    public void isIsomorphic() {
        cases.forEach(c -> System.out.println(solution.isIsomorphic(c[0],c[1])));
    }
}