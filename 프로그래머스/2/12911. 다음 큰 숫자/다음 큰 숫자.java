// 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수
// 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같다
// 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수

class Solution {
    public int solution(int n) {
        int answer = 0;
        String hexN = Integer.toBinaryString(n);
        int countOneN = 0;
        
        for(int i=0; i<hexN.length(); i++){
            if(hexN.charAt(i) == '1'){
                countOneN++;
            }
        }
        
        for(int i=n+1; i<=Integer.MAX_VALUE; i++){
            String hexS = Integer.toBinaryString(i);
            int countOneS = 0;
            
            for(int j=0; j<hexS.length(); j++){
                if(hexS.charAt(j) == '1'){
                    countOneS++;
                }
            }  
            
            if(countOneS == countOneN){
                answer = Integer.parseInt(hexS, 2); // 2진수를 10진수로 변환
                break;
            }    
        }
        
        return answer;
    }
}