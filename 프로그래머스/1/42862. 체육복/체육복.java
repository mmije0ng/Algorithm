import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int borrowCount = 0; // 빌려준횟수
        int lostLen = lost.length;
        int reserveLen = reserve.length;
        boolean[] isLostBorrowd = new boolean[lostLen]; // 잃어버렸다가 빌린 학생들
        boolean[] isBorrowed = new boolean[reserveLen]; //빌려줘서 여분이 없어진 학생들
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
        // 다른 학생에게는 체육복을 빌려줄 수 없음
        // 여벌은 본인이 가지는 것이기 때문에 이미 빌린 학생으로 처리
        for(int i=0; i<lostLen; i++){
            for(int j=0; j<reserveLen; j++){
                if(lost[i] == reserve[j]){
                    isBorrowed[j] = true;
                    isLostBorrowd[i] = true;
                    borrowCount++;
                }
            }
        }
        
        for(int i=0; i<lostLen; i++){
            for(int j=0; j<reserveLen; j++){
                if(!isBorrowed[j] && !isLostBorrowd[i] 
                   && (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) ){
                    isBorrowed[j] = true;
                    isLostBorrowd[i] = true;
                    borrowCount++;
                }
            }
        }
                
        return n-lostLen+borrowCount;
    }
}