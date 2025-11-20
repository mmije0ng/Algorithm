import java.util.*;

class Solution {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int answer = 0;
    
    public int solution(int[][] land, int height) {
        int n = land.length;
        boolean[][] visited = new boolean[n][n];
        
        dfs(land, visited, height, n);
        
        return answer;
    }
    
    private void dfs(int[][] land, boolean[][] visited, int height, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));
        
        while(!pq.isEmpty()){
            // land 값이 작은 노드들부터 우선 탐색
            Node current = pq.poll();
            if(visited[current.x][current.y])
                continue;
            
            visited[current.x][current.y] = true;
            answer += current.value;
            
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;
                
                int cost = Math.abs(land[current.x][current.y] - land[nextX][nextY]);
    
                // 이동 비용이 height 보다 큰 경우 우선순위큐에 사다리 비용을 추가
                if(cost > height){
                    pq.add(new Node(nextX, nextY, cost));
                }
                // 이동 비용이 height 보다 작거나 같은 경우 사다리를 사용하지 않으니
                // 비용은 0
                else{
                    pq.add(new Node(nextX, nextY, 0));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int x;
    int y;
    int value;
    
    Node(int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
    
    @Override
    public int compareTo(Node o){
        return this.value - o.value; // 오름차순
    }
}