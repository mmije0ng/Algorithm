import java.util.*;

class Solution {
    List<String> list = new ArrayList<>(); // 가능한 경로 문자열 저장
    List<String> path = new ArrayList<>(); // 현재 탐색 중 경로 저장
    boolean[] visited; // 티켓 사용 여부

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        path.add("ICN"); // 출발 공항 추가
        dfs(0, "ICN", tickets);

        // System.out.println(list);
        // 	[ICN SFO ATL ICN ATL SFO, 
        // ICN ATL ICN SFO ATL SFO, 
        // ICN ATL SFO ATL ICN SFO]
        
        Collections.sort(list); // 사전순 정렬

        return list.get(0).split(" ");
    }

    private void dfs(int depth, String target, String[][] tickets) {
        // 모든 티켓을 사용한 경우
        if (depth == tickets.length) {
            // System.out.println(path);
            // [ICN, SFO, ATL, ICN, ATL, SFO]
            // [ICN, ATL, ICN, SFO, ATL, SFO]
            // [ICN, ATL, SFO, ATL, ICN, SFO]
            
            list.add(String.join(" ", path)); // 완성된 경로를 문자열로 저장
            return;
        }

        // 가능한 다음 목적지를 탐색
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && target.equals(tickets[i][0])) {
                visited[i] = true;
                path.add(tickets[i][1]);

                dfs(depth + 1, tickets[i][1], tickets);

                visited[i] = false; // 백트래킹
                path.remove(path.size() - 1); // 경로 복구
            }
        }
    }
}
