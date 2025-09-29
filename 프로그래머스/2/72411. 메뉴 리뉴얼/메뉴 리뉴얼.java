import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> courseMap = new HashMap<>();

        // 1. 코스 후보 카운트 (연속 substring 대신 단순 반복문 구조 유지)
        for (String str : orders) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            // 부분집합 생성 (비트마스크)
//             비트마스크를 사용해 sorted의 모든 부분집합을 만든다.
//             1 << n 은 2^n (n개의 원소로 만들 수 있는 모든 부분집합 개수)
//             mask가 1이면 해당 문자를 포함, 0이면 포함하지 않음
            
//             예: sorted = "ABC"
//             mask = 1 (001) → "C"
//             mask = 2 (010) → "B"
//             mask = 3 (011) → "BC"
//             mask = 5 (101) → "AC"
//             … 이런 식으로 전부 생성됨.
                
            int n = sorted.length();
            for (int mask = 1; mask < (1 << n); mask++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) sb.append(sorted.charAt(i));
                }
                if (sb.length() >= 2) { // 최소 2개 이상
                    courseMap.put(sb.toString(), courseMap.getOrDefault(sb.toString(), 0) + 1);
                }
            }
        }

        // 2. 정렬된 후보 리스트
        // 정렬 기준 첫번째: 빈도순, 두번쨰: 문자열 오름차순
        List<String> sortedCourseList = courseMap.entrySet()
            .stream()
            .sorted((a, b) -> {
                int cmp = b.getValue().compareTo(a.getValue());
                if (cmp == 0) return a.getKey().compareTo(b.getKey());
                return cmp;
            })
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        // 3. 각 course 길이별 최빈값만 결과에 담기
        // TreeSet: 자동으로 사전순 정렬
        Set<String> answerSet = new TreeSet<>();
        for (int c : course) {
            int max = 0;
            for (String menu : sortedCourseList) {
                // 원하는 코스요리 길이 배열
                if (menu.length() == c) {
                    // max는 해당 길이(c)에서 가장 많이 주문된 조합의 등장 횟수.
                    
//                     모든 조합(sortedCourseList) 중에서,
//                     menu.length() == c 인 조합만 확인.

//                     예: c=2 → "AB", "AC", "BC" …
//                     그 조합이 등장한 횟수(courseMap.get(menu))의 최댓값을 찾음.
//                     즉, 해당 길이에서 가장 많이 등장한 조합의 빈도.
                        
                    max = Math.max(max, courseMap.get(menu));
                }
            }
            
            for (String menu : sortedCourseList) {
//                 다시 한 번 sortedCourseList를 돌면서,
//                 길이가 c이고,
//                 등장 횟수가 **최댓값(max)**과 같고,
//                 최소 2번 이상 주문된 조합만 최종 후보에 추가.

//                 예:
//                 c=2, max=3 → "AC"(3번), "AD"(3번) → 후보 추가.
//                 단, max=1 이면 제외 (조건: max >= 2).
                    
                if (menu.length() == c &&
                    courseMap.get(menu) == max &&
                    max >= 2) {
                    answerSet.add(menu);
                }
            }
        }

        return answerSet.toArray(new String[0]);
    }
}
