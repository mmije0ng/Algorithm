import java.util.*;

class Solution {

    public String[] solution(String[] files) {
        List<String> list = new ArrayList<>(Arrays.asList(files));

        Collections.sort(list, (a, b) -> {
            // HEAD 추출 (소문자로 통일)
            String headA = a.split("\\d")[0].toLowerCase();
            String headB = b.split("\\d")[0].toLowerCase();

            // 1. HEAD 비교
            if (!headA.equals(headB)) 
                return headA.compareTo(headB);

            // 2. NUMBER 비교
            int idxA = headA.length(); // head 길이 = number 시작 위치
            int idxB = headB.length();

            int numA = getNumber(a, idxA);
            int numB = getNumber(b, idxB);

            if (numA != numB)
                return numA - numB;

            // 3. TAIL 비교 (같을 경우 원본 순서 유지 → 안정 정렬이므로 0 반환)
            return 0; // == compare()가 0을 반환
        });

        return list.toArray(new String[0]);
    }

    // HEAD 뒤의 NUMBER만 추출하는 함수
    private int getNumber(String s, int startIdx) {
        StringBuilder sb = new StringBuilder();
        for(int i=startIdx; i<s.length(); i++){
            char c = s.charAt(i);
            // 숫자가 아니면 종료
            if(!Character.isDigit(c))
                break;
            sb.append(c);
        }
        
        return Integer.parseInt(sb.toString());
    }

}
