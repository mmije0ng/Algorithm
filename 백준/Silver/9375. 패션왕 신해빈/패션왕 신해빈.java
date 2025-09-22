import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            HashMap<String, Integer> hashMap = new HashMap<>(); // <종류, 개수>
            int N = Integer.parseInt(br.readLine());

            for (int j=0; j<N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();
                hashMap.put(type, hashMap.getOrDefault(type, 0)+1); 
            }

            int answer = 1;
            for (int val : hashMap.values())
                answer *= val + 1;
            bw.write(String.valueOf(answer - 1));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
  }
}
