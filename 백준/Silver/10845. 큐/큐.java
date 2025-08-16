import java.io.*;
import java.util.*;

/**
 * 큐 명령어 처리 프로그램
 * - 명령어: push, pop, size, empty, front, back
 * - 입력: 첫 줄에 명령어 개수 n, 이후 n개의 명령어
 * - 출력: 각 명령어 실행 결과
 */
public class Main {

    static Deque<Integer> q = new ArrayDeque<>();
    
    static StringBuilder sb = new StringBuilder();
    
    // 마지막으로 push된 값을 저장해 back() 호출 시 사용
    static int last = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            // push 명령어: "push X"
            if (line.startsWith("push")) {
                int x = Integer.parseInt(line.substring(5)); // "push " 뒤의 숫자 추출
                push(x);
            } 
            // 나머지 단일 명령어 처리
            else {
                switch (line) {
                    case "pop":   pop();   break;
                    case "size":  size();  break;
                    case "empty": empty(); break;
                    case "front": front(); break;
                    case "back":  back();  break;
                    default: // 잘못된 입력은 무시
                }
            }
        }

        // 출력
        bw.write(sb.toString());
        bw.flush();

        // 자원 해제
        bw.close();
        br.close();
    }

    /** 큐에 원소 삽입 */
    static void push(int x) {
        q.addLast(x);  // 큐의 뒤에 삽입
        last = x;      // 마지막 값 갱신
    }

    /** 큐에서 첫 번째 원소 제거 및 출력 */
    static void pop() {
        if (q.isEmpty()) {
            sb.append("-1\n"); // 비어있으면 -1
        } else {
            int val = q.removeFirst(); // 첫 원소 제거 후 반환
            sb.append(val).append('\n');
            if (q.isEmpty()) last = -1; // 큐가 비면 last 무효화
        }
    }

    /** 큐 크기 출력 */
    static void size() {
        sb.append(q.size()).append('\n');
    }

    /** 큐가 비어있으면 1, 아니면 0 출력 */
    static void empty() {
        sb.append(q.isEmpty() ? 1 : 0).append('\n');
    }

    /** 큐의 첫 번째 원소 출력 */
    static void front() {
        if (q.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(q.peekFirst()).append('\n'); // 첫 원소 조회
        }
    }

    /** 큐의 마지막 원소 출력 */
    static void back() {
        if (q.isEmpty()) {
            sb.append("-1\n");
        } else {
            // ArrayDeque의 peekLast()로도 가능하지만 last 캐시 사용
            sb.append(last).append('\n');
        }
    }
}
