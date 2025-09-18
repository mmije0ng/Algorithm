import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 뒤에 있는 기능이 먼저 끝나도, 앞에 있는 기능이 배포될 때 함께 배포되야 함 -> 큐
        // 큐에는 작업 시간을 할당
        // 큐의 맨 앞 시간보다, 뒤의 시간이 더 길 때 일수를 자름
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 각 기능 완료까지 걸리는 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int time = (int) Math.ceil((double) remain / speeds[i]); // 올림
            queue.add(time);
        }
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int day = 1;
            int firstTime = queue.poll();
            
            // 큐의 맨 앞 시간보다, 뒤의 시간이 더 짧으면 
            // 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발 된 경우
            while(!queue.isEmpty() && firstTime >= queue.peek()){
                queue.poll();
                day++;
            }
            result.add(day);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}