import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        // 최대 중량 계산
        int max = 0;
        for (int i = 0; i < N; i++) {
            int weight = arr[i] * (i + 1);
            max = Math.max(max, weight);
        }

        bw.write(String.valueOf(max));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
