import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashSet<String> set = new HashSet<>(); // 중복을 허용하지 않는 HashSet 사용
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0; i<N; i++){
            String chat = br.readLine();
            
            if(!chat.equals("ENTER")){
                if(!set.contains(chat)){
                    set.add(chat);
                    answer++;
                }
                else
                    continue;
            }

            else { // ENTER
                set.clear(); // 초기화
            }
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
  }
}
