package cn.keaper.p71;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class Solution {

    /**
     * 原字符串根据 / 分开，处理每一级目录
     *
     */
    public String simplifyPath(String path) {
        String[] pathList = path.split("/");
        int size = 0;
        String[] stack = new String[pathList.length];
        for (String p : pathList) {
            if(p.length() == 0 || p.equals(".")){  // 处理 连续 '/' 和 当前目录
                continue;
            }
            if(p.equals("..")){  // 上级目录，从栈中弹出一级
                if(size > 0){   // 没办法继续弹出
                    size--;
                }
                continue;
            }
            stack[size++] = p;
        }
        if(size == 0){
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            res.append("/").append(stack[i]);
        }
        return res.toString();
    }

}
