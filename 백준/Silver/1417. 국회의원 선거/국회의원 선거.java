import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int first = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        // 루트가 다솜보다 더 작을 때 까지
        while (!pq.isEmpty() && pq.peek() >= first) {
            pq.add(pq.poll() - 1); // 루트 값 하나 매수
            first++; // 매수한 값(하나) 만큼 다솜이를 늘림

            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
