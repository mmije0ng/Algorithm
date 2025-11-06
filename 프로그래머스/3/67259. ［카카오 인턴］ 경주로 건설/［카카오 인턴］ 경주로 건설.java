import java.util.*;

class Solution {
    static int len, answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] visited;  // [x][y][방향]
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        len = board.length;
        visited = new int[len][len][4];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs(0, 0, board);
        return answer;
    }
    
    private void bfs(int x, int y, int[][] board) {
        Queue<Car> q = new ArrayDeque<>(); 
        q.add(new Car(x, y, 0, -1));
        
        while (!q.isEmpty()) {
            Car c = q.poll();
            
            if (c.x == len - 1 && c.y == len - 1) {
                answer = Math.min(answer, c.cost);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= len || ny >= len || board[nx][ny] == 1)
                    continue;
                
                int costSum = c.cost;
                
                if (c.dir == -1 || c.dir == i) {  // 시작점이거나 직진
                    // c.dir == i: 이전 방향(c.dir)과 현재 방향(i)이 같으면
                    // System.out.println("nx == " + nx + ", ny == " + ny);
                    // System.out.println("i == " + i + ", 직진 c.dir == " + c.dir);
                    costSum += 100;
                } else { // 코너
                    // 이전 방향과 현재 방향이 다르면 → 방향이 바뀌었으므로 코너(회전) 발생
                    // System.out.println("nx == " + nx + ", ny == " + ny);
                    // System.out.println("i == " + i + ", 코너 c.dir == " + c.dir);

                    costSum += 600;
                }
                    
                // 같은 위치, 같은 방향으로 도착했을 때 비용이 더 작은 경우에만 갱신
                if (visited[nx][ny][i] > costSum) {
                    visited[nx][ny][i] = costSum;
                    q.add(new Car(nx, ny, costSum, i));
                }
            }
        }
    }
}

class Car {
    int x;
    int y;
    int cost;
    int dir;
    
    public Car(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}
