// 교집합/합집합
// 교집합 -> 맵
// 합집합 -> set

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>(); // 교집합
        Map<String, Integer> map2 = new HashMap<>(); // 교집합
        int mod = 65536;

        makeMap(map1, str1);
        makeMap(map2, str2);
        
        if (map1.isEmpty() && map2.isEmpty()) return mod;
        
        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        
        int intersection = 0;
        int union = 0;
        for (String key : set) {
            int v1 = map1.getOrDefault(key, 0);
            int v2 = map2.getOrDefault(key, 0);
            intersection += Math.min(v1, v2);
            union += Math.max(v1, v2);
        }
       
        return (int) ((long) intersection * mod / union);
    }
    
    private void makeMap(Map<String, Integer> map, String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (isAlpha(a) && isAlpha(b)) {
                String key = ("" + Character.toUpperCase(a) + Character.toUpperCase(b));
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
    }
    
     private boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}