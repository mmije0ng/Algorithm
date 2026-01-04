import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        
        int camera = -30000;
        for(int[] route: routes){
            int start = route[0];
            int end = route[1];
            
            // 이전에 설치한 카메라로 단속할 수 없는 경우
            if(start > camera){
                camera = end; // 끝 지점에 다시 설치
                answer++;
            }
        }      
        
        return answer;
    }
}