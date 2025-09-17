import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 최대힙에 넣어 정렬
        // 앞의 원소가 K보다 크다면, 뒤의 원소도 K보다 크다는 것이 보장
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        // 최소힙의 맨 앞의 수가 K보다 낮은 경우
        while(pq.size()>=2 && pq.peek() < K){  
            int num = pq.poll() + (pq.poll()*2);
            pq.add(num);
            answer++;
        }
        
        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
        if(pq.peek() < K)
            answer = -1;
        
        return answer;
    }
}