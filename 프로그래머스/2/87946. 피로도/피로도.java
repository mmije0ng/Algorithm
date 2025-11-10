// 최소 필요 피로도: 해당 전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
// 소모 필로도: 던전을 탐험한 후 소모되는 피로도
// "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험 
// -> 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모

import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return answer; // 유저가 탐험할수 있는 최대 던전 수
    }
    
    private void dfs(int k, int count, int[][] dungeons){ // (현재 체력, 방문점, 배열)
        for(int i=0; i<dungeons.length; i++){
            // 방문하지 않았고, 현재 피로도보가 다음 던전을 가기 위한 피로도 크거나 같다면
            if(!visited[i] && k>=dungeons[i][0]){            
                visited[i] = true;
                answer = Math.max(answer, count+1);
                dfs(k-dungeons[i][1], count+1, dungeons);
                    
                visited[i] = false; // 백트래킹
            }
        }        
    }
}