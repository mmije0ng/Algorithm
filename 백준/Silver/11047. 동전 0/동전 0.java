import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 동전 종류 개수
        int K = Integer.parseInt(st.nextToken()); // 만들어야하는 동전 가치 합
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Collections.reverseOrder());
        int sum = 0; // 현재 합계
        int count = 0; // 현재 동전 개수
        int kRest = K; // 남은 금액
        for(int i=0; i<list.size(); i++){
            int unit = list.get(i);
            if(sum+unit>K)
                continue;
            else{
                int money = kRest/unit;
                int rest = kRest%unit;
                
                sum+=rest;
                count+=money;
                kRest = rest;
            }

            if(sum==K)
                break;
        }

        bw.write(String.valueOf(count));
        
        bw.flush();
        bw.close();
        br.close();
  }
}
