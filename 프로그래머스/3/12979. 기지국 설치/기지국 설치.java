class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        for(int i=0; i<=stations.length; i++){
            int len = 0;
            // 양끝과 기지국, 기지국과 기지국 사이의 빈 전파 범위 구간을 먼저 구함
            // 첫번째 기지국과 왼쪽 끝 사이 전파가 통하지 않는 길이
            if(i == 0){
                len = stations[i]-w-1;
            }
            
            // 마지막 기지국과 오른쪽 끝 사이 전파가 통하지 않는 길이
            else if(i == stations.length){
                len = n - stations[i-1] - w;
            }
            
            // 각 기지국과 기지국 사이 전파가 통하지 않는 길이
            else{
                len = stations[i] - stations[i-1] - (w*2) -1;
            }
            
            if(len >=0){
                // 6일때는 2, 5일때는 1
                // w=2
                // 4일때는 2, 2일때는 1
                // w=1
                int count = len/(w*2+1);
                int remain = len%(w*2+1);
                // System.out.println("len = " + len + ", count = " + count + ", remain = " + remain);
                answer+=count;
                if(remain!=0)
                    answer++;
            }
        }      
        
        return answer;
    }
}
