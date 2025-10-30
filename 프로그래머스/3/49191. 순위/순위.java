// A 선수가 B 선수보다 실력이 좋다면, A 선수는 B 선수를 항상 이김
// 플로이드 워셜 알고리즘
// 중간 노드를 거쳐 갈 수 있는 승패 관계를 업데이트 한다.
// 예를 들어, A → B, B → C라면 A → C 관계를 유추할 수 있다.

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;    
        // i가 j를 이기면 graph[i][j]가 1, 지면 graph[i][j]가 -1
        int[][] graph = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++){
            int[] result = results[i];
            int win = result[0];
            int loose = result[1];
            
            graph[win][loose] = 1;
            graph[loose][win] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    // graph[4][3] == 1 && graph[3][2] ==1
                    // -> graph[4][2] ==1
                    if(graph[i][j] == 1 && graph[j][k] == 1){
                        graph[i][k] = 1;
                        graph[k][i] = -1;
                    }           
                    
                    // graph[5][2] == -1 && gragph[2][3] == -1
                    // -> graph[5][3] == -1
                    if(graph[i][j] == -1 && graph[j][k] == -1){
                        graph[i][k] = -1;
                        graph[k][i] = 1;
                    }
                }
            }
        }
        
        // for(int i=1; i<graph.length; i++){
        //     int sum = 0;
        //     for(int j=1; j<graph[i].length; j++){
        //         System.out.println("graph[" + i +"][" + j +"] = " + graph[i][j]);
        //     }
        // }
        
        // n-1번 경기를 한 선수의 순위는 정확히 알 수 있음
        for(int i=1; i<graph.length; i++){
            int cnt = 0;
            for(int j=1; j<graph[i].length; j++){
                if(graph[i][j]!=0)
                    cnt++;
            }
            if(cnt == n-1)
                answer++;
        }
        
        return answer;
    }
}