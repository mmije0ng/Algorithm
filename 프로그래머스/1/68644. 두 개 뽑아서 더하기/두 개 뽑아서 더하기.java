import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 합의 중복 제거를 위해 HashSet 사용
        Set<Integer> set = new HashSet<>();

        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // Set → int[] 변환 후 정렬
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int v: set) {
            answer[idx++] = v;
        }    
        Arrays.sort(answer);
        
        return answer;
    }
}
