// -1이 아니면서
// 학교에 도착하기 전 도착할 수 있는 좌표는
// board[i-1][j]와 board[i][j-1] 왼쪽, 위쪽

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0; i<puddles.length; i++) // 웅덩이
            dp[puddles[i][1]][puddles[i][0]] = -1;
        
        dp[1][1] = 1; // 시작점
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j] == -1)
                    continue;
                // 도착점 위
                if(dp[i-1][j] > 0)
                    dp[i][j] += dp[i-1][j]%mod;
                
                // 도착점 왼쪽
                if(dp[i][j-1] > 0)
                    dp[i][j] += dp[i][j-1]%mod;
            }

            // 1111
            // 1-112
            // 1124
        }
        
        return dp[n][m]%mod;
    }
}