import java.util.*;

class Solution {
    int[] dX = {1, 0, -1, 0};
    int[] dY = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        // 문자 맵
        char[][] miro = new char[n][m];
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int endX = 0, endY = 0;

        // 문자 맵 초기화 + S, L, E 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                miro[i][j] = maps[i].charAt(j);
                if (miro[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (miro[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (miro[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        
        // 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후
        // 미로를 빠져나가는 문이 있는 칸으로 이동

        // S → L 거리
        int toLever = bfs(miro, startX, startY, 'L');
        if (toLever == -1) return -1; // 레버까지 못 감

        // L → E 거리
        int toExit = bfs(miro, leverX, leverY, 'E');
        if (toExit == -1) return -1; // 출구까지 못 감

        return toLever + toExit;
    }

    // BFS (시작점에서 목표 문자까지 최단 거리)
    private int bfs(char[][] miro, int startX, int startY, char target) {
        int n = miro.length;
        int m = miro[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];

            // 목표 도달
            if(miro[cX][cY] == target){
                return visited[cX][cY];
            }
            
            for(int i=0; i<4; i++){
                int nX = cX+dX[i];
                int nY = cY+dY[i];
                
                if(nX <0 || nX>=miro.length || nY<0 || nY>=miro[0].length)
                    continue;
                
                if(visited[nX][nY]>0 || miro[nX][nY] =='X')
                    continue;
                
                // 아직 방문하지 않았고 길이 있다면
                visited[nX][nY] = visited[cX][cY]+1;
                queue.add(new int[]{nX, nY});
            }
            
        }

        return -1; // 도달 불가
    }
}
