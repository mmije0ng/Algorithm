import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 첫 번째 배열 길이
        int m = Integer.parseInt(st.nextToken());  // 두 번째 배열 길이

        int[] arr = new int[n + m];  // 합쳐질 배열

        st = new StringTokenizer(br.readLine());  // 첫 번째 배열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());  // 두 번째 배열 입력
        for (int i = 0; i < m; i++) {
            arr[n + i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 정렬

        StringBuilder sb = new StringBuilder();
        for (int r : arr) {
            sb.append(r).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
