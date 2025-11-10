class Solution {
    private int N;
    private boolean[] width;
    private boolean[] diagonal1;
    private boolean[] diagonal2;
    
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2];
    
        int answer = getAns(0);
        
        return answer;
    }
    
    // 퀸이 서로 공격할 수 없는 위치에 놓이는 경우의 수
    private int getAns(int y){
        int ans = 0;
        
        // 모든 행에 대해서 퀸의 위치가 결정된 경우
        if(y == N){
            ans++; // 해결 가능한 경우의 수 증가
        } 
        
        else{
            // 현재 행에서 퀸이 놓일 수 있는 모든 위치를 시도
            for(int i=0; i<N; i++){
                // 해당 위치에 이미 퀸이 있는 경우, 대각선상에 퀸이 있는 경우 스킵
                if(width[i] || diagonal1[i+y] || diagonal2[i-y+N])
                    continue;
                
                // 해당 위치에 퀸을 놓음
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = true;
                // 다음 행으로 이동하여 재귀적으로 해결 가능한 경우의 수 찾기
                ans += getAns(y+1);
                
                // 해당 위치에 놓인 퀸 제거(백트래킹)
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = false;
            }
        }
        
        return ans;
    }
}