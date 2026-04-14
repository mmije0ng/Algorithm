import java.util.*;
import java.io.*;

// 가장 비싼 순으로 k개 선택
public class Main {
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long sum = 0;
        
        for(int i=0; i<Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            String key = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            if(q == 1){
                // key가 없다면 최대힙 생성, 있다면 기존 최대힙 반환
                PriorityQueue<Integer> pq = map.getOrDefault(key, new PriorityQueue<>(Collections.reverseOrder()));

                for(int j=0; j<cnt; j++){
                    int value = Integer.parseInt(st.nextToken());
                    pq.add(value);
                }

                map.put(key, pq);
            }

            else{
                PriorityQueue<Integer> pq = map.getOrDefault(key, new PriorityQueue<>(Collections.reverseOrder()));
                
                for(int j=0; j<cnt && !pq.isEmpty(); j++)
                    sum += pq.poll();
            }
        }

        bw.write(String.valueOf(sum));
        
        bw.flush();
        bw.close();
        br.close();
    }
}