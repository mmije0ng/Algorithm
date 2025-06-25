import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            pq.offer(number);
        }

        int total = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b; // 큐의 맨 앞의 두 숫자를 제거해서 더함
            pq.offer(sum); // 더한 값을 다시 큐에 넣음
            total += sum; // 두 값을 더한값을 총 비교횟수에 더함
        }

        bw.write(String.valueOf(total));
        bw.flush(); 
        bw.close();  
        br.close(); 
    }
}
