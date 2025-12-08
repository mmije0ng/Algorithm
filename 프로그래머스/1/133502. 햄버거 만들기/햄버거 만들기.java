// 1231 순서

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i=0; i<ingredient.length; i++){
            deque.addLast(ingredient[i]);
            
            if(ingredient[i] == 1 && deque.size()>=4){
                int one = deque.removeLast();
                int three = deque.removeLast();
                int two = deque.removeLast();;
                int one2 = deque.removeLast();
                
                if(one == 1 && three == 3 && two == 2 && one2 == 1)
                    answer++;
                
                else{
                    deque.addLast(one2);
                    deque.addLast(two);
                    deque.addLast(three);
                    deque.addLast(one);
                }
            }   
        }
        
        return answer;
    }
}