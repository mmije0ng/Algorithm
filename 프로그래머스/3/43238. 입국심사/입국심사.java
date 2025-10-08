// left
// 탐색 범위의 하한(lower bound). 이 코드에서는 0으로 시작.
// (즉, 최소 가능 시간 — 절대값으로는 0초 이상)

// right
// 탐색 범위의 상한(upper bound). 코드에서는 right = max(times) * (long)n 으로 초기화.
// (가장 느린 심사관이 n명을 전부 처리한다고 가정한 최악의 시간 — 안전한 상한)

// mid
// left와 right의 중간값 경과시간(후보 시간). 이 시간이 충분한지 검사해서 범위를 좁혀나감.

// 예시(n=6, times=[7,10])
// mid = 28일 때:
// 심사관1: 28 / 7 = 4명
// 심사관2: 28 / 10 = 2명
// 합 = 6 → mid = 28이면 6명 처리 가능 → 충분

// mid = 27일 때:
// 27 / 7 = 3, 27 / 10 = 2 → 합 = 5 → 부족

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        // 각 심사대의 처리시간을 오름차순 정렬
        // 정렬하면 times[times.length-1]가 가장 느린 심사대의 시간(=max)
        Arrays.sort(times);

        long left = 0;
        // 우상한: 모든 사람이 가장 느린 심사대에 걸린다고 가정한 시간
        // (long) 캐스팅으로 int*n의 오버플로우를 방지
        long right = times[times.length-1] * (long)n; //모든 사람이 가장 느리게 심사받음

        // 이분 탐색: left..right 사이에서 '모든 사람을 심사할 수 있는 최소 시간'을 찾는다
        while(left <= right) {
            long mid = (left + right) / 2; // 현재 검사할 시간 후보
            long complete = 0;

            // mid 시간 동안 각 심사관이 검사할 수 있는 사람 수를 합산
            for (int i = 0; i < times.length; i++)
                complete += mid / times[i]; 

            if (complete < n) // 해당 시간에는 모든 사람이 검사받을 수 없다.
                left = mid + 1; // 시간을 더 늘려야 함
            else {
                // mid 시간에 n명 이상 검사 가능 → 답 후보(더 작은 시간 있는지 탐색)
                right = mid - 1;
                answer = mid; // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
            }
        }
        return answer;
    }
}
