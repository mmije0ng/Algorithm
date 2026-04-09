import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 전자기기 개수
        int M = Integer.parseInt(st.nextToken()); // 콘센트 개수
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        // 충전에 필요한 시간
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());
        // 8 4 4 1 1

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            // time: 4, 8, 8
            // q: (8) -> (4, 8) -> (8, 8) -> (8, 9) -> (8, 9)
            
            if(pq.size() == M)
                time = pq.poll();
            
            pq.add(time + list.get(i));
        }

        while(!pq.isEmpty())
            time = pq.poll();

        bw.write(String.valueOf(time));
        
        bw.flush();
        bw.close();
        br.close();
    }
}