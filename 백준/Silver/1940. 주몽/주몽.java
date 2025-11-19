import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list); // 1, 2, 3, 4, 5, 7
        int count = 0;
        boolean[] isComplete = new boolean[N];
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(!isComplete[i] && !isComplete[j] 
                   && (list.get(i)+list.get(j)) == M){
                    count++;
                    // System.out.println("i == " + i +", j == " + j);
                    isComplete[i] = true;
                    isComplete[j] = true;
                }
            }
        }

        bw.write(String.valueOf(count));
        
        bw.flush();
        bw.close();
        br.close();
  }
}
