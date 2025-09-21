import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      Queue<Integer> queue = new ArrayDeque<>();
      int N = Integer.parseInt(br.readLine());
      
      while(true){
          int num = Integer.parseInt(br.readLine());
          if(num == -1)
              break;
          
          if(num!=0){
              if(queue.size() >= N) // 버퍼가 다 찬 경우
                  continue;
              else
                  queue.add(num);
          }
            
          else
              queue.poll();
      }

      if(queue.isEmpty())
          bw.write("empty");
      else{
          while(!queue.isEmpty()){
              bw.write(String.valueOf(queue.poll()) + " ");
          }
      }

      
      bw.flush();
      bw.close();
      br.close();
  }
}
