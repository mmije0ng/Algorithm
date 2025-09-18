import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            deque.add(i+1);
        }

        int[] josephus = new int[N];
        int idx=0;
        while(!deque.isEmpty()){
            for(int i=0; i<K-1; i++){
                deque.addLast(deque.poll());// K-1개의 원소들을 덱의 맨 뒤에 삽입
            }

            josephus[idx++] = deque.poll(); // K번째 원소
        }

        bw.write("<");
        for(int i=0; i<N; i++){
            bw.write(String.valueOf(josephus[i]));
            if(i!=N-1)
                bw.write(", ");
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}