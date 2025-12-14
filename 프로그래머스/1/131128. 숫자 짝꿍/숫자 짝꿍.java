// 각각의 문자의 숫자들을 오름차순으로 정렬 후
// 
// 각각의 문자의 숫자들을 맵에 <숫자, 빈도> 넣음
// 각각의 맵에서 숫자가 같으면 리스트에 넣음
// 리스트를 내림차순하여 리턴, 리스트가 비어있다면 -1 리턴

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> mapX = new HashMap<>();
        Map<Character, Integer> mapY = new HashMap<>();
        
        for(int i=0; i<X.length(); i++){
            char c = X.charAt(i);
            mapX.put(c, mapX.getOrDefault(c, 0)+1);
        }
        
        for(int i=0; i<Y.length(); i++){
            char c = Y.charAt(i);
            mapY.put(c, mapY.getOrDefault(c, 0)+1);
        }
        
        List<Character> list = new ArrayList<>();
        for(int i=0; i<X.length(); i++){
            char key = X.charAt(i);
            if(mapY.containsKey(key)){
                int xValue = mapX.get(key);
                int yValue = mapY.get(key);
                
                // 문자는 같고, 빈도수가 다를 때 최솟값 빈도로 삽입
                int minValue = Math.min(xValue, yValue);
                for(int j=0; j<minValue; j++)
                    list.add(key);
                
                // 중복 삽입 방지를 위해 추가한 문자는 맵에서 제거
                mapX.remove(key);
                mapY.remove(key);
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        if(list.isEmpty())
            return "-1";
        else if (list.get(0).equals('0'))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++)
            sb.append(list.get(i));
        
        return sb.toString();
    }
}