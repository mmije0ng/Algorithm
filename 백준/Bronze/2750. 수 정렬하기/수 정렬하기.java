import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Integer[] nums = new Integer[n];        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(nums);

        // 정렬된 값 출력
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(nums[i]));
            bw.newLine();
        }

        // 버퍼 닫기
        bw.flush();
        br.close();
        bw.close();
    }
}