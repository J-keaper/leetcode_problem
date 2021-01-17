package cn.keaper.p692;


import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class Solution {

    /**
     * 使用Map记录每个单词出现的数量
     * 遍历Map，维护一个大小为K的堆，堆顶元素为出现频率第K大的元素
     * 最后堆中元素即为结果
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Comparator<Pair<String, Integer>> comparator = (p1, p2) -> {
            if (p1.getValue().equals(p2.getValue())) {
                return p2.getKey().compareTo(p1.getKey());
            }
            return p1.getValue() - p2.getValue();
        };
        Queue<Pair<String, Integer>> heap = new PriorityQueue<>(comparator);
        map.forEach((str, count) -> {
            Pair<String, Integer> pair = new Pair<>(str, count);
            if(heap.size() < k){
                heap.offer(new Pair<>(str, count));
            }else if(comparator.compare(heap.peek(), pair) < 0){
                heap.poll();
                heap.offer(new Pair<>(str, count));
            }
        });
        List<String> res = new LinkedList<>();
        while (!heap.isEmpty()){
            Pair<String, Integer> pair = heap.poll();
            res.add(0, pair.getKey());
        }
        return res;
    }
}
