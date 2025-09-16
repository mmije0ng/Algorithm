import java.util.*;

class Solution {
    // 처음 표의 행 개수를 나타내는 정수 n
    // 처음에 선택된 행의 위치를 나타내는 정수 k
    // 수행한 명령어들이 담긴 문자열 배열 cmd
    public String solution(int n, int k, String[] cmd) {
        TreeSet<Integer> alive = new TreeSet<>(); // 현재 살아있는 행들을 관리
        Stack<Integer> stack = new Stack<>(); // 삭제된 행들을 넣어놓는 스택 (가장 최근에 삭제된 행을 원상복구)
        
        for (int i = 0; i < n; i++) 
            alive.add(i); // 처음에는 모든 행이 살아있음
        
        for (String c : cmd) {
            // "U X" 현재 선택된 행에서 X칸 위에 있는 행을 선택
            if (c.startsWith("U")) {
                int x = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < x; i++) {
                    k = alive.lower(k); // TreeSet에서 바로 위 행 찾기
                }
            } 
            
            // "D X" 현재 선택된 행에서 X칸 아래에 있는 행을 선택
            else if (c.startsWith("D")) {
                int x = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < x; i++) {
                    k = alive.higher(k); // TreeSet에서 바로 아래 행 찾기
                }
            } 
            
            // "C" 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택
            // 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택
            else if (c.startsWith("C")) {
                stack.push(k); // 삭제된 행 기록
                alive.remove(k); // 현재 선택된 행 삭제
                
                // 다음 선택할 행
                if (alive.higher(k) != null) {
                    k = alive.higher(k); // 아래 행 선택
                } else {
                    k = alive.lower(k); // 아래가 없으면 위 행 선택
                }
            } 
            
            // "Z" 가장 최근에 삭제된 행을 원래대로 복구
            // 단, 현재 선택된 행은 바뀌지 않습니다.
            else {
                int lastDeleted = stack.pop();
                alive.add(lastDeleted); // 삭제 복구
            }
        }
        
        // 최종 문자열 구성
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (alive.contains(i)) sb.append("O");
            else sb.append("X");
        }
        
        return sb.toString();
    }
}
