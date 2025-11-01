import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int p : people)
            list.add(p);

        Collections.sort(list);

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int min = list.get(start);
            int max = list.get(end);

            if (min + max <= limit) {
                // 둘이 같이 탑승
                start++;
                end--;
                answer++;
            } 
            
            else {
                // 무거운 사람만 단독 탑승
                end--;
                answer++;
            }
        }

        return answer;
    }
}
