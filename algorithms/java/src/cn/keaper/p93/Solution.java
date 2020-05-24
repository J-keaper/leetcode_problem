package cn.keaper.p93;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class Solution {

    /**
     * 模拟四个数字的长度，依次判断
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        if(a + b + c + d == s.length()){
                            int num1 = Integer.parseInt(s.substring(0,a));
                            int num2 = Integer.parseInt(s.substring(a,a + b));
                            int num3 = Integer.parseInt(s.substring(a + b,a + b + c));
                            int num4 = Integer.parseInt(s.substring(a + b + c));
                            // 判断数字是否满足条件
                            if(num1 <= 255 && num2 <= 255 && num3 <= 255 && num4 <= 255) {
                                String ip = num1 + "." + num2 + "." + num3 + "." + num4;
                                // 需要考虑第一位位0的情况，如果长度不等说明前导0被省略了，跳过
                                if(ip.length() == s.length() + 3) res.add(ip);
                            }

                        }
                    }
                }
            }
        }
        return res;
    }


    private List<String> ans;
    public List<String> restoreIpAddresses2(String s) {
        ans = new ArrayList<>();
        if(s == null || s.length() == 0){
            return ans;
        }
        dfs(s, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int pos, List<String> ip){
        if(ip.size() == 4){
            if(pos == s.length()) {
                ans.add(String.join(".", ip));
            }
            return;
        }
        for (int i = 1; i <= 3 && pos + i <= s.length(); i++){
            String num = s.substring(pos, pos + i);
            if(num.length() > 1 && num.startsWith("0")){
                continue;
            }
            if(i == 3 && Integer.parseInt(num) > 255){
                continue;
            }
            ip.add(num);
            dfs(s, pos + i, ip);
            ip.remove(ip.size() - 1);
        }
    }
}
