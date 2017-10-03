package string;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = getSortedString(s);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        for (List<String> v : map.values()) {
            res.add(v);
        }
        return res;
    }

    private static String getSortedString(String s) {
        if (s == null || s.length() < 2) return s;

        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);

        return String.valueOf(charArr);
    }
}
