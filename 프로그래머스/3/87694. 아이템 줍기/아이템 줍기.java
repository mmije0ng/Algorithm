import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int[] dI = {1, -1, 0, 0};
    static int[] dJ = {0, 0, 1, -1};
    static boolean[][] visited = new boolean[101][101];
    static int result = 0;

    // 직사각형이 담긴 2차원 배열 rectangle
    // 초기 캐릭터의 위치 characterX, characterY
    // 아이템의 위치 itemX, itemY
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 지도 그리기
        drawMap(rectangle);

        // BFS 탐색 수행 (좌표를 두 배로 확장)
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        // 결과 반환 (두 배 확장된 좌표이므로 /2)
        return result;
    }

    /*
     * 내부 채우고, 테두리 채우는 로직
     * y가 2차원 배열의 i 인덱스, x가 j 인덱스
     * 전체 그림은 뒤집어진 형태로 생각
     * i의 첫번째, 마지막 또는 j의 첫번째, 마지막은 모두 1 (테두리)
     */
    private void drawMap(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int startI = rect[1] * 2;
            int endI = rect[3] * 2;

            int startJ = rect[0] * 2;
            int endJ = rect[2] * 2;

            for (int i = startI; i <= endI; i++) {
                for (int j = startJ; j <= endJ; j++) {
                    // 테두리 부분
                    if (i == startI || i == endI || j == startJ || j == endJ) {
                        if (map[i][j] == 2) continue; // 내부면 유지
                        map[i][j] = 1; // 테두리
                    } else {
                        map[i][j] = 2; // 내부
                    }
                }
            }
        }
    }

    // BFS 탐색
    private void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterY, characterX, 0}); // i, j, step
        visited[characterY][characterX] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];
            int currentStep = current[2];

            // 아이템 도착 시 종료
            if (currentI == itemY && currentJ == itemX) {
                result = currentStep / 2; // 2배 좌표이므로 실제 거리는 절반
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextI = currentI + dI[i];
                int nextJ = currentJ + dJ[i];

                if (nextI >= 1 && nextI <= 100 && nextJ >= 1 && nextJ <= 100) {
                    if (!visited[nextI][nextJ] && map[nextI][nextJ] == 1) {
                        visited[nextI][nextJ] = true;
                        q.add(new int[]{nextI, nextJ, currentStep + 1});
                    }
                }
            }
        }
    }
}
