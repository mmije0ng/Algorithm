import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++){
            // 연속된 숫자라면(덱의 맨 뒤의 요소가 배열의 원소와 같음)
            // 덱의 맨 뒤에 해당 숫자를 넣지 않고 넘어감
            if(!deque.isEmpty() && deque.peekLast()==arr[i])
                continue;
            
            // 연속된 숫자가 아니면 덱의 맨 뒤에 삽입
            else
                deque.addLast(arr[i]);
            // System.out.println(deque.peekLast());
        }
        
        int[] answer = new int[deque.size()];
        int idx = 0;
        
        // 덱의 맨 앞에서부터 원소 제거 후, 배열에 삽입
        while (!deque.isEmpty()) {
            answer[idx++] = deque.removeFirst();
        }

        return answer;
    }
}