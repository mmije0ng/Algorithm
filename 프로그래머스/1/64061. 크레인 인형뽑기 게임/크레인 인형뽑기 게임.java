import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i]-1;
            
            for(int j=0; j<board.length; j++) {
                // move의 열에서 인형을 뽑을 수 있느 경우
                if(board[j][move] !=0) {
                    // 같은 모양의 인형 두개가 연속으로 쌓인 경우
                    if(!stack.isEmpty() && board[j][move] == stack.peek()){
                        stack.pop();
                        answer+=2;
                    }
                    
                    else{
                        stack.push(board[j][move]);
                    }
                    
                    board[j][move] = 0; // 뽑은 인형은 0으로 비움
                    break;
                }
            }
        }
        
        return answer;
    }
}
