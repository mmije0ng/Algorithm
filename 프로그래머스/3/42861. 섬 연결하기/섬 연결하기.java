import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] island = new int[n]; // 각 섬의 대표(parent) 정보를 저장할 배열

        // 1. 초기화: 처음에는 모든 섬이 자기 자신을 부모로 가짐
        for (int i = 0; i < n; i++) {
            island[i] = i;
        }

        // 2. 다리 건설 비용(costs)을 오름차순으로 정렬 (Kruskal 알고리즘 핵심)
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // 3. 비용이 낮은 다리부터 순서대로 선택
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            // 4. 두 섬이 서로 다른 그룹(대표가 다름)에 속해 있다면
            if (find(island, from) != find(island, to)) {
                // 5. 두 섬을 연결 (Union)
                unite(island, from, to);
                // 6. 연결한 다리의 비용을 누적
                answer += cost; 
            }
        }

        // 모든 섬을 최소 비용으로 연결한 총 비용 반환
        return answer;
    }

    // find: 해당 노드의 대표(parent)를 찾는 함수
    private int find(int[] island, int x) {
        if (island[x] != x) {
            island[x] = find(island, island[x]); // 경로 압축
        }
        return island[x];
    }


    // unite: 두 섬을 같은 그룹으로 묶는 함수 (Union)
    private void unite(int[] island, int x, int y) {
        int a = find(island, x); // x의 대표
        int b = find(island, y); // y의 대표
        island[a] = b; // x의 대표를 y의 대표로 변경 (두 그룹 병합)
    }
}
