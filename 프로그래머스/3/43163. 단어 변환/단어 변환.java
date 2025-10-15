class Solution {
    public int answer = 0;  

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, target, words, visited, 0);
        
        return answer;
    }

    // DFS(깊이 우선 탐색)로 가능한 모든 변환 경로 탐색
    private void dfs(String current, String target, String[] words, boolean[] visited, int count) {
        // 현재 단어가 목표 단어와 같다면
        if (current.equals(target)) {
            answer = count;
            return;
        }

        // 단어 목록 전체를 순회하며 한 글자만 다른 단어를 탐색
        for (int i = 0; i < words.length; i++) {
            // 아직 방문하지 않은 단어만 사용
            if (!visited[i]) {
                int equalsCount = 0;

                // 현재 단어와 단어 목록 중 i번째 단어의 문자 비교
                for (int j = 0; j < words[i].length(); j++) {
                    if (current.charAt(j) == words[i].charAt(j)) {
                        equalsCount++; // 같은 위치에 같은 문자일 경우 카운트 증가
                    }
                }

                // 단어 길이보다 1만큼 적게 같다면 → 한 글자만 다름 → 변환 가능
                if (equalsCount == words[i].length() - 1) {
                    visited[i] = true; // 방문 처리 (중복 방지)
                    dfs(words[i], target, words, visited, count + 1); // 다음 단계로 DFS 재귀 호출
                    visited[i] = false; // 백트래킹
                }
            }
        }
    }
}
