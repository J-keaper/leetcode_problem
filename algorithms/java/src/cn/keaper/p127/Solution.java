package cn.keaper.p127;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class Solution {

    /**
     * 问题可以抽象为一个无向无权图中，每个单词作为节点，
     * 差距只有一个字母的两个单词之间连一条边
     * 问题变成找到从起点到终点的最短路，使用广度优先搜索方法寻找最短路。
     * <p>
     * 如何构建两个单词之间的边呢？
     * 我们将一个单词中的某个字母替换成一个通配符，得到一个通用的单词
     * 每个单词能够得到多个通用单词，我们于是能构造出每个 通用单词 -> 原始单词 的映射
     * <p>
     * 那么与一个单词相邻的单词就是其所有的通用单词映射到的原始单词的集合
     * <p>
     * 例如：["dog","dot","dag"]三个单词
     * 我们可以得到 "do*" -> ["dog","dot"] , "d*g" -> ["dog", "dag"], "*og" -> ["dog"]
     * 所以与"dog"相邻的单词有"dot","dag"
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if(!wordList.contains(endWord)){
            return 0;
        }
        Map<String, List<String>> changedWordsMap = getChangedWordsMap(wordList);

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(beginWord, 1));
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            Integer level = pair.getValue();
            List<String> changedWords = getChangedWord(word);
            for (String changedWord : changedWords) {
                List<String> matchedWords = changedWordsMap.getOrDefault(changedWord, new ArrayList<>());
                for (String matchedWord : matchedWords) {
                    if (matchedWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(matchedWord)) {
                        queue.add(new Pair<>(matchedWord, level + 1));
                        visited.add(matchedWord);
                    }
                }
            }
        }
        return 0;
    }


    /**
     * 获取每个通用单词对应原单词的映射
     */
    private Map<String, List<String>> getChangedWordsMap(List<String> wordList) {
        Map<String, List<String>> changedWordsMap = new HashMap<>();
        for (String word : wordList) {
            List<String> changedWords = getChangedWord(word);
            for (String changedWord : changedWords) {
                List<String> matchedWords = changedWordsMap.getOrDefault(changedWord, new ArrayList<>());
                matchedWords.add(word);
                changedWordsMap.put(changedWord, matchedWords);
            }
        }
        return changedWordsMap;
    }

    /**
     * 获取一个单词的所有转变状态
     * 例如：hot -> [*ot,h*t,ho*]
     */
    private List<String> getChangedWord(String word) {
        List<String> changed = new ArrayList<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            changed.add(word.substring(0, i) + "*" + word.substring(i + 1));
        }
        return changed;
    }


    /**
     * 双向BFS，减小搜索空间
     * 从 begin 和 end 同时进行BFS，知道其在中间相遇
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if(!wordList.contains(endWord)){
            return 0;
        }
        Map<String, List<String>> changedWordsMap = getChangedWordsMap(wordList);

        Queue<Pair<String, Integer>> queueBegin = new LinkedList<>();
        Queue<Pair<String, Integer>> queueEnd = new LinkedList<>();
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        queueBegin.add(new Pair<>(beginWord, 1));
        queueEnd.add(new Pair<>(endWord, 1));
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);
        while (!queueBegin.isEmpty() || !queueEnd.isEmpty()){
            int ans = visit(changedWordsMap, queueBegin, visitedBegin, visitedEnd);
            if(ans != -1){
                return ans;
            }
            ans = visit(changedWordsMap, queueEnd, visitedEnd, visitedBegin);
            if(ans != -1){
                return ans;
            }
        }
        return 0;
    }


    private int visit(Map<String, List<String>> changedWordsMap, Queue<Pair<String, Integer>> queue,
                      Map<String, Integer> visitedSelf, Map<String, Integer> visitedOther){
        if(queue.isEmpty()){
            return -1;
        }
        Pair<String, Integer> pair = queue.poll();
        String word = pair.getKey();
        Integer level = pair.getValue();
        List<String> changedWords = getChangedWord(word);
        for (String changedWord : changedWords) {
            List<String> matchedWords = changedWordsMap.getOrDefault(changedWord, new ArrayList<>());
            for (String matchedWord : matchedWords) {
                if(visitedOther.containsKey(matchedWord)){
                    return level + visitedOther.get(matchedWord);
                }
                if (!visitedSelf.containsKey(matchedWord)) {
                    queue.add(new Pair<>(matchedWord, level + 1));
                    visitedSelf.put(matchedWord, level + 1);
                }
            }
        }
        return -1;
    }




}
