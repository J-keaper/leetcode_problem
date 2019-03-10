package cn.keaper.p67;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1,carry = 0;
        while (i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0){
            res.append(carry);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("",""));
        System.out.println(solution.addBinary("10",""));
        System.out.println(solution.addBinary("","10"));
        System.out.println(solution.addBinary("0","0"));
        System.out.println(solution.addBinary("11","1"));
        System.out.println(solution.addBinary("1010","1011"));
        System.out.println(solution.addBinary("1","11111"));
        System.out.println(solution.addBinary("11111","1"));
        System.out.println(solution.addBinary("0","11111"));
        System.out.println(solution.addBinary("11111","0"));
        System.out.println(solution.addBinary("1010","1"));
        System.out.println(solution.addBinary("1011","1"));
        System.out.println(solution.addBinary("100","1"));
        System.out.println(solution.addBinary("1","1"));
        System.out.println(solution.addBinary("11","11"));
        System.out.println(solution.addBinary("111","111"));
    }
}
