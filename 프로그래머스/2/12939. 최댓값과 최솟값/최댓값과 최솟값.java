import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        
        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            minList.add(Integer.parseInt(token));
            maxList.add(Integer.parseInt(token));
        }
        
        Collections.sort(minList);
        Collections.sort(maxList, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        sb.append(minList.get(0)).append(" ");
        sb.append(maxList.get(0));
        
        return sb.toString();
    }
}