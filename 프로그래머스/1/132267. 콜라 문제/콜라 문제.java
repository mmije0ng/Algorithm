// 콜라를 받기 위해 마트에 주어야 하는 병 수 a
// 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            answer+=n/a*b;
            n=n%a + (n/a*b);
        }
        
        return answer;
    }
}