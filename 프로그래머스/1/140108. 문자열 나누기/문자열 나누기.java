import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int xCount = 0; // x 세기
        int xNotCount = 0; // x가 아닌 글자 세기
        String x = String.valueOf(s.charAt(0)); // 첫번째 글자 x
        // char x = s.charAt(0); 
        Boolean isNew = true;
        
        for(int i=0; i<s.length(); i++){
            if(x.equals(String.valueOf(s.charAt(i))))
                xCount++;
             else
                xNotCount++;
            
            // 횟수가 다른 상태에서 더 이상 읽을 글자가 없는 경우
            if(i==s.length()-1){
                answer++;
            }
            
            // 두 횟수가 같은 경우
            else if(xCount==xNotCount){
                answer++;
                xCount=0;
                xNotCount=0;
                x = String.valueOf(s.charAt(i+1));
            }
        }
        
        return answer;
    }
}