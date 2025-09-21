import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int N = Integer.parseInt(br.readLine());
      int count = 0;
      for(int i=0; i<N; i++){
          Stack<Character> stack = new Stack<>();
          String str = br.readLine();
          
          for(int j=0; j<str.length(); j++){
              char c = str.charAt(j);
              if(!stack.isEmpty() && stack.peek() == c){
                  stack.pop();
              }
              else{
                  stack.add(c);
              }
          }

          if(stack.isEmpty())
                  count++;
          // System.out.println(stack);
      }

      bw.write(String.valueOf(count));
      
      bw.flush();
      bw.close();
      br.close();
  }
}
