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

        // 정렬 (이분 탐색을 위해 필수)
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
      
        for (int j = 0; j < M; j++) { 
            int value = Integer.parseInt(st.nextToken());
            int result = binarySearch(arr, value);

            if (result != -1)
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 이분 탐색 메서드: 값이 존재하면 인덱스 반환, 없으면 -1 반환
    public static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) { 
            int middle = (low + high) / 2;

            if (arr[middle] < value) 
                low = middle + 1;
            else if (arr[middle] > value) 
                high = middle - 1;
            else 
                return middle;
        }

        return -1;
    }
}
