import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        while (!queue.isEmpty()) {
            bw.write(queue.poll() + " "); 
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
