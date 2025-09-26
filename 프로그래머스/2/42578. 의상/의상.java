import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>(); // <종류, 개수>
        for(int i=0; i<clothes.length; i++){
            String name = clothes[i][0];
            String type = clothes[i][1];
            
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        
        System.out.println(map);
                
        int answer = 1;
        for(int value: map.values()){
            // answer*=value+1;
            answer = answer*(value+1);
        }
        
        return answer-1; // 모든 종류를 "안씀"으로 선택한 경우는 제외
    }
}