class Solution {
    public int solution(int num) {
        if(num == 1)
            return 0;
        
        int answer = 0;
        long longNum = num;
        
        while(longNum != 1 && answer<500){
            if(longNum%2 == 0)
                longNum/=2;
            else if(longNum%2 == 1)
                longNum = longNum*3 + 1;
            else // num == 1
                return 0;
            answer++;
        }
        
        if(answer == 500)
            answer = -1;
        
        return answer;
    }
}