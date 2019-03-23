package cn.keaper.p38;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class Solution {

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String last = countAndSay(n - 1);
        StringBuilder resBuilder = new StringBuilder();
        for(int i = 0 ; i < last.length();){
            int count = 1;
            char ch = last.charAt(i);
            while ( ++i < last.length() && last.charAt(i) == ch){
                count ++;
            }
            resBuilder.append(count);
            resBuilder.append(ch);
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i = 1 ; i <= 30 ; i ++){
            System.out.println(solution.countAndSay(i));
        }
    }
}
