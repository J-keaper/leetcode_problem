package cn.keaper.review.p38;

public class Solution {

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String prev = countAndSay(n-1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < prev.length();) {
            int j = i + 1, count = 1;
            while (j < prev.length() && prev.charAt(j) == prev.charAt(j-1)){
                count++;
                j++;
            }
            res.append((char)(count + '0'));
            res.append(prev.charAt(i));
            i = j;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new Solution().countAndSay(i));
        }
    }
}
