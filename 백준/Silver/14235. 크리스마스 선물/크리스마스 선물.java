import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 0) {
                if (pq.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(pq.poll()));
                }
                bw.newLine();
            } else {
                for(int j=0; j<command; j++){
                  pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
