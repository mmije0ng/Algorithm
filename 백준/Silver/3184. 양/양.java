import java.util.*;
import java.io.*;

// 양은 늑대에게 싸움을 걸 수 있고 
// 영역 안의 양의 수가 늑대의 수보다 많다면 늑대를 우리에서 쫓아내 이김
// 울타리가 아닌, . 영역에서 bfs 탐색
// 양과 늑대 수 계산 -> 늑대가 더 많다면 양 개수 삭제
// 양이 더 많다면 늑대 개수 삭제

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int R, C = 0; // 행, 열
    static char[][] map;
    static boolean[][] visited;
    static int wolf, sheep = 0;
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                map[i][j] = c;

                if(c == 'v') wolf++;
                else if(c == 'o') sheep++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != '#' && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(i, j, map[i][j]);
                }
            }
        }

        bw.write(String.valueOf(sheep) + " ");
        bw.write(String.valueOf(wolf));
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y, char c){
        int wolfCnt = 0;
        int sheepCnt = 0;

        if(c == 'v') wolfCnt++;
        else if(c == 'o') sheepCnt++;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(c, x, y));

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(isRange(nx, ny) && !visited[nx][ny]){
                    char nc = map[nx][ny];
                    visited[nx][ny]  = true;
                    if(nc == '#') continue; // 울타리
                     
                    q.add(new Node(nc, nx, ny));
                    
                    if(nc == 'v') // 늑대
                        wolfCnt++;

                    else if(nc == 'o') // 앵
                        sheepCnt++;
                }
            }
        }

        if(wolfCnt >= sheepCnt)
            sheep -= sheepCnt;
        else if (wolfCnt < sheepCnt)
            wolf -= wolfCnt;
    }

    static boolean isRange(int x, int y){
        if(x>=0 && x<R && y>=0 && y<C)
            return true;
        return false;
    }

    static class Node{
        char c;
        int x;
        int y;

        Node(char c, int x, int y){
            this.c = c;
            this.x = x;
            this.y = y;
        }
    }
}