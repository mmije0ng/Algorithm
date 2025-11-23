class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cntZero = 0; // 제거한 0의 개수
        int iterCnt = 0; // 반복 횟수
        String resultS = s; // 변환할 문자열
        
        while(!resultS.equals("1")){
            StringBuilder sb = new StringBuilder();
            int len = 0; // 0 제거 후 길이
            for(int i=0; i<resultS.length(); i++){
                if(resultS.charAt(i) == '0')
                    cntZero++;
                else
                    len++;
            }
            iterCnt++;            
            resultS = Integer.toBinaryString(len); // 이진 변환 결과
        }

        answer[0] = iterCnt;
        answer[1] = cntZero;
        
        return answer;
    }
}
