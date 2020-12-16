package cn.keaper.review.p125;

public class Solution {

    public boolean isPalindrome(String s) {
        int[] flag = new int[256];
        for (int i = 0; i < 10; i++) {
            flag['0' + i] = i + 1;
        }
        for (int i = 0; i < 26; i++) {
            flag['a' + i] = 11 + i;
            flag['A' + i] = 11 + i;
        }

        int l = 0, r = s.length() - 1;
        while (l < r){
            int lf = flag[s.charAt(l)], rf = flag[s.charAt(r)];
            if(lf != 0  && rf != 0){
                if(lf != rf){
                    return false;
                }
                l++;r--;
            }else{
                if(lf == 0){
                    l++;
                }
                if(rf == 0){
                    r--;
                }

            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }


}
