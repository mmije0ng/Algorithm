import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        int repeat = discount.length - 10 + 1; // 반복횟수
        // System.out.println("repeat = " + repeat);

        for(int i=0; i<repeat; i++){
            HashMap<String, Integer> discountMap = new HashMap<>();
            Boolean isValid = true;

            // 할인상품
            for(int j=i; j<=10+i-1; j++){
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            
            for(int k=0; k<want.length; k++){
                // 할인 품목에 원하는 상품이 없거나, 개수가 다르면
                if(!discountMap.containsKey(want[k]) 
                   || discountMap.get(want[k]) != wantMap.get(want[k])){
                    isValid = false;
                    break;
                }
            }
            
            if(isValid)
                answer++;
        }
        
        return answer;
    }
}