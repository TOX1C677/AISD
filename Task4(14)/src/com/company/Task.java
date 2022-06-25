package com.company;
import java.util.*;


public class Task {
    public static List<String> solve(String text) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length() - 1; i++) {
            char c1 = text.charAt(i);
            char c2 = text.charAt(i + 1);
            if (c1 != ' ' && c2 != ' ' && c1 != '\n' && c2 != '\n') {
                String pair = c1 + String.valueOf(c2);
                map.put(pair, map.getOrDefault(pair, 0) + 1);
                // if (!map.containsKey(pair)) {
                //      map.put(pair, 1);
                //  } else {
                //      int n = map.get(pair);
                //      map.put(pair, n + 1);
                //  }
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        sort(list);

        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            resultList.add(entry.getKey());
        }
        return resultList;
    }

    private static void sort(List<Map.Entry<String, Integer>> list) {
        boolean finished = false;
        while (!finished) {
            finished = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getValue() < list.get(i + 1).getValue()) {
                    Map.Entry<String, Integer> temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    finished = false;
                }
            }
        }
    }
}
