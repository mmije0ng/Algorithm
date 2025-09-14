import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringTokenizer st = new StringTokenizer(s, " ");
        Stack<Integer> stack = new Stack<>();
        
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("Z")) {
                stack.pop();  
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}
