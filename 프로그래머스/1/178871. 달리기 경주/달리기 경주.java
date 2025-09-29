import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>(); // <이름, 현재 순위>
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        // players 배열에도 현재 순위를 기록
        // 1등(인덱스 0)인 선수는 불리지 않으니 인덱스 에러 X
        for(int i=0; i<callings.length; i++){
            int win = map.get(callings[i]); // 역전하기 현재 순위
            String loose = players[win-1]; // 역전당한 사람
            
            map.put(callings[i], win-1); // 역전한 사람의 순위는 현재 순위-1
            map.put(loose, win); // 역전당한 사람의 순위는 역전한 사람의 현재 순위로 변경
            
            // plyaers 배열 갱신
            players[win-1] = callings[i];
            players[win] = loose;
        }
        
        List<String> answerList = map.entrySet()
            .stream()
            .sorted((a, b) -> a.getValue().compareTo(b.getValue())) // 순위 오름차순
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        return answerList.toArray(new String[0]);
    }
}