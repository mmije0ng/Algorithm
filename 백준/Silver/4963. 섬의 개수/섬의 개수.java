import java.util.*;
import java.io.*;

public class Main {
	static int dirX[] = {0, 0, -1 ,1, -1, 1, -1, 1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
	static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1};

	static int[][] array;
	static boolean[][] visited;
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                break;
            }

            int cnt = 0;
            array = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 배열 순휘
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    // 방문하지 않았고, 섬이라면
                    // 인근 노드 탐색
                    if(!visited[i][j] && array[i][j]==1){
                        dfs(i, j, w, h);
                        cnt++;
                    }
                }
            }

            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, int w, int h){
        visited[x][y]=true;
        
        for(int i=0; i<dirX.length; i++){
            int nowX = dirX[i]+x;
            int nowY = dirY[i]+y;
            
            // 인근 노드도 방문하지 않았고, 섬이라면 dfs 탐색
            if(rangeCheck(nowX, nowY, w, h) && !visited[nowX][nowY] && array[nowX][nowY] == 1){
                dfs(nowX, nowY, w, h);
            }
        }
    }

    public static boolean rangeCheck(int x, int y, int w, int h){
        if(x >=0 && x<h && y>=0 && y<w)
            return true;
        return false;
    }
}