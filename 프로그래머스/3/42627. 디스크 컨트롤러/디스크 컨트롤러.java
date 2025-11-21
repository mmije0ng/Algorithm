import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청 시각 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 2. 작업 대기 큐 (Node의 compareTo 기반)
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int time = 0;      // 현재 시간
        int idx = 0;       // jobs 배열 index
        int count = 0;     // 완료된 작업 수
        int total = 0;     // 총 반환 시간
        int n = jobs.length;

        while (count < n) {
            // 현재 시간까지 도착한 작업 PQ에 넣기
            while (idx < n && jobs[idx][0] <= time) {
                pq.add(new Node(jobs[idx][0], jobs[idx][1], idx));
                idx++;
            }

            if (pq.isEmpty()) {
                // 작업이 아직 도착하지 않음 → 시간 점프
                time = jobs[idx][0];
                continue;
            }

            // PQ에서 우선순위가 가장 높은 작업 꺼냄 (SJF)
            Node now = pq.poll();
            time += now.workTime;                 // 끝나는 시간
            total += (time - now.requestTime);    // 반환시간 = 종료 - 요청
            count++;
        }

        return total / n;
    }
}

class Node implements Comparable<Node> {
    int requestTime; // 요청 시각
    int workTime;    // 소요 시간
    int number;      // 작업 번호 (tie-breaker 용)

    Node(int requestTime, int workTime, int number) {
        this.requestTime = requestTime;
        this.workTime = workTime;
        this.number = number;
    }

    // 작업의 우선순위: workTime → requestTime → number
    @Override
    public int compareTo(Node o) {
        if (this.workTime != o.workTime) {
            return this.workTime - o.workTime;
        }
        if (this.requestTime != o.requestTime) {
            return this.requestTime - o.requestTime;
        }
        return this.number - o.number;
    }
}
