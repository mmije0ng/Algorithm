import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        HashMap<Long, Integer> hashMap = new HashMap<>(); // <정수, 빈도>
        for(int i=0; i<N; i++){
            Long num = Long.parseLong(br.readLine());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(
            (a, b) -> {
                int freqCompare = hashMap.get(b).compareTo(hashMap.get(a)); // 빈도 내림차순
                if (freqCompare == 0) return a.compareTo(b); // 빈도가 같으면 값 오름차순
                return freqCompare;
            }
        );
        pq.addAll(hashMap.keySet());

        bw.write(String.valueOf(pq.peek()));
        
        bw.flush();
        bw.close();
        br.close();
  }
}
