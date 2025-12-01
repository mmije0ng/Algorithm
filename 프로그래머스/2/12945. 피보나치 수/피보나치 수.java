class Solution {
    int[] data = new int[100001];
    
    public int solution(int n) {
        int answer = fib(n);
        return answer;
    }
    
    int fib(int n){
        if(n<=1)
            return n;
        else if (data[n]!=0)
            return data[n]%1234567;
        else
            return data[n] = (fib(n-1)+fib(n-2))%1234567;
    }
}