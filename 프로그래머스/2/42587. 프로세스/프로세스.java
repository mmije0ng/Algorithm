import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        for(int i=0; i<priorities.length; i++ )
            pq.add(priorities[i]);
        
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(!pq.isEmpty() && pq.peek() == priorities[i]){
                    System.out.println("i: " + i);
                    System.out.println("peek: " + pq.peek());
                    
                    pq.poll();
                    answer++;
                    
                    System.out.println("answer: " + answer +"\n");
                    
                    if(location == i){
                        return answer;
                    }
                }  
            }
        }
        
        return answer;
    }
}