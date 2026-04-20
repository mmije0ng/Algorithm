import java.util.*;
import java.io.*;

// bfs로 돌면서
// 현재 봉우리보다 높은 곳을 발견하면 봉우리 변경
// “같은 높이로 연결된 한 덩어리”를 찾고,
// 그 덩어리 주변에 더 높은 칸이 있는지 검사

public class Main {
    static int N, M = 0;
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    bfs(i, j, map[i][j]);
                }
            }
        }

        bw.write(String.valueOf(cnt));
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y, int start){
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        
        boolean isPeak = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            
            for(int i=0; i<8; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                
                if (!isRange(nx, ny)) continue;
                int next = map[nx][ny];

                // 더 높은 곳을 발견하면 시작점은 봉우리가 아님
                if (next > start) 
                    isPeak = false;

                // 탐색점과 인접한, 값이 같은 
                if(!visited[nx][ny] && start==next){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // 탐색점에서부터 bfs 완료 후, 더 높은 봉우리를 찾지 못한경우
        // 탐색점이 봉우리
        if(isPeak) cnt++;
    }

    static boolean isRange(int x, int y){
        if (x >= 0 && x < N && y >= 0 && y < M)
            return true;
        return false;
    }
}