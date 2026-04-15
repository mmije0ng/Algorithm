import java.util.*;
import java.io.*;

// 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대 몇개인지
// 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정
// bfs로 장마양보다 높은 지점들 연속해서 탐색, 최종 탐색 끝난 후 count

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int N = 0;
    static int maxHeight = 0;
    static int answer = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited = new boolean[N][N];
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

         for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        
        for (int rain = 0; rain <= maxHeight; rain++) {
            visited = new boolean[N][N];
            int count = 0;
        
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > rain) {
                        bfs(i, j, rain);
                        count++;
                    }
                }
            }
        
            answer = Math.max(answer, count);
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y, int rain){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] arr = q.poll();
            for(int i=0; i<4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny]>rain){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean isRange(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N)
            return true;
        return false;
    }
}