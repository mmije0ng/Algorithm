import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        for (Integer num : set) {
            bw.write(num.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
