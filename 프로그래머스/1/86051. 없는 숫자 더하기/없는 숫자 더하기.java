import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int number : numbers)
            set.add(number);
        
        for(int i=0; i<=9; i++){
            if(!set.contains(i))
                answer+=i;
        }

        return answer;
    }
}
