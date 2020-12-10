package cn.keaper.p649;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/dota2-senate/
 */
public class Solution {

    /**
     * 显然可以进行的操作就是 踢出一名对方阵营的议员
     * 那么选择哪一个议员呢？我们应该贪心地选择最快要投票的议员，如果不选择最快要投票的议员的话
     * 那么接下来就会有一名己方议员被白白牺牲
     * <p>
     * 模拟一遍
     */
    public String predictPartyVictory(String senate) {
        boolean[] evict = new boolean[senate.length()];
        char[] chars = senate.toCharArray();
        while (true) {
            for (int i = 0; i < chars.length; i++) {
                if (!evict[i]) {
                    boolean found = false;
                    for (int j = (i + 1) % chars.length; j != i; j = (j + 1) % chars.length) {
                        if (!evict[j] && chars[j] != chars[i]) {
                            evict[j] = true;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return chars[i] == 'R' ? "Radiant" : "Dire";
                    }
                }
            }
        }
    }

    /**
     * 使用队列优化
     * 分别使用两个队列保存两队议员的投票顺序，初始时就是数组下标
     *
     * 比较两个队列的队首元素，先投票的会把后投票的踢出，然后自己重新入队参与下一轮投票（下一轮投票顺序加初始议员数量）
     * 最后如果一个队列为空，那么另一队获胜
     */
    public String predictPartyVictory1(String senate) {
        Queue<Integer> rq = new LinkedList<>(),dq = new LinkedList<>();
        int len = senate.length();
        for (int i = 0; i < len; i++) {
            if(senate.charAt(i) == 'R'){
                rq.add(i);
            }else{
                dq.add(i);
            }
        }

        while (!rq.isEmpty() && !dq.isEmpty()){
            int ri = rq.poll(), di = dq.poll();
            if(ri < di){
                rq.add(ri + len);
            }else {
                dq.add(di + len);
            }
        }
        return rq.isEmpty() ? "Dire" : "Radiant";
    }

    /**
     * 实际上，我们执行"禁止"时不需要立即执行，保存下来延迟到后续投票时执行即可
     *
     * 我们使用一个队列保存投票议员的顺序，记录每队的人数和禁令数量
     * 当投票时，队首元素出栈，如果目前该队有禁令，则他被禁止了，并丧失了重新投票（入队）的机会
     * 否则的话，当前议员可以向对方队伍增加一个禁令，然后重新入队进行下一轮投票
     */
    public String predictPartyVictory2(String senate) {
        Queue<Integer> queue = new LinkedList<>();
        int[] people = new int[2];
        int[] bans = new int[2];
        for (int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R'){
                people[0]++;
                queue.offer(0);
            }else {
                people[1]++;
                queue.offer(1);
            }
        }

        while (people[0] > 0 && people[1] > 0){
            int i = queue.poll();
            if(bans[i] > 0){
                bans[i]--;
                people[i]--;
            }else {
                bans[i ^ 1]++;
                queue.add(i);
            }
        }
        return people[0] > 0 ? "Radiant" : "Dire";
    }

}