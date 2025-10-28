import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        // 모든 전선을 하나씩 끊어보기
        for (int i = 0; i < wires.length; i++) {
            int[] visited = new int[n + 1];
            
            // i번째 전선을 임시로 제거한 상태에서 BFS 수행
            int count = bfs(n, wires, visited, i);
            // System.out.println("i = " + i);
            // System.out.println("count = " + count);
            
            // 두 네트워크의 송전탑 개수 차이 계산
            int diff = Math.abs(n - 2 * count);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    // BFS로 연결된 송전탑 개수 구하기
    private int bfs(int n, int[][] wires, int[] visited, int removeIndex) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        // BFS 시작은 첫 번째 송전탑
        queue.add(1);
        visited[1] = 1;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < wires.length; i++) {
                // 제거한 전선은 무시
                if (i == removeIndex) continue;

                int a = wires[i][0];
                int b = wires[i][1];

                // 양방향 탐색
                if (a == current && visited[b] == 0) {
                    visited[b] = 1;
                    queue.add(b);
                    count++;
                } 
                
                else if (b == current && visited[a] == 0) {
                    visited[a] = 1;
                    queue.add(a);
                    count++;
                }
            }
        }

        return count;
    }
}
