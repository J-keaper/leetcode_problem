package cn.keaper.p842;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    private final List<String> cases = Arrays.asList(
            "123456579",
            "11235813",
            "112358130",
            "0123",
            "1101111",
            "17522",
            "539834657215398346785398346991079669377161950407626991734534318677529701785098211336528511",
            "417420815174208193484163452262453871040871393665402264706273658371675923077949581449611550452755"
    );

    @Test
    public void splitIntoFibonacci() {
        cases.forEach(c -> System.out.println(solution.splitIntoFibonacci(c)));

    }

}