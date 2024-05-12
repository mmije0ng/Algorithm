import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); // 인구 수
        int H = Integer.parseInt(st.nextToken()); // 센티키
        int T = Integer.parseInt(st.nextToken()); // 횟수 제한

        // 최대힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++)
            maxHeap.add(Integer.parseInt(br.readLine()));

        int i; // 뿅망치 사용 횟수
        for(i=0; i<T;i++){
            // 최대힙의 가장 맨 앞 원소가 센티키기보다 작다면
            // 최대힙의 나머지 원소들 모두 센티키보다 작음
            if(maxHeap.peek()<H || maxHeap.peek()==1)
                break;

            int top = maxHeap.poll();
            maxHeap.add(top/2);
        }

        if(maxHeap.peek()<H){
            bw.write("YES" + "\n");
            bw.write(Integer.toString(i));
        }

        else{
            bw.write("NO"+"\n");
            bw.write(Integer.toString(maxHeap.peek()));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
