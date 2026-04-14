class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String change = Integer.toString(n, k); // k진법  
        String[] arr = change.split("0");
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("")) continue;
            long num = Long.parseLong(arr[i]);
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime (long a){
        if(a<2) return false;
        
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
}