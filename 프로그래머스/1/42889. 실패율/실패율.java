import java.util.*;

class Solution {
    // 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 실패율 저장 리스트
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        List<StageFail> failedList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int notCleardPlayer = 0;
            int stagedPlayer = 0;
            for (int j = 0; j < stages.length; j++) {
                // 스테이지에 도달한 플레이어 수 증가
                if (i + 1 <= stages[j]) {
                    stagedPlayer++;
                }
                // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 증가
                if (i + 1 == stages[j]) {
                    notCleardPlayer++;
                }
            }
            
            double failRate = (stagedPlayer == 0) ? 0.0 : (double)notCleardPlayer / stagedPlayer;
            failedList.add(new StageFail(i + 1, failRate));
        }
        
        Collections.sort(failedList);
        for(int i=0; i<N; i++){
            answer[i] = failedList.get(i).stage;
        }
        
        // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
        return answer;
    }
    
    static class StageFail implements Comparable<StageFail> {
        int stage;
        double failRate;
        StageFail(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
        
        @Override
        public int compareTo(StageFail o) {
            // 실패율 내림차순, 실패율 같으면 스테이지 번호 오름차순
            if (this.failRate == o.failRate) {
                return Integer.compare(this.stage, o.stage);
            }
            return Double.compare(o.failRate, this.failRate);
        }
    }
}