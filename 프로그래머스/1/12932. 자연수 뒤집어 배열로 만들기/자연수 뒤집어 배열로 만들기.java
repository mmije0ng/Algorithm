import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        
        String s = String.valueOf(n);
        for(int i=0; i<s.length(); i++){
            list.add(Integer.parseInt(s.substring(i, i+1)));
        }
        
        Collections.reverse(list); // 뒤집기
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}