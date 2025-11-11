import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5; // 캐시 크기 0이면 전부 miss
        
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 무시

            // hit
            if (set.contains(city)) {
                list.remove(city);
                list.add(city); // 최근 사용으로 맨 뒤로 이동
                answer += 1;
            }

            // miss
            else {
                // 캐시가 가득 찼을 때만 제거
                if (list.size() >= cacheSize) {
                    String oldest = list.get(0);
                    list.remove(0);
                    set.remove(oldest);
                }

                // 새 도시 추가
                list.add(city);
                set.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}
