import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        List<Character> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        
        // 내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        // 문자열로 합치기
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        
        // long으로 변환
        return Long.parseLong(sb.toString());
    }
}
