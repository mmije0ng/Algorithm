// 가장 멀리 떨어진 노드: 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드
import java.util.*;

class Solution {
    int count = 0;
    
    public int solution(int n, int[][] vertex) {
        int answer = 0;
        int[] visited = new int[n+1];

        bfs(n, vertex, visited);
        // for(int i=1; i<=n; i++){
        //     System.out.println("i = " + i + ", path = " + visited[i]);
        // }
        
        int max = 1; // 최대값 찾기
        for(int i=2; i<=n; i++){
            if(max < visited[i]){
                max = visited[i];
            }
        }
        
        // 최대값과 1부터 최단경로가 같은 노드 개수 찾기
        for(int i=2; i<=n; i++){
            if(max == visited[i])
                answer++;
        }     
        
        return answer;
    }
    
    private void bfs(int n, int[][] vertex, int[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        // int startX = startPoint[0][0];
        queue.add(1); // 1번 삽입
        visited[1] = 1;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int i=0; i<vertex.length; i++){
                int a = vertex[i][0];
                int b = vertex[i][1];
                
                if(a == current && visited[b]==0){
                    visited[b] = visited[current] +1;
                    queue.add(b);
                }
                
                if(b == current && visited[a]==0){
                    visited[a] = visited[current] +1;
                    queue.add(a);
                }
            }
        }
        
    }
}