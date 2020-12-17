package cn.keaper.review.p65;

public class Solution {

    public boolean isNumber(String s) {
        if(s == null){
            return false;
        }
        s = s.trim();
        if(s.isEmpty()){
            return false;
        }
        boolean dot = false, number = false, e = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                number = true;
            }else if(chars[i] == 'e' || chars[i] == 'E'){
                if(!number || e){
                    return false;
                }
                e = true;
                number = false;
            }else if(chars[i] == '.'){
                if(e || dot){
                    return false;
                }
                dot = true;
            }else if(chars[i] == '+' || chars[i] == '-'){
                if(i != 0 && chars[i-1] != 'E' && chars[i-1] != 'e'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return number;
    }
}
