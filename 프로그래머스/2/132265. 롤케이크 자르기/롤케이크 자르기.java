// 각 조각에 동일한 가짓수의 토핑이 올라가도록
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> minusMap = new HashMap<>(); // <숫자, 빈도>
        // minusMap1 <1, 4> <2, 2> <3, 1> <4, 1>
        for (int i = 0; i < topping.length; i++) {
            minusMap.put(topping[i], minusMap.getOrDefault(topping[i], 0)+1);
        }
        
        Map<Integer, Integer> plusMap = new HashMap<>(); // <숫자, 빈도>
        
        // plusMap <1, 2> <2, 1> <3, 1>
        // minusMap <1, 2> <2, 1> <4, 1>
        
        // plusMap <1, 3> <2, 1> <3, 1>
        // minusMap <1, 1> <2, 1> <4, 1>
        
        // 이 경우 부터는 안 됨
        // plusMap <1, 3> <2, 1> <3, 1> <4, 1>
        // minusMap <1, 1> <2, 1> 
        for (int i = 0; i < topping.length; i++) {
            plusMap.put(topping[i], plusMap.getOrDefault(topping[i], 0)+1);
            minusMap.put(topping[i], minusMap.getOrDefault(topping[i], 0)-1);
            
            // minusMap에서 빈도가 0이 존재하게 되면 삭제
            if(minusMap.get(topping[i]) == 0)
                minusMap.remove(topping[i]);
            
            if(plusMap.size() == minusMap.size())
                answer++;
        }

        
        return answer;
    }
}