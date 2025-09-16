import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1; // 시간
        int idx = 0;
        int totalWeight = 0; // 다리에 올라가있는(큐에 들어간) 총 무게
        
        Queue<Truck> queue = new LinkedList<>(); // 다리
        queue.add(new Truck(truck_weights[idx], 1));
        totalWeight += truck_weights[idx++];
        
        while(!queue.isEmpty()){
            // 다리 위 트럭 이동 (진행 거리 증가)
            for (Truck t : queue) {
                t.setTruckLength(t.getTruckLength() + 1);
            }
            
            // 큐 맨 앞의 트럭이 다리를 다 건넜다면 큐에서 제거
            if(queue.peek().getTruckLength() > bridge_length 
               && !queue.isEmpty()){
                totalWeight -= queue.poll().getTruckWeight();
            }
            
             // 최대 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight
            
            // 큐에 들어있는 트럭들의 총 무게+새로운 트럭 무게가 weight보다 작거나 같고
            // bridge_length 보다 큐에 들어가있는 트럭의 개수가 작거나 같다면
            // 새로운 트럭 큐에 추가
            if(idx<truck_weights.length
               && totalWeight+truck_weights[idx] <= weight
               && queue.size() <= bridge_length
               ) {
                queue.add(new Truck(truck_weights[idx], 1));
                totalWeight+=truck_weights[idx++];
            }
    
            answer++; // 시간 증가
        }
        
        return answer;
    }
}

class Truck {
    private int truckWeight; // 트럭의 무게
    private int truckLength; // 트럭이 다리를 얼마나 건넜는지
    
    public Truck(int truckWeight, int truckLength){
        this.truckWeight = truckWeight;
        this.truckLength = truckLength;
    }
    
    public int getTruckWeight(){
        return truckWeight;
    }
    
    public int getTruckLength(){
        return truckLength;
    }
    
    public void setTruckWeight(int truckWeight){
        this.truckWeight = truckWeight;
    }
    
    public void setTruckLength(int truckLength){
        this.truckLength = truckLength;
    }
}


// import java.util.*;

// class Solution {
//     public int solution(int bridge_length, int weight, int[] truck_weights) {
//         int answer = 1; // 시간
//         int idx = 0;
//         int totalWeight = 0; // 다리에 올라가있는(큐에 들어간) 총 무게
        
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(truck_weights[idx]);
//         totalWeight += truck_weights[idx++];
        
//         while(!queue.isEmpty()){
//             // 최대 bridget_length대, 최대 weight무게
//             // 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시
//             if(queue.size() <= bridge_length && totalWeight<=weight 
//                && idx<truck_weights.length)
//             {
//                 queue.add(truck_weights[idx]);
//                 totalWeight += truck_weights[idx++];
//             } 
            
//             else{
//                 int w = queue.poll();
//                 totalWeight -= w;
//             }
//             answer++;
//             System.out.println("queue peek: " + queue.peek());
//             System.out.println("answer: " + answer);
//         }
        
//         return answer;
//     }
// }

