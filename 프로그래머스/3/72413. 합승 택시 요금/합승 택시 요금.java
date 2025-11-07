class Solution {
    final int INF = 9999999;
    int dist[][];
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(i==j)
                    dist[i][j] = 0; // a->a로 가는 경우는 비용이 0
                else
                    dist[i][j] = INF; // a->b로 가는 경우에 관한 비용은 아직 알 수 없음
            }
        }

		// 주어진 요금 정보를 기록
        for(int[] data: fares){
        	// data = {a,b,c} 형식
        	// a->b, b->a의 요금은 c원
            dist[data[0]][data[1]] = data[2];
            dist[data[1]][data[0]] = data[2];
        }
        
        // 플로이드워셜
        for(int k = 1; k <= n; k++){
            for(int i = 1 ; i <= n; i++){
                for(int j = 1 ; j <= n; ++j){
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        
        // 각자 따로가는 비용보다 더 비싼 경우는 없음
        int answer = dist[s][a] + dist[s][b];
        
        // 특정 구간까지 합승해서 갔을 때, 더 싼 경우가 있는지 확인
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }
}