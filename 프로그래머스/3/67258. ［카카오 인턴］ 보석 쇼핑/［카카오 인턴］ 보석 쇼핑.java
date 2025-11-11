import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 전체 보석 종류 개수
        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        int need = kinds.size();

        Map<String, Integer> cnt = new HashMap<>();
        int left = 0, right = 0;
        int bestL = 0, bestR = 0;
        int minLen = Integer.MAX_VALUE;

        while (true) {
            // 모든 종류를 포함하면 왼쪽을 줄여 최단 갱신
            if (cnt.size() == need) {
                if (right - left < minLen) {
                    minLen = right - left;
                    bestL = left;          // 0-based
                    bestR = right - 1;     // right는 exclusive
                }
                String g = gems[left++];
                int c = cnt.get(g) - 1;
                if (c == 0) cnt.remove(g);
                else cnt.put(g, c);
            } else {
                // 더 확장 불가하면 종료
                if (right == gems.length) break;
                String g = gems[right++];
                cnt.put(g, cnt.getOrDefault(g, 0) + 1);
            }
        }

        // 1-based, inclusive 구간 반환
        return new int[]{bestL + 1, bestR + 1};
    }
}
