import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lentCount = 0; // 빌려준(=해결된) 횟수
        int lostCount = lost.length;
        int reserveCount = reserve.length;
        boolean[] hasBorrowed = new boolean[lostCount]; // 잃어버렸다가 빌린 학생들
        boolean[] hasLent = new boolean[reserveCount];  // 빌려줘서 여분이 없어진 학생들
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
        // 다른 학생에게는 체육복을 빌려줄 수 없음
        // 여벌은 본인이 가지는 것이기 때문에 이미 빌린 학생으로 처리
        for(int i=0; i<lostCount; i++){
            for(int j=0; j<reserveCount; j++){
                if(lost[i] == reserve[j]){
                    hasLent[j] = true;
                    hasBorrowed[i] = true;
                    lentCount++;
                }
            }
        }
        
        for(int i=0; i<lostCount; i++){
            for(int j=0; j<reserveCount; j++){
                // 체육복이 없는 학생이고, 양옆으로 빌릴 수 있는 경우
                if(!hasLent[j] && !hasBorrowed[i] 
                   && (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) ){
                    hasLent[j] = true;
                    hasBorrowed[i] = true;
                    lentCount++;
                }
            }
        }
                
        return n-lostCount+lentCount;
    }
}
