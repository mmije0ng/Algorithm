import java.util.*;

// 작업량이 높은 순서부터 우선순위큐에 저장
// 작업량을 n번 동안 반복하며 하나씩 줄이며 다시 큐에 저장

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int work: works)
            pq.add(work);
        
        while(n>0){
            int work = pq.poll();
            if(work ==0) break;
            
            work--;
            n--;
            pq.add(work);
        }
        
        while(!pq.isEmpty())
            answer += Math.pow(pq.poll(), 2);
        
        return answer;
    }
}