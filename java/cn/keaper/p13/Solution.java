package cn.keaper.p13;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class Solution {

    private static int map(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int sum = 0;
        int length = s.length();

        for (int i = 0 ; i < length - 1 ; i ++){
            int current = map(s.charAt(i));
            int next = map(s.charAt(i + 1));
            sum = current >= next ? sum + current : sum - current;
        }
        sum += map(s.charAt(length - 1));
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] testList = new String[]{"III","IV","IX","LVIII","MCMXCIV","MMMCMXCIX","MCXI","MMMCMLV"};
        Arrays.stream(testList).forEach(
                s -> System.out.println(solution.romanToInt(s)));
    }
}
