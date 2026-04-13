import java.util.*;
import java.io.*;

// bfs 탐색하면서
// 사각형이 있는 곳이 아닐 경우 +1

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1 };
     
    static int M, N, K = 0;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        int lx, ly, rx, ry = 0;
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
        
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
        
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[M - 1 - y][x] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j]!=1){
                    int cnt = bfs(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        int size = list.size();
        bw.write(String.valueOf(size));
        bw.newLine();

        for(int i=0; i<size; i++){
            bw.write(String.valueOf(list.get(i)) +" ");
        }
            
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int x, int y){
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                
                if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny]!=1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    cnt++;
                }
            }
        }

        return cnt+1;
    }

    static boolean isRange(int x, int y){
        if(x>=0 && x<M && y>=0 && y<N)
            return true;
        return false;
    }
}