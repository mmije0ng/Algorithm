import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 인덱스 값 순으로 정렬
        // 인덱스 값이 같다면 사전순으로 정렬
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            // n번째 인덱스 문자 + 원소
            // car -> ccar
            // bed -> ebed
            list.add(strings[i].charAt(n)+strings[i]);
        }
        
        Collections.sort(list);
        
        String[] answer = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            // ccar -> car로 자르기
            // 1번째 인덱스 부터 원소의 길이-1 인덱스 까지 자르기
            answer[i] = list.get(i).substring(1, list.get(i).length());
        }
        
        return answer;
    }
}