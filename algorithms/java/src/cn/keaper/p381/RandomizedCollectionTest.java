package cn.keaper.p381;


import org.junit.Test;

public class RandomizedCollectionTest {

    @Test
    public void test() {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();
        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        System.out.println(collection.insert(1));
        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        System.out.println(collection.insert(1));
        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        System.out.println(collection.insert(2));
        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        System.out.println(collection.getRandom());
        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        System.out.println(collection.remove(1));
        // getRandom 应有相同概率返回 1 和 2 。
        System.out.println(collection.getRandom());
    }


    @Test
    public void test1() {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(0));
        System.out.println(collection.insert(1));
        System.out.println(collection.remove(0));
        System.out.println(collection.insert(2));
        System.out.println(collection.remove(1));
        System.out.println(collection.getRandom());
    }

    @Test
    public void test2() {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1));
        System.out.println(collection.remove(2));
        System.out.println(collection.insert(2));
        System.out.println(collection.getRandom());
        System.out.println(collection.remove(1));
        System.out.println(collection.insert(2));
        System.out.println(collection.getRandom());
    }

    @Test
    public void test3() {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(0));
        System.out.println(collection.remove(0));
        System.out.println(collection.insert(-1));
        System.out.println(collection.remove(0));
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
    }



}