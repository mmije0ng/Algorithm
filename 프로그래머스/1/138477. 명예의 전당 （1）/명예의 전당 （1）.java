import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int len = score.length;
        int[] answer = new int[len];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            if(list.size()<k)
                list.add(score[i]);
            
            if(list.size()>= k && list.get(list.size()-1) <score[i]){
                list.remove(list.size()-1);
                list.add(score[i]);
            }
            
            Collections.sort(list, Collections.reverseOrder());
            answer[i] = list.get(list.size()-1);
        }
        
        return answer;
    }
}