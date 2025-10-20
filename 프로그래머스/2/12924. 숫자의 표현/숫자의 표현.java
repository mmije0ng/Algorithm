class Solution {
    public int solution(int n) {
        int answer = 1; // 자기 자신 n 포함
        for(int i=1; i<n; i++){
            int sum = 0;
            for(int j=i; j<=n; j++){
                sum +=j;
                if(sum == n){
                    answer++;
                    break;
                }
                
                if(sum>n){
                    break;
                }
            }
        }
        
        
        return answer;
    }
}