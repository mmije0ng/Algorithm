import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) { 
        // ArrayDeque를 초기화할 때 생성자에 List를 넘기면 해당 리스트의 데이터들을 순서대로 초깃값으로 하여 ArrayDeque를 생성
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));
        
        // goal이 비어있을 때 까지 반복
        while(!goalDeque.isEmpty()){
            if(!cardsDeque1.isEmpty() && cardsDeque1.peek().equals(goalDeque.peek())){
                cardsDeque1.poll();
                goalDeque.poll();
            }
            
            else if(!cardsDeque2.isEmpty() && cardsDeque2.peek().equals(goalDeque.peek())){
                cardsDeque2.poll();
                goalDeque.poll();
            }
            
            else // 완성할 수 없는 경우
                break;
        }
        
        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}