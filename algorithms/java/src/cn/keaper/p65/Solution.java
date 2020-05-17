package cn.keaper.p65;

/**
 * https://leetcode.com/problems/valid-number/
 */
public class Solution {


    /**
     * 很巧妙的做法 https://leetcode-cn.com/problems/valid-number/solution/java-luo-ji-chao-qing-xi-jie-fa-by-charlesgao/
     *
     * 先设定numSeen，dotSeen和eSeen三种boolean变量，分别代表是否出现数字、点和E
     * 然后遍历目标字符串
     * 1.判断是否属于数字的0~9区间
     * 2.遇到点的时候，判断前面是否有点或者E，都需要return false
     * 3.遇到E的时候，判断前面数字是否合理，是否有E，并把numSeen置为false，防止E后无数字
     * 4.遇到-+的时候，判断是否是第一个，如果不是第一个判断是否在E后面，都不满足则return false
     * 5.其他情况都为false
     * 最后返回numSeen的结果即可
     *
     */
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] ca = s.trim().toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if('0' <= ca[i] && ca[i] <= '9'){
                numSeen = true;
            }else if(ca[i] == '.') {
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(ca[i] == 'e' || ca[i] == 'E'){
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false; // 重新算数字
            }else if(ca[i] == '+' || ca[i] == '-'){
                if(i != 0 && ca[i-1] != 'E' && ca[i-1] != 'e'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return numSeen;
    }

}
