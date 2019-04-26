package cn.keaper.p58;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void lengthOfLastWord() {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("    "));
        System.out.println(solution.lengthOfLastWord("  j "));
        System.out.println(solution.lengthOfLastWord("Hello Word"));
        System.out.println(solution.lengthOfLastWord("Hello         Word    "));
        System.out.println(solution.lengthOfLastWord("Hello         Word    a   "));
        System.out.println(solution.lengthOfLastWord("Hello         Word    ab "));
        System.out.println(solution.lengthOfLastWord("Hello         Word    abc"));
    }
}