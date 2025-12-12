import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new LinkedList<>();
        for(int i=N-1; i>=0; i--){
            // LinkedList를 이용해 arr[i]가 들어가야 할 위치에서
            // 겹치는 위치가 있다면 뒤로 밀면서 삽입
            // arr[0] = 2, arr[1] = 1, arr[2] = 1, arr[3] = 0
            // 4
            // 4 3
            // 4 2 3
            // 4 2 1 3
            list.add(arr[i], i+1);
        }

        for (int val : list)
            bw.write(val + " ");

        bw.flush();
        bw.close();
        br.close();
  }
}
