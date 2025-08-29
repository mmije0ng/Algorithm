import java.util.*;

public class Main {
    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            // 시작 시간 기준 오름차순 정렬
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = sc.nextInt();  // index 값은 사용하지 않음
            int start = sc.nextInt();
            int end = sc.nextInt();
            lectures.add(new Lecture(start, end));
        }

        // 시작 시간 기준 정렬
        Collections.sort(lectures);

        // 우선순위 큐: 강의 끝나는 시간 기준 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int roomCount = 0;

        for (Lecture lec : lectures) {
            if (!pq.isEmpty()) {
                // 가장 빨리 끝나는 강의의 종료 시간이 현재 강의 시작 시간보다 크면, 새로운 강의실 필요
                if (pq.peek() > lec.start) {
                    roomCount++;
                } else {
                    // 기존 강의가 끝났으므로 재사용 가능
                    pq.poll();
                }
            } else {
                // 아무 강의실도 없으면 하나 추가
                roomCount++;
            }
            // 현재 강의의 종료 시간을 우선순위 큐에 삽입
            pq.add(lec.end);
        }

        System.out.println(roomCount);
    }
}
