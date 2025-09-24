import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length()+1; j++){
                // bw.write(s.substring(i,j));
                // bw.newLine();
                // substring(i, i) → 시작과 끝이 같으면 빈 문자열("")을 반환
                set.add(s.substring(i,j));
            }
        }
        bw.write(String.valueOf(set.size()));
        
        bw.flush();
        bw.close();
        br.close();
  }
}
