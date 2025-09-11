import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                stack.push(ch);
            } else { // ')'
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 먼저 나오면 잘못된 문자열
                }
                stack.pop();
            }
        }
        
        // 끝났을 때 stack이 비어 있어야 올바른 괄호 문자열
        return stack.isEmpty();
    }
}
