import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N  = Integer.parseInt(st.nextToken());  
        int M  = Integer.parseInt(st.nextToken());  

        List<Integer> list = new ArrayList<>();
        int count = 0;
        st = new StringTokenizer(br.readLine(), " "); 
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());  
            list.add(number);
        }

        if (list.size() == 1) {
            bw.write(String.valueOf(count));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        Collections.sort(list);
        int left = 0;
        int right = list.size()-1;
        while(left < right){
            if (list.get(left) + list.get(right) >= M) {
                count++;
                left++;
                right--;
            }
            else {
                left++;
            }
        }
        bw.write(String.valueOf(count));
        
        bw.flush();
        bw.close();
        br.close();
    }
}
