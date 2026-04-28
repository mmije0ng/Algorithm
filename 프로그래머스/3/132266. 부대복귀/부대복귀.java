import java.util.*;

// 최단시간에 부대로 복귀 -> bfs
// 인접리스트 양방향 그래프

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());
        
        // 양방향 그래프
        for(int[] road: roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        // bfs
        Queue<Integer> q = new ArrayDeque<>();
        q.add(destination);
        dist[destination] = 0; 
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            // map.get(cur): List<Integer>, cur의 인접 노드 리스트
            // next: int, 리스트 안의 개별 노드
            for(int next: graph.get(cur)){
                // 다음 경로의 값이 갱신되어 있지 않다면
                // 인접 리스트이니 현재 경로의 값+1
                if(dist[next] == -1){
                    dist[next] = dist[cur]+1;
                    q.add(next);
                }
            }
        }
        
         for(int i=0; i<sources.length; i++)
            answer[i] = dist[sources[i]];
        
        return answer;
    }
}