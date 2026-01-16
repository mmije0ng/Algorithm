// 스택?
// x에 있는 "110"을 뽑아서, 임의의 위치에 다시 삽입
import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++){
            Stack<Character> stack = new Stack<>();
            int count110 = 0;
            
            for(int j=0; j<s[i].length(); j++){
                Character c = s[i].charAt(j);
                if(c == '0'){
                    if (!stack.isEmpty() && stack.peek() == '1'){
                        Character top = stack.pop();
                        // 110 제거
                        if(!stack.isEmpty() && stack.peek() == '1'){
                            stack.pop();
                            count110++; // 110 수 카운트
                        }
                        else{
                            stack.push(top);
                            stack.push(c);
                        }
                    }
                    else 
                        stack.push(c);
                }
                
                else // 1은 바로 스택에 삽입
                    stack.push(c);
            }
            
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty())
                sb.append(stack.pop());
            sb.reverse();
            
            int idx = sb.toString().lastIndexOf("0");
            StringBuilder result = new StringBuilder();
            
            // 가장 뒤에 있는 0 다음에 110 사입 후
            // 남은 문자를 110 뒤에 삽입
            if(idx!=-1){
                result.append(sb.substring(0, idx+1));
                for(int k=0; k<count110; k++)
                    result.append("110");
                result.append(sb.substring(idx+1));
            }
            
            // 0이 없으면 스택에 남아있던 문자 앞에 110 삽입
            else{
                for(int k=0; k<count110; k++)
                    result.append("110");
                result.append(sb.toString());
            }
            answer[i] = result.toString();
        }
        
        return answer;
    }
}