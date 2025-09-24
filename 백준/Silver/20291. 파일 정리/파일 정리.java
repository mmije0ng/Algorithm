import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(),".");
            String title = st.hasMoreTokens() ? st.nextToken() : null;
            String file = st.hasMoreTokens() ? st.nextToken() : null;

            map.put(file, map.getOrDefault(file, 0)+1);
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list); // 사전순으로 key 정렬
        
        for (String file : list) {
            int count = map.get(file);
            bw.write(file + " " + count);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
  }
}
