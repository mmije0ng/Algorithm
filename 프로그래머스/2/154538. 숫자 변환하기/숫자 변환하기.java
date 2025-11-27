import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public int bfs(int x, int y, int n){
        int[] visited = new int[y + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        visited[x] = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            if(curr == y) 
                return visited[curr];

            int[] nextNumber = {curr + n, curr * 2, curr * 3};

            for(int next : nextNumber){
                if(next <= y && visited[next] == 0){
                    visited[next] = visited[curr] + 1;
                    queue.add(next);
                }
            }
        }

        return -1;
    }
}
