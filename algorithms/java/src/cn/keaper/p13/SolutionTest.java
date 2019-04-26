package cn.keaper.p13;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void romanToInt() {
        Solution solution = new Solution();
        String [] testList = new String[]{"III","IV","IX","LVIII","MCMXCIV","MMMCMXCIX","MCXI","MMMCMLV"};
        Arrays.stream(testList).forEach(
                s -> System.out.println(solution.romanToInt(s)));
    }
}