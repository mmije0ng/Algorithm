import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 괄호 제거: "{{2},{2,1},{2,1,3}}" → "2},{2,1},{2,1,3"
        String[] parts = s.substring(2, s.length() - 2).split("\\},\\{");

        // 숫자 빈도 계산
        Map<Integer, Integer> freq = new HashMap<>();
        for (String part : parts) {
            for (String n : part.split(",")) {
                int num = Integer.parseInt(n);
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        // 빈도 기준 내림차순 정렬 (빈도 큰 숫자 → 앞)
        List<Integer> result = new ArrayList<>(freq.keySet());
        result.sort((a, b) -> freq.get(b) - freq.get(a));

        return result.stream().mapToInt(i -> i).toArray();
    }
}
