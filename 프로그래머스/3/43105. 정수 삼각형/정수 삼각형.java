class Solution {
    int[][] dp;   // 메모이제이션 배열
    int[][] tri;  // 원본 삼각형 데이터
    
    public int solution(int[][] triangle) {
        tri = triangle;
        dp = new int[triangle.length][];
        
        for (int i = 0; i < triangle.length; i++)
            dp[i] = new int[triangle[i].length];
        
        return dfs(0, 0);  // 0행 0열에서 시작
    }
    
    // row, col 위치에서 시작해서 얻을 수 있는 최대 점수
    private int dfs(int row, int col) {
        if (row == tri.length - 1) {
            return tri[row][col];
        }
        
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        
        // 아래(row+1, col)와 오른쪽 아래(row+1, col+1) 중 큰 값 선택
        int left = dfs(row + 1, col);
        int right = dfs(row + 1, col + 1);
        
        // 현재 값 + 둘 중 큰 값
        dp[row][col] = tri[row][col] + Math.max(left, right);
        
        return dp[row][col];
    }
}