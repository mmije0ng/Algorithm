import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                // 절댓값이 같으면 음수를 반환하여 n1이 음수이면 음수, 양수이면 양수 반환
                if (Math.abs(n1) == Math.abs(n2)) {
                    return n1 - n2;
                }
                return Math.abs(n1) - Math.abs(n2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty())
                    sb.append("0").append("\n");
                else
                    sb.append(pq.poll()).append("\n");
            }
            
            else
                pq.offer(x);
        }

        System.out.print(sb);
    }
}
