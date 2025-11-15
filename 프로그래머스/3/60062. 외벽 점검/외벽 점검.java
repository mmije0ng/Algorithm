// 최소한의 친구들을 투입해 취약 지점을 점검하고 나머지 친구들은 내부 공사
// 친구들은 출발 지점부터 시계, 혹은 반시계 방향으로 외벽을 따라서만 이동

import java.util.*;

class Solution {

    int[][] weakCases; // weak 지점의 회전(시작점 변경) 모든 경우를 저장하는 배열
    int answer; // 최소 필요한 친구 수

    public int solution(int n, int[] weak, int[] dist) {
        int weakLength = weak.length;
        int distLength = dist.length;
        weakCases = new int[weakLength][weakLength];

        // 정답 초기값: dist 길이 + 1 (절대 나올 수 없는 큰 값)
        answer = distLength + 1;

        // weak 회전 경우 생성
        makeWeakCases(weak, n);

        // dist 배열의 모든 순열 생성 + 각각을 weakCases에 적용해 검사
        makeDistPermutations(dist, new boolean[distLength], new int[distLength], 0);

        // 모든 경우를 검사했는데도 answer가 갱신되지 않았다면 -1
        return (answer == distLength + 1) ? -1 : answer;
    }

    // weak 배열을 회전하여 모든 시작점에 대한 weak 배열 생성
    // [1,5,6,10] → [5,6,10,13] → [6,10,13,17] …
    // 원형 구조를 일직선 구조로 펼치기 위해 마지막 요소는 n을 더해서 보정함
    void makeWeakCases(int[] weak, int n) {
        int len = weak.length;
        int[] rotated = weak.clone(); // 현재 회전 상태

        // 첫 번째 경우는 그대로
        weakCases[0] = rotated.clone();

        // 총 len-1번 회전
        for (int i = 1; i < len; i++) {
            // 첫 번째 요소를 제거하고 뒤로 보내되, 위치는 n을 더해 원형 보정
            int first = rotated[0];
            for (int j = 1; j < len; j++) {
                rotated[j - 1] = rotated[j];
            }
            rotated[len - 1] = first + n;

            weakCases[i] = rotated.clone();
        }
    }

    // dist 배열의 모든 순열 생성 → 각 순열(dist_case)에 대해 weakCases 검사
    // distVisit: 방문 여부, distCase: 현재 생성 중인 순열, idx: distCase에 채우는 진행 인덱스
    void makeDistPermutations(int[] dist, boolean[] distVisit, int[] distCase, int idx) {
        if (idx == dist.length) {
            // 완성된 순열에 대해 모든 weak 회전 케이스 검사
            for (int[] weakCase : weakCases) {
                checkCover(distCase, weakCase);
            }
            return;
        }

        // 순열 생성
        for (int i = 0; i < dist.length; i++) {
            if (!distVisit[i]) {
                distVisit[i] = true;
                distCase[idx] = dist[i];

                makeDistPermutations(dist, distVisit, distCase, idx + 1);

                distCase[idx] = 0;
                distVisit[i] = false; // 백트래킹
            }
        }
    }

    // distCase(친구 배치 순서)가 weakCase를 커버할 수 있는지 검사
    // cur: 현재 커버해야 할 weak index, distIdx: 현재 친구 인덱스
    // 현재 친구는 weakCase[cur] 위치에서 출발해 weakCase[cur] + distCase[distIdx]까지 커버 가능
    void checkCover(int[] distCase, int[] weakCase) {
        int cur = 0; // 현재 커버해야 하는 weak index
        int distIdx = 0; // 현재 사용 중인 친구 인덱스

        while (cur < weakCase.length && distIdx < distCase.length) {
            int range = weakCase[cur] + distCase[distIdx];  // 현재 친구의 커버 가능한 최대 범위
            int next = cur + 1;

            // range 안에 있는 weak 지점은 모두 이 친구가 커버 가능
            while (next < weakCase.length && weakCase[next] <= range) {
                next++;
            }

            cur = next; // 다음 커버해야 하는 weak index 로 이동
            distIdx++; // 다음 친구로 이동
        }

        // 모든 weak 지점을 커버(cur==전체 길이)했고
        // 이번 distIdx(사용된 친구 수)가 최소라면 answer 갱신
        if (cur == weakCase.length) {
            answer = Math.min(answer, distIdx);
        }
    }
}
