import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for(int value: citations)
            list.add(value);
        
        Collections.sort(list); // 오름차순 정렬
        
        List<Integer> indexList = new ArrayList<>(); // H-Index 저장
        
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int papers = list.size() - i;   // num 이상 인용된 논문 수
            int h = Math.min(num, papers);  // H-index 후보
            indexList.add(h);
        }
        
        Collections.sort(indexList, Collections.reverseOrder()); // 내림차순 정렬
        
        return indexList.size() >0 ? indexList.get(0) : 0;
    }
}