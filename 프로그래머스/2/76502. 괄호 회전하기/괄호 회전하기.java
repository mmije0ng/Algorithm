import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        // 문자열 길이만큼 회전 반복
        for(int i=0; i<s.length(); i++){
            Boolean isCorrect = true;
            
            // 문자열 길이만큼 한 문자열 올바른 괄호 여부 판단
            for(int j=0; j<s.length(); j++){
                // 닫힘 괄호면 스택이 비어있지 않거나,
                // pop한 괄호가 같은 모양의 열림 괄호여야 함
                if(s.charAt(j) == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        isCorrect = false;
                        continue;
                    }
                }
                 
                else if(s.charAt(j) == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        isCorrect = false;
                        continue;
                    }
                }             
     
                else if(s.charAt(j) == '}'){
                    if(stack.isEmpty() ||stack.pop() != '{'){
                        isCorrect = false;
                        continue;
                    }
                        
                }
                
                // 열림 괄호면 스택에 push
                else
                    stack.push(s.charAt(j));
            }
            
            // 스택이 비어있어야 함
            if (isCorrect && stack.isEmpty())
                answer++;
            // System.out.println(s);
            // System.out.println(isCorrect);
            
            s = s.substring(1) + s.charAt(0); // 왼쪽으로 회전
            stack = new Stack<>(); // 스택 초기화
        }      
        
        return answer;
    }
}