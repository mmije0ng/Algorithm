import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(String.valueOf(pq.poll()));
                    bw.write("\n");
                }
            } else {
                pq.offer(command);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
