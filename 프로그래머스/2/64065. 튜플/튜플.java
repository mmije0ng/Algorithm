import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<>(); // <숫자, 빈도>
        
        // 가장 바깥의 {{ }} 제거
        s = s.substring(2, s.length() - 2);

        // "},{" 를 구분자로 분리
        String[] parts = s.split("\\},\\{");
        
        // 각 부분에서 숫자만 추출
        for (String part : parts) {
            String[] nums = part.split(",");
            for (String n : nums) {
                int key = Integer.parseInt(n);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
                
        // 빈도 내림차순으로 정렬
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            return map.get(b)-map.get(a);
        });
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}