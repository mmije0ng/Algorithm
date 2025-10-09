import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 무지개 댄스를 추지 않고 있던 사람이 무지개 댄스를 추고 있던 사람을 만나게 된다면, 
        // 만난 시점 이후로 무지개 댄스를 추게 된다
        // 기록이 시작되기 이전 무지개 댄스를 추고 있는 사람은 총총이 뿐이라고 할 때, 
        // 마지막 기록 이후 무지개 댄스를 추는 사람이 몇 명인지

        int N = Integer.parseInt(br.readLine()); // 사람들이 만난 기록의 수
        HashMap<String, String> map = new HashMap<>(); // <나(총총이가 된 사람), 나를 총총이로 만든>
        map.put("ChongChong", "ChongChong");
        int count = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String me = st.hasMoreTokens() ? st.nextToken() : null;
            String other = st.hasMoreTokens() ? st.nextToken() : null;

            if(map.containsKey(other) || map.containsKey(me)){
                map.put(me, other);
                map.put(other, me);
                // bw.write("me: " + me + "\n");
                // bw.write("other: " + other + "\n");
            }
        }

        bw.write(String.valueOf(map.size()) + "\n");
        
        bw.flush();
        bw.close();
        br.close();
  }
}
