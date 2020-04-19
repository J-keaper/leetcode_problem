package cn.keaper.p1417;


/**
 * https://leetcode.com/problems/reformat-the-string/
 */
public class Solution {


    /**
     * 要求相邻字符类型不同，所以两种字符数量相差不能超过1
     * 统计数字和字母的个数，提取出两种字符
     * 然后从提取出的字符中轮流取字符得到结果
     * 注意如果两种字符数量不等，需要保证多的一种先取
     */
    public String reformat(String s) {
        char[] str = s.toCharArray();
        int ac = 0, dc = 0;
        char[] sa = new char[str.length], sd = new char[str.length];
        for (char c : str) {
            if(c >= 'a' && c <= 'z'){
                sa[ac ++] = c;
            }else if(c >= '0' && c <= '9'){
                sd[dc ++] = c;
            }else {
                return "";
            }
        }
        if(Math.abs(dc - ac) > 1){
            return "";
        }
        StringBuilder res = new StringBuilder();
        int min = Math.min(ac, dc), max = Math.max(ac,dc);
        char[] less, more;
        if(dc <= ac){
            less = sd;
            more = sa;
        }else{
            less = sa;
            more = sd;
        }
        for (int i = 0; i < min ; i ++){
            res.append(more[i]);
            res.append(less[i]);
        }
        if(max > min){
            res.append(more[max - 1]);
        }
        return res.toString();
    }


}
