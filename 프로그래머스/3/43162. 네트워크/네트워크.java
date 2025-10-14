// 간선이 있는지 dfs
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        
        for(int i=0; i<computers.length; i++){
            // 방문하지 않았다면 dfs 탐색
            if(visited[i]!=1){
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, int[] visited, int i){
        for(int j=0; j<computers.length; j++){
            // 방문하지 않았고, 이어졌다면
            if(visited[j]!=1 && computers[i][j]==1 && i!=j){
                visited[j] = 1;
                dfs(computers, visited, j);
            }
        }
    }
}