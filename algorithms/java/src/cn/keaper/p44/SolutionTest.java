package cn.keaper.p44;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "|*",
            "aa|a",
            "aa|*",
            "cb|?a",
            "adceb|*a*b",
            "acdcb|a*c?b",
            "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb|**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
    );

    @Test
    public void isMatch() {
        cases.forEach(c -> {
            int index = c.indexOf("|");
            System.out.println(solution.isMatch(c.substring(0,index), c.substring(index + 1)));;
        });

    }
}