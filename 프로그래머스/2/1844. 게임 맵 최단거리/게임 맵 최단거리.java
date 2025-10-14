// 가장 빠른 경로 -> BFS

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length]; // 해당 좌표까지의 최단 거리, 0이면 방문하지 않은 곳
        
        bfs(maps, visited); // 깊이 우선 탐색
        
        answer = visited[maps.length-1][maps[0].length-1]; // 도착점
        if(answer == 0) // 도착점에 방문하지 못한다면
            answer = -1;
        
        return answer;
    }
    
    private void bfs(int[][] maps, int[][] visited){
        int[] dx = {1, 0, -1, 0}; // 좌, 우
        int[] dy = {0, 1, 0, -1}; // 상, 하
        
        Queue<int[]> queue = new LinkedList<>(); // [x][y]
        visited[0][0] = 1; // 시작점 방문
        queue.add(new int[]{0, 0}); // 시작점 삽입
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];
            
            for(int i=0; i<4; i++){
                int x = cX+dx[i];
                int y = cY+dy[i];
                
                if(x < 0 || x>maps.length-1 || y<0 || y>maps[0].length-1)
                    continue;
                
                // 아직 방문하지 않았고, 길이 있다면
                if(visited[x][y]==0 && maps[x][y]==1){
                    visited[x][y] = visited[cX][cY]+1; // 방문 처리, 1칸 이동
                    queue.add(new int[]{x, y}); // 다음 방문점을 큐에 삽입
                }
            }
            
        }
        
    }
}