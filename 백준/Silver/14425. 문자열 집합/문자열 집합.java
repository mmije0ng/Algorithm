import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
        int M = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

        int answer = 0;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        for(int i=0; i<M; i++){
            if(set.contains(br.readLine()))
                answer++;
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
  }
}
