import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        StringBuilder sb = new StringBuilder();
        StringBuilder sbWord = new StringBuilder(); // 영어 단어 누적용

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) { // 문자를 숫자로 바꿀 수 있는지 판별
                sb.append(c); // 숫자는 바로 추가
            } 
            
            else{
                sbWord.append(c); // 문자를 영어 단어에 이어붙임
                
                // 영어 단어가 완성되어 hashmap에 포함되어 있다면
                String word = sbWord.toString();
                if(map.containsKey(word)) {
                    sb.append(map.get(word));
                    sbWord.setLength(0); // 영어 단어가 완성되었으니, 다음 영어 단어 완성을 위해 초기화
                    // sbWord = new StringBuilder();
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
