// 물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해야함

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++){
            int amount = 0;
            int cnt = 0;
            
            for(int j=i; j<d.length; j++){
                if(amount>=budget) break;
                amount+=d[j];
                cnt++;
            }
            cnt = amount > budget ? cnt - 1 : cnt;
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}