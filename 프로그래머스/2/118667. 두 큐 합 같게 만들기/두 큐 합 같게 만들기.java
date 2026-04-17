import java.util.*;

// 1회: 1번의 pop + 1번의 insert
// 최소 횟수

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Integer> q1 = new ArrayDeque<>(); 
        Queue<Integer> q2 = new ArrayDeque<>(); 
        
        for(int i=0; i<queue1.length; i++){
            sum+=queue1[i];
            q1Sum+=queue1[i];
            q1.add(queue1[i]);
                
            sum+=queue2[i];
            q2Sum+=queue2[i];
            q2.add(queue2[i]);
        } 
        
        long target = sum/2;
        int limit = (queue1.length + queue2.length) * 2;
         while (answer <= limit) {
            if (q1Sum == target) return answer;

            if (q1Sum < target) {
                if (q2.isEmpty()) return -1;
                int num = q2.poll();
                q1.add(num);
                q1Sum += num;
            } 
             
             else {
                if (q1.isEmpty()) return -1;
                int num = q1.poll();
                q2.add(num);
                q1Sum -= num;
            }

            answer++;
        }
        
        if(answer > limit) return -1;
        
        return answer;
    }
}