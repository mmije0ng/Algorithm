import java.util.*;
import java.io.*;

// 리스트에 노드 담고
// 현재 정점에서 갈 수 있는 노드들을 확인하면서 최소 비용 갱신
// 최소 비용이 더 작은 경우 우선순위 큐에 넣고 계속 탐색

public class Main {
    static int N, M = 0;
    static int start, end = 0;
    static List<Node>[] graph;
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 도시 개수
        M = Integer.parseInt(br.readLine()); // 버스 개수

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(dijkstra()));
        
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라
    static int dijkstra() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 최소힙
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 더 짧은 거리로 방문한 적이 있다면 건너뜀
            if (cur.cost > dist[cur.end]) continue;

            // 현재 도착 정류장이 시작점인 노드들 리스트 탐색
            for (Node next : graph[cur.end]) {
                // 현재 최소 경로보다,
                // 현재 노드까지의 비용 + 다음 노드 비용이 더 저렴한 경우
                if (dist[next.end] > cur.cost + next.cost) {
                    dist[next.end] = cur.cost + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist[end];
    }

    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}