package cn.keaper.p1071;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class Solution {

    /**
     * 参考证书求最大公约数的辗转相除法的思想
     * 需要自己实现字符串的 "除法" "取余" 两个操作
     */
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }
        if(str2.length() == 0){
            return str1;
        }
        int index = 0;
        while (str1.indexOf(str2, index) != -1){
            index += str2.length();
        }
        if(index == 0){
            return "";
        }
        return gcdOfStrings(str2, str1.substring(index));
    }

}
