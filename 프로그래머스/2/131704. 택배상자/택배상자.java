// 택배 기사님이 미리 알려준 순서에 맞게 택배를 실어야 함
// 만약 컨테이너 벨트의 맨 앞에 놓인 상자가 현재 트럭에 실어야 하는 순서가 아니라면 
// 그 상자를 트럭에 실을 순서가 될 때까지 보조 컨테이너에에 보관
// 보조 컨테이너에서 맨 앞의 상자만 뺄 수 있음 -> 스택
// 보조 컨테이너 벨트를 이용해도 기사님이 원하는 순서대로 상자를 싣지 못 한다면, 더 이상 상자를 싣지않음

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] priority = new int[order.length];
        
        Stack<Integer>stack = new Stack<>();
        int idx=0;
        for(int i=1; i<=order.length; i++){
            if(order[idx] == i){
                answer++;
                idx++;
            }
            
            else
                stack.push(i);
            
            while(!stack.isEmpty() && order[idx] == stack.peek()){
                stack.pop();
                idx++;
                answer++;
            }
        }
        
        return answer;
    }
}