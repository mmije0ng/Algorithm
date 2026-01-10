import java.util.*;

// cap: 최대로 실을 수 있는 재활용 택배 상자
// 1순위: 가장 이동 거리가 멈

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        PriorityQueue<Node> deliverQueue = new PriorityQueue<>();
        PriorityQueue<Node> pickupQueue = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            if(deliveries[i]>0) deliverQueue.add(new Node(i+1, deliveries[i]));
            if(pickups[i]>0) pickupQueue.add(new Node(i+1, pickups[i]));
        }
        
        while(!deliverQueue.isEmpty() || !pickupQueue.isEmpty()){
            int dist = 0; // 이동해야 할 위치
            int remainD = cap; // 남은 배달 수
            int remainP = cap; // 남은 수거 수
            
            while(!deliverQueue.isEmpty() && remainD>0){
                Node node = deliverQueue.poll();
                dist = Math.max(dist, node.idx);
                // 이번 이동으로 모두 배달 가능
                if(node.count<=remainD)
                    remainD-=node.count;
                // 남은건 다음에
                else{
                    deliverQueue.add(new Node(node.idx, node.count-remainD));
                    remainD=0;
                }
            }
            
            while (!pickupQueue.isEmpty() && remainP > 0) {
                Node node = pickupQueue.poll();
                dist = Math.max(dist, node.idx);

                if (node.count <= remainP) {
                    remainP -= node.count;
                } else {
                    pickupQueue.add(new Node(node.idx, node.count - remainP));
                    remainP = 0;
                }
            }

            answer+=dist*2L;
        }
        
        return answer;
    }
}

class Node implements Comparable<Node>{
    int idx; // 집 번호
    int count; // 배달 or 수거해야 하는 박스 개수
    
    Node(int idx, int count){
        this.idx=idx;
        this.count=count;
    }
    
    @Override
    public int compareTo(Node o){
        return o.idx-this.idx; // 집 번호 내림차순
    }
}