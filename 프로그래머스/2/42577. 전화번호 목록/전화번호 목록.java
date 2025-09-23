import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        // 각 번호의 접두어가 map에 있는지 확인
        for (int i = 0; i < phone_book.length; i++) {
            String number = phone_book[i];
            for (int j = 0; j < number.length(); j++) { 
                String prefix = number.substring(0, j);
                if (map.containsKey(prefix)) {
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
