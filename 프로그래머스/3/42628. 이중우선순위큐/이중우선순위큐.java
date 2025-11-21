import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0, 0};
        TreeSet<Integer> ts = new TreeSet<>(); // 정렬된 양방향 접근 가능
        for(String s: operations){
            StringTokenizer st = new StringTokenizer(s, " ");
            String first = st.nextToken();
            Integer num = Integer.parseInt(st.nextToken());
            
            if(first.equals("I"))
                ts.add(num);
            
            // 최댓값 삭제
            else if(num == 1 && !ts.isEmpty())
                ts.pollLast();
            
            // 최솟값 삭제
            else if(num == -1 && !ts.isEmpty())
                ts.pollFirst();
        }
        
        if(!ts.isEmpty()){
            answer[0] = ts.last();
            answer[1] = ts.first();
        }   
        
        return answer;
    }
}