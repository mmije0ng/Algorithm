import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
        int M = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0; // 일을 처리했을 때 감소 수치
        int K = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0; // 완료한 것을 간주하는 수치

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        List<Integer> list = new ArrayList<>(); // 일별로 느낀 만족감 리스트
        int Y = 0; // 오늘의 만족감, 첫째날은 0

        while(!pq.isEmpty()){
            int P = pq.poll(); // 오늘 할 일의 중요도
            Y = Y/2 + P;
            P -= M;
            list.add(Y); // 일별로 느낀 만족감 추가
            
            if(P>K){ // K이하여야 완주한 것, 완주하지 못한 일은 다시 최대힙에
                pq.add(P);
            }
        }

        bw.write(String.valueOf(list.size()) + "\n");
        for(int i=0; i<list.size(); i++){
            bw.write(String.valueOf(list.get(i)) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
  }
}
