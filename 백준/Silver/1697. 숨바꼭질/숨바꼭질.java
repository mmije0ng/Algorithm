import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치
        
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        queue.add(N);
        visited[N] = 0;
        
        while(!queue.isEmpty()){
            if(visited[K]!= -1)
                break;
            int next = queue.poll();
            
            // 왼쪽
            // 범위 내에 있고, 방문하지 않았다면
            if(next-1 >= 0 && visited[next-1] == -1){
                queue.add(next-1);
                visited[next-1] = visited[next]+1;
            }
            
            // 오른쪽
            if(next+1 <= 100000 && visited[next+1] == -1){
                queue.add(next+1);
                visited[next+1] = visited[next]+1;
            }
            
            // 점프
            if(next*2 <= 100000 && visited[next*2] == -1){
                queue.add(next*2);
                visited[next*2] = visited[next]+1;
            }
        }
        
        bw.write(String.valueOf(visited[K]));
        
        bw.flush();
        bw.close();
        br.close();
    }
}