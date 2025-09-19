import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {     
        int card1Index = 0;
        int card2Index = 0;
        Queue<String> queue = new ArrayDeque<>();
        
        for(int i=0; i<goal.length; i++){
            if(card1Index < cards1.length && cards1[card1Index].equals(goal[i])){
                queue.add(cards1[card1Index++]);
            }
            
            else if(card2Index < cards2.length && cards2[card2Index].equals(goal[i])){
                queue.add(cards2[card2Index++]);
            }
            
            else
                return "No";
        }
        
        return "Yes";
    }
}