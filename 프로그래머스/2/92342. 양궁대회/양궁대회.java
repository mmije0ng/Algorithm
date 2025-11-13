import java.util.*;

class Solution {
    int maxDiff = 0;  // 라이언이 얻을 수 있는 최대 점수 차이
    List<int[]> candidates = new ArrayList<>(); // 최대 점수 차이를 만드는 모든 후보 배열 저장

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11]; // 라이언이 각 점수 구간에 쏜 화살 수
        dfs(0, n, info, ryan);      

        if (candidates.isEmpty()) return new int[]{-1};

        // 점수 차이가 동일한 경우, 낮은 점수(뒤쪽)에 더 많이 맞힌 배열이 우선
        candidates.sort((a, b) -> {
            for (int i = 10; i >= 0; i--) {  // 낮은 점수부터 비교
                if (a[i] != b[i]) return b[i] - a[i];
            }
            return 0;
        });

        return candidates.get(0);           
    }

    private void dfs(int idx, int arrowsLeft, int[] info, int[] ryan) {
        if (idx == 11) { // 0~10점 구간을 모두 탐색한 경우
            // 점수 차이가 같은 경우 더 낮은 점수(0점 쪽)에 화살을 많이 쏜 경우를 우선
            // 남은 화살을 모두 0점(10번 인덱스)에 넣기
            ryan[10] += arrowsLeft; 
            
            evaluate(info, ryan);  // 점수 계산
            ryan[10] -= arrowsLeft; // 넣었던 화살 다시 빼기 (백트래킹)
            return;
        }

        int need = info[idx] + 1; // 라이언이 해당 점수를 얻기 위해 필요한 화살 수

        // 1) 라이언이 해당 점수 구간에서 이기는 경우
        if (arrowsLeft >= need) {            
            ryan[idx] = need;                
            dfs(idx + 1, arrowsLeft - need, info, ryan);
            ryan[idx] = 0;  // 백트래킹
        }

        // 2) 해당 점수를 포기하고 0발 쏘는 경우
        dfs(idx + 1, arrowsLeft, info, ryan);
    }

    private void evaluate(int[] info, int[] ryan) {
        int apeach = 0; // 아파치 점수
        int ryanScore = 0; // 라이언 점수

        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && ryan[i] == 0) continue; // 둘 다 0발이면 점수 없음

            if (ryan[i] > info[i])  // 라이언이 더 많이 쏜 경우 라이언이 점수 획득
                ryanScore += (10 - i);
            else // 그렇지 않으면 아파치가 점수 획득
                apeach += (10 - i);
        }

        int diff = ryanScore - apeach;        
        if (diff <= 0) return; // 라이언이 이기지 못한 경우 제외

        if (diff > maxDiff) { // 새로운 최대 점수 차이를 발견한 경우
            maxDiff = diff;     
            candidates.clear();       
        }

        if (diff == maxDiff) { // 동일한 점수 차이라면 후보 리스트에 추가
            candidates.add(Arrays.copyOf(ryan, 11));
        }
    }
}
