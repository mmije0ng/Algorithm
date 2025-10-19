class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cntZero = 0; // 제거한 0의 개수
        int iterCnt = 0; // 반복 횟수
        String resultS = s; // 변환할 문자열
        
        while (!resultS.equals("1")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < resultS.length(); i++) {
                // 0이 아니면 이진 변환에 포함
                if (resultS.charAt(i) != '0') {
                    sb.append(resultS.charAt(i));
                } else {
                    cntZero++;
                }
            }
            iterCnt++;
            int len = sb.toString().length(); // 0 제거 후 길이
            resultS = Integer.toBinaryString(len); // 이진 변환 결과
        }

        answer[0] = iterCnt;
        answer[1] = cntZero;
        
        return answer;
    }
}
