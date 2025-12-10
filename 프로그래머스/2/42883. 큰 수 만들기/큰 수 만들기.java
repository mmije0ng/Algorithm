import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<number.length(); i++){
            char charNumber = number.charAt(i);
            // 스택에 top보다 배열의 숫자가 더 크다면 스택 top 제거
            while(!stack.isEmpty() && k>0 && stack.peek()<charNumber){
                stack.pop();
                k--;
            }
                
            stack.push(charNumber); // 배열 숫자 push
        }
        
        // 뒤에 k개 만큼 제거되지 못한 경우 제거
        // ex) 54321
        for(int i=0; i<k; i++){
            System.out.println(stack.peek());
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}
