package cn.keaper.p1418;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
 */
public class Solution {

    /**
     * 用有序Map维护每种食物对应的点菜桌号
     * 用有序Map存储桌号对应的每种食物数量
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, List<Integer>> food2Table = new TreeMap<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            food2Table.computeIfAbsent(food, k -> new ArrayList<>());
            food2Table.get(food).add(table);
        }
        Map<Integer, int[]> table2Food = new TreeMap<>();
        List<List<Integer>> values = new ArrayList<>(food2Table.values());
        for (int i = 0; i < values.size(); i++) {
            for (Integer table : values.get(i)) {
                if(table2Food.get(table) == null){
                    table2Food.put(table, new int[food2Table.size()]);
                }
                table2Food.get(table)[i] ++;
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(food2Table.keySet());
        res.add(head);
        table2Food.forEach((k,v) -> {
            List<String> tableOrder = new ArrayList<>();
            tableOrder.add(k.toString());
            tableOrder.addAll(Arrays.stream(v).boxed().map(Object::toString).collect(Collectors.toList()));
            res.add(tableOrder);
        });
        return res;
    }

}
