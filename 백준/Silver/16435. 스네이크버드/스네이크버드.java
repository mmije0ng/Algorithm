import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 오름차순 정렬
        Collections.sort(arr);

        for (int i = 0; i < N; i++) {
            // 스네이크 길이가 배열 원소의 길이보다 작아지면 더 이상 과일을 먹을 수 없음
            if (L < arr.get(i)) {
                break;
            }
            // 스네이크 길이가 배열 원소의 길이보다 크면 과일 한 개를 먹음
            L++;
        }

        bw.write(String.valueOf(L));

        bw.flush();
        bw.close();
        br.close();
    }
}
