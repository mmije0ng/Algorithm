import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;
        
        // 1 3 5 7
        // 2 2 6 8
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(aIndex < A.length && bIndex < B.length){
            if (B[bIndex] > A[aIndex]) {
                bIndex++;
                aIndex++;
                answer++;
            }
            
            else bIndex++;
        }
        
        return answer;
    }
}