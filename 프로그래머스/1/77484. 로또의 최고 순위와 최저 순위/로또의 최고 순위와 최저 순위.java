import java.util.*;

// 일치하지 않은 번호들을 모두 맞춘 경우와 (최고)
// 1개만 맞춘 경우 (최저)

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int unknownCnt = 0; // 모르는 번호 개수
        int correctCnt = 0; // 일치하는 번호 개수
        
        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }
        
        // 모르는 번호(0) 개수 계산
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0)
                unknownCnt++;
        }
        
        // 일치하는 번호 개수 계산
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] != 0 && winSet.contains(lottos[i]))
                correctCnt++;
        }
        
        int max = correctCnt + unknownCnt; // 최대 맞춘 개수
        int min = correctCnt; // 최소 맞춘 개수
        answer[0] = 7-max == 7 ? 6 : 7-max;
        answer[1] = 7-min == 7 ? 6 : 7-min;    

        return answer;
    }
}