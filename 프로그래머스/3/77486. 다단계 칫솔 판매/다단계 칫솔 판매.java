import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parentMap = new HashMap<>(); // <enroll, referral>
        for(int i=0; i<enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
        }
        
        HashMap<String, Integer> totalMap = new HashMap<>(); // <seller, 각 seller가 번 총 금액>
        for(int i=0; i<seller.length; i++){
            int price = amount[i]*100; // 현재 seller가 판매한 금액
            String sellerName = seller[i]; // 
            
            while(price>=1 && !sellerName.equals("-")){
                int give = price/10; // 추천인에게 줄 금액
                int myPrice = price - give; // 내가 가질 금액
                
                if(price < 1)
                    break;
                
                String parentSeller = parentMap.get(sellerName); // 부모 판매자
                totalMap.put(sellerName, totalMap.getOrDefault(sellerName, 0)+myPrice); // 내 금액
                // totalMap.put(parentSeller, totalMap.getOrDefault(parentSeller, 0)+give); // 추천인(부모) 금액
                price = give;
                sellerName = parentMap.get(sellerName); // 다음 sellerName은 부모로, 부모도 추천인에게 받은 금액을 나눠줘야 함 
            }
        }
        
         // enroll 순서대로 totalMap의 값을 배열에 담음
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = totalMap.getOrDefault(enroll[i], 0);
        }
        
        return answer;
        
    }
}