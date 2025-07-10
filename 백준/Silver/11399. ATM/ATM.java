import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        int total = 0;
        int prev = 0; // 이전 사람들이 기다린 총 시간
        for (int j = 0; j < N; j++) {
            total += arr[j] + prev;
            // 이 전 사람들이 총 기다린 시간에 내 시간을 더함
            // 다음 순서 사람 기준에서는 해당 사람 기준에서 앞에 사람들이 총 기다린 시간
            prev += arr[j]; 
        }
        bw.write(String.valueOf(total));
        
        bw.flush();
        bw.close();
        br.close();
    }
}