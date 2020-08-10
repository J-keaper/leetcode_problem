package cn.keaper.p91;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class Solution {

    /**
     * dp[i]表示以 第i个字符开始到结尾的子串 的编码方法总数
     * 考虑当前位置的字符：
     * 1. 如果是0，那么dp[i]一定为0，因为单独的0不对应一个编码，0必须作为1或2的后一位组成10或者20
     * 2. 如果是1，考虑后一位：
     *      2.1 如果没有后一位，这一位单独对应一个字母，dp[i] = dp[i+1]
     *      2.2 如果是0，那么组成10，dp[i] = dp[i+2]
     *      2.3 如果是1-9，那么有两种情况，两位单独对应一个字母或者两位组合对应一个字母，dp[i] = dp[i+1] + dp[i+2]
     * 3. 如果是2，考虑后一位：
     *      2.1 如果没有后一位，这一位单独对应一个字母，dp[i] = dp[i+1]
     *      2.2 如果是0，那么组成10，dp[i] = dp[i+2]
     *      2.3 如果是1-6，那么有两种情况，两位单独对应一个字母或者两位组合对应一个字母，dp[i] = dp[i+1] + dp[i+2]
     *      2.4 如果是7-9，那么两位无法组合成一个字母，只能单独对应一个字母，dp[i] = dp[i+1]
     * 4. 如果是3-9，那么只能单独成一位，dp[i] = dp[i+1]
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == '0'){
                dp[i] = 0;
            }else if(c == '1'){
                if(i + 1 >= s.length()){
                    dp[i] = dp[i + 1];
                }else if(s.charAt(i + 1) == '0'){
                    dp[i] = dp[i + 2];
                }else {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
            }else if(c == '2'){
                if(i + 1 >= s.length()){
                    dp[i] = dp[i + 1];
                }else if(s.charAt(i + 1) == '0'){
                    dp[i] = dp[i + 2];
                }else if(s.charAt(i + 1) >= '1' && s.charAt(i + 1) <= '6'){
                    dp[i] = dp[i + 1] + dp[i + 2];
                }else{
                    dp[i] = dp[i + 1];
                }
            }else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    /**
     * 由于0只能与前面两位组合成一个字母，所以先预处理0，将0与前面的位组合成一位，记为一个特殊字符，
     * 如果没有前面的位或者不是1/2，那么直接返回0
     *
     * 处理后的字符串便没有了0
     * 所以只有在当前位能与后一位组合成[11-19,21-26]时，会存在两种组合情况，dp[i] = dp[i+1] + dp[i+2]
     * 其余情况全部都只能单独对应一个字母，dp[i] = dp[i+1]
     */
    public int numDecodings1(String s) {
        StringBuilder trim = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (i - 1 >= 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
                    trim.append('#');
                    i--;
                } else {
                    return 0;
                }
            } else {
                trim.append(s.charAt(i));
            }
        }
        char[] chars = trim.reverse().toString().toCharArray();

        int[] dp = new int[chars.length + 1];
        dp[chars.length] = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1' && i + 1 < chars.length && chars[i + 1] >= '1' && chars[i + 1] <= '9') {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (chars[i] == '2' && (i + 1 < chars.length && chars[i + 1] >= '1' && chars[i + 1] <= '6')) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];

    }

}