// borad[i][j]가 0이 아니면
// 자신 기준에서부터 왼쪽, 위쪽, 왼쪽 상단의 최솟값을 구한 후
// 자신의 위치 = 최솟값 + 1
// 자신의 위치와 answer중 더 큰 값을 answer에 할당

class Solution{
    public int solution(int [][]board){
        int answer = 0; // 가장 큰 정사각형 한 변의 길이
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]!=0 && i>0 && j>0)
                    board[i][j] = Math.min(board[i][j-1], Math.min(board[i-1][j], board[i-1][j-1]))+1;
                
                answer = Math.max(answer, board[i][j]);
            }  
        }
        
        // for(int i=0; i<row; i++){
        //     for(int j=i; j<col; j++)
        //         System.out.print(board[i][j]);  
        //     System.out.println();  
        // }

        return answer*answer;
    }
}