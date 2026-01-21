import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        // i: 7 -> 3 -> -1
        // i-m: 3, -1
        for(int i=score.length; i>=m; i-=m)
            answer += score[i-m]*m;
        
        return answer;
    }
}