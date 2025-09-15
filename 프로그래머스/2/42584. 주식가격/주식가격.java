import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        
        // 스택에 인덱스 저장
        // prices[top]과 prices[i] 값을 비교하여 prices[top]이 더 크면 주식 가격 감소 경우
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            
            stack.push(i);
        }
        
        // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
        while(!stack.isEmpty()){
            answer[stack.peek()] = length - stack.peek() - 1;
            stack.pop();
        }
        
        return answer;
    }
}


// import java.util.*;

// class Solution {
//     public int[] solution(int[] prices) {
//         int length = prices.length;
//         int[] answer = new int[length];
        
//         for(int i=0; i<length; i++){            
//             for(int j=i+1; j<length; j++){
//                 // 가격이 떨어진 경우
//                 if(prices[i] > prices[j])
//                     continue;
//                 else
//                     answer[i]++;
//             }
//         }
        
//         return answer;
//     }
// }