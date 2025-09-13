import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            // 스택이 비어있지 않고, 스택의 top이 문자의 원소와 같다면
            // 반복 문자열이기 떄문에 제거
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
            }
            else
                stack.push(s.charAt(i));
        }
        
        // 스택이 비어있으면 짝지어 제거할 수 있는 문자열이 존재한 경우
        if(stack.isEmpty())
            answer=1;

        return answer;
    }
}