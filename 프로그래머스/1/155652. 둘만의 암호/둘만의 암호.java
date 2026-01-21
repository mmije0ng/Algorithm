// 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
// index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
// skip에 있는 알파벳은 제외하고 건너뜁니다.

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>(); // skip
        for(char c: skip.toCharArray())
            set.add(c);
        
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            int moved = 0;
            char cur = c;
            
            while(moved<index){
                cur++;
                if (cur > 'z') cur = 'a';
                if(set.contains(cur)) continue;
                
                moved++;
            }
            
            sb.append(cur);
        }
        
        return sb.toString();
    }
}