import java.util.*;
import java.io.*;

public class Main {
    // R 또는 G일 경우 DFS 계속 탐색
    // B일 경우 DFS 계속 탐색
    
    public static int N = 0;
    public static char[][] arr;
    public static boolean[][] visited;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    cnt++;
                    dfs(i, j, arr[i][j], false);
                }
            }
        }

        int sCnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    sCnt++;
                    dfs(i, j, arr[i][j], true);
                }
            }
        }

        bw.write(String.valueOf(cnt) + " ");
        bw.write(String.valueOf(sCnt));
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, char c, boolean isColor) {
        if (x >= N || y >= N)
            return;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (isRange(nx, ny) && !visited[nx][ny]) {
                char nc = arr[nx][ny];

                if (isColor) { // 색약일경우
                    if ((c == 'R' && nc == 'G') || (c == 'G' && nc == 'R') ||
                        (c == 'G' && nc == 'G') || (c == 'R' && nc == 'R')) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, nc, isColor);
                    } 
                    else if (c == 'B' && nc == 'B') {
                        visited[nx][ny] = true;
                        dfs(nx, ny, nc, isColor);
                    }
                } 
                else {
                    if (c == 'R' && nc == 'R') {
                        visited[nx][ny] = true;
                        dfs(nx, ny, nc, isColor);
                    } 
                    else if (c == 'G' && nc == 'G') {
                        visited[nx][ny] = true;
                        dfs(nx, ny, nc, isColor);
                    } 
                    else if (c == 'B' && nc == 'B') {
                        visited[nx][ny] = true;
                        dfs(nx, ny, nc, isColor);
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N)
            return true;
        return false;
    }
}