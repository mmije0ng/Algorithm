import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    
    static int N, M;
	static char[][] map;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new char[N][M];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++)
                map[i][j] = s.charAt(j);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 'L'){
                    bfs(i, j);
                }
            }
        }

        bw.write(String.valueOf(max));
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Node(x, y, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.x][node.y] = true;
            max = Math.max(max, node.dist); // 최대 거리

            for(int i=0; i<4; i++) {
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];

                if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L'){
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, node.dist+1));
                }
            }
        }
        
    }

    static boolean isRange(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M)
            return true;
        return false;
    }

    static class Node {
        int x;
        int y;
        int dist;
    
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}