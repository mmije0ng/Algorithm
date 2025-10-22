class Solution {
    int[] data = new int[100001];
    
    public int solution(int n) {
        int answer = fib(n);
        return answer;
    }
    
    int fib(int num){
        if(num <=1)
            return num;
        if(data[num] != 0)
            return data[num]%1234567;
        
        return data[num] = (fib(num-2) + fib(num-1)) %1234567;
    }
}