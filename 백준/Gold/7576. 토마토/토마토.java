import java.util.*;
import java.io.*;

// 며칠이 지나면 토마토들이 모두 익는지 최소 일수
// 왼쪽, 오른쪽, 앞, 뒤 네 방향
public class Main {
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, 1, -1};

    public static int M = 0;
    public static int N = 0;
    public static int cnt = 0; 
    public static int answer = 0;
    
    public static int[][] box;
    public static boolean[][] visited;
    public static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        box = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());
                box[i][j] = t;
                
                if(t == 0) // 안익은 토마토 개수
                    cnt++;
            
                else if(t == 1) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true; // 이미 익은 토마토는 방문 X
                }
            }
        }

        if(cnt == 0)
            bw.write(String.valueOf(0));
    
        else{
            bfs();
            
            if(cnt == 0) // 토마토가 다 익은 경우
                bw.write(String.valueOf(answer));
            
            else
                bw.write(String.valueOf(-1));   
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            int time = arr[2];

            answer = time; // 마지막으로 익은 토마토 시간

            for(int i=0; i<4; i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];

                if(isRange(nextX, nextY) && !visited[nextX][nextY] && box[nextX][nextY]==0){
                    cnt--; // 안익은 토마토 개수 감소
                    box[nextX][nextY] = 1; // 익은 걸로 바꿈
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, time+1});
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}