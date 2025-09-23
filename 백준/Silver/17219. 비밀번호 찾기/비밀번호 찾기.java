import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
        int M = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String main = st.nextToken();
            String password = st.nextToken();
            
            map.put(main, password);
        }

        for(int i=0; i<M; i++){
            String key = br.readLine();
            bw.write(map.get(key));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
  }
}
