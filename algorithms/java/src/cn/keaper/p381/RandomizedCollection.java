package cn.keaper.p381;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class RandomizedCollection {

    private Random random;  // 用来计算随机数
    private List<Integer> numbers;   // 存放元素的列表
    private Map<Integer, Set<Integer>> posListMap; // 用来存放元素的在number中的下标位置


    /** Initialize your data structure here. */
    public RandomizedCollection() {
        random = new Random();
        numbers = new ArrayList<>();
        posListMap = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     *
     */
    public boolean insert(int val) {
        numbers.add(val);
        posListMap.putIfAbsent(val, new HashSet<>());
        Set<Integer> posSet = posListMap.get(val);
        boolean noExist = posSet.isEmpty();
        posSet.add(numbers.size() - 1);
        return noExist;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     *
     */
    public boolean remove(int val) {
        Set<Integer> posSet = posListMap.get(val);
        if(posSet == null || posSet.isEmpty()){
            return false;
        }

        Iterator<Integer> iterator = posSet.iterator();
        int ri = iterator.next(); // 待删除元素的下标，记为ri
        iterator.remove();  // 待删除元素下标集合中删除ri
        if(ri == numbers.size() - 1){ // 如果是最后一个元素，删除下标集合中的下标并且删除元素即可
            numbers.remove(numbers.size() - 1);  // 删除最后一个元素
            return true;
        }

        int lastNum = numbers.get(numbers.size() - 1);  // 最后一个元素
        numbers.set(ri, lastNum); // 将最后一个元素放到ri位置
        Set<Integer> lastPosSet = posListMap.get(lastNum); // 最后一个元素的下标集合
        lastPosSet.remove(numbers.size() - 1);  // 最后一个元素的下标集合中移除原下标
        lastPosSet.add(ri);   // 最后一个元素的下标中加入 ri
        numbers.remove(numbers.size() - 1);  // 删除最后一个元素
        return true;
    }

    /**
     * Get a random element from the collection.
     *
     */
    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }


}
