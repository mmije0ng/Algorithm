public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(n > 0){
            if(n%2==1){
                // 1을 빼고 건전지 사용량을 1 더하기
                n--;
                ans++;
            }
            else
                n/=2;
        }

        return ans;
    }
}
