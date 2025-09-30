import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>(); //<문자열, 색인번호>
        int indexNumber = 1; // 색인 번호
        
        // map에 A 부터 Z까지 넣어놓기
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), indexNumber++);
        }        
        
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < msg.length();) {
            String word = "";
            // map에 없는 문자열을 찾을 때 까지 반복
            while(i<msg.length() && map.containsKey(word+msg.charAt(i))){
                word += msg.charAt(i);
                i++;
            }
                 
            // 현재 문자를 정답 list에 add
            answerList.add(map.get(word));
            // System.out.println("i = " + i);
            
            // map에 없는 다음 문자를 put
            if(i<msg.length()-1){
                map.put(word+msg.charAt(i), indexNumber++);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
