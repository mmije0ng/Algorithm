import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N][M];
        // 한 줄씩 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 예: "101111"
            for (int j = 0; j < M; j++) {
                // 문자를 숫자로 변환 ('0' = 48)
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        int[] dX = {1, 0, -1, 0};
        int[] dY = {0, 1, 0, -1};
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        
        int[][] visited = new int[N][M];
        visited[0][0] = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];
            
            for(int i=0; i<4; i++){
                int nX = cX + dX[i];
                int nY = cY + dY[i];

                if(nX>N-1 || nX<0 || nY>M-1 || nY<0)
                    continue;
                
                if(visited[nX][nY]==0 && miro[nX][nY]==1){
                    visited[nX][nY] = visited[cX][cY]+1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }

        int answer = visited[N-1][M-1];
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
