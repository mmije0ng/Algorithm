class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
        int[] dp = new int[n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) dp[i] = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(dp[i] == Integer.MAX_VALUE)
                continue;
            
            for(String word: strs){
                int len = word.length();
                
                // apple
                // n == 5
                // "app" i = 0, len = 3, dp[3]=Math.min(dp[0]+1, dp[3]) (1, max)
                // "ap" i = 0, len = 2, dp[2]=Math.min(dp[0]+1, dp[3]) (1, max)
                // "ple" i = 2, len = 3, dp[5]=Math.min(dp[2]+1, dp[5]) (2, max)
                // "l" i = 3, len = 1, dp[4]=Math.min(dp[3]+1, dp[4]) (2, max)
                // "e" i = 4, len = 1, dp[5]=Math.min(dp[4]+1, dp[5]) (3, 2)
                
                if(i+len<=n && t.substring(i, i+len).equals(word)){
                    dp[i+len] = Math.min(dp[i]+1, dp[i+len]);
                    
                    // for(int k=0; k<dp.length; k++){
                    //     System.out.println("dp[" + k +"] == " + dp[k]);
                    // }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
