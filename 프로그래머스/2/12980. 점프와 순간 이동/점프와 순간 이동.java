public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            int remainder = n % 2;
            n = n / 2; // 순간이동 (절반 이동)
            ans += remainder; // 나머지가 1이면 점프한 것
        }

        return ans;
    }
}
