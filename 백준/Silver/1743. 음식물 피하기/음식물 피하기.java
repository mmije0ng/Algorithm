import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    
    public static int N = 0; // 가로
    public static int M = 0; // 세로
    public static int K = 0; // 음식물
    public static int[][] arr;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 1;
        }

        int cnt = 0;
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    visited[i][j] = true;
                    answer.add(dfs(i, j, cnt+1));
                }
            }
        }

        Collections.sort(answer, Collections.reverseOrder());

        bw.write(String.valueOf(answer.get(0)));
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int x, int y, int cnt){
        if(x>N || y>M)
            return cnt;
        
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(isRange(nx, ny) && !visited[nx][ny] && arr[nx][ny]==1){
                visited[nx][ny] = true;
                cnt = dfs(nx, ny, cnt+1);
            }
        }

        return cnt;
    }

    public static boolean isRange(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M)
            return true;
        return false;
    }
}