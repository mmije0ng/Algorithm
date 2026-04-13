import java.util.*;
import java.io.*;

// 백신: 퍼졌을 때 원래의 값과 동이한 경우
// 격자의 칸 중 하나에 항체가 생성
// 현재 속해 있는 칸과 같은 데이터 값을 가짐
// 인접한 칸이 있을 경우 그 칸으로 퍼져나감

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int N, M = 0;
    static int[][] originMap;
    static int[][] newMap;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];
        newMap = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                newMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isFirst = true;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 두 맵의 숫자가 다른 경우 중 첫 좌표일경우
                if(isFirst && originMap[i][j] != newMap[i][j]){
                    bfs(i, j, originMap[i][j], newMap[i][j]);
                    originMap[i][j] = newMap[i][j];
                    isFirst = false;
                }
            }
        }

        boolean isVac = true;
        // 탐색 다 끝나고 같지 않은 경우가 있다면 백신 X
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(originMap[i][j] != newMap[i][j]){
                    isVac = false;
                    break;
                }
            }
        }

        String result = isVac ? "YES" : "NO";
        bw.write(result);        
        
        bw.flush();
        bw.close();
        br.close();
    }

    // originMap -> 백신 맞은 경우로 변경
    // originMap의 숫자가 before와 같을 때 (백신을 맞은 경우, 백신 영역으로 바뀌는 부분)
    // bfs로 탐색하면서 originMap으로 숫자를 newMap의 백신 숫자 after로 바꿈
    static void bfs(int x, int y, int before, int after){
        Queue<int[] > q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            for(int i=0; i<4; i++){
                int nx = arr[0]+dx[i];
                int ny = arr[1]+dy[i];
    
                if(isRange(nx, ny) && !visited[nx][ny] && originMap[nx][ny] == before){
                    visited[nx][ny] = true; 
                    originMap[nx][ny] = after;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean isRange(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M)
            return true;
        return false;
    }
}