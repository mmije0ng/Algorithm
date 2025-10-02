class Solution
{
    // n=8, a=4, b=7
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a!=b){
            a = a/2 + a%2; // 2, 1, 1
            b = b/2 + b%2; // 4, 2, 1
            
            answer++;
        }      

        return answer;
    }
}