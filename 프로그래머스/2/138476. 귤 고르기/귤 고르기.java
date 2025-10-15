import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        // value 배열을 초기화
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = list.get(0);
        for(int i=1; i<list.size(); i++){
            if(sum >= k){
                // answer++;
                break;
            }
            
            sum +=list.get(i);
            answer++;
        }
        
        return answer+1;
    }
}