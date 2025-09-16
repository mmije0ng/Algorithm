import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        boolean[] deleted = new boolean[n]; // 삭제 여부
        Stack<Integer> stack = new Stack<>(); // 삭제 기록
        int[] prev = new int[n]; // i번 행의 바로 위 살아있는 행 인덱스
        int[] next = new int[n]; // i번 행의 바로 아래 살아있는 행 인덱스

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1; // 마지막 행의 next는 없음

        for (String c : cmd) {
            if (c.startsWith("U")) {
                int x = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < x; i++) {
                    k = prev[k];
                }
            } 
            else if (c.startsWith("D")) {
                int x = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < x; i++) {
                    k = next[k];
                }
            } 
            else if (c.startsWith("C")) {
                stack.push(k);
                deleted[k] = true;

                // 연결 끊기
                if (prev[k] != -1) next[prev[k]] = next[k];
                if (next[k] != -1) prev[next[k]] = prev[k];

                // 다음 선택할 행
                if (next[k] != -1) {
                    k = next[k];
                } else {
                    k = prev[k];
                }
            } 
            else { // "Z"
                int r = stack.pop();
                deleted[r] = false;

                // 끊겼던 연결 복구
                if (prev[r] != -1) next[prev[r]] = r;
                if (next[r] != -1) prev[next[r]] = r;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(deleted[i] ? 'X' : 'O');
        }
        return sb.toString();
    }
}


// import java.util.*;

// class Solution {
//     // 처음 표의 행 개수를 나타내는 정수 n
//     // 처음에 선택된 행의 위치를 나타내는 정수 k
//     // 수행한 명령어들이 담긴 문자열 배열 cmd
//     public String solution(int n, int k, String[] cmd) {
//         boolean[] deleted = new boolean[n]; // 각 행의 삭제 여부를 담는 배열
//         Stack<Integer> stack = new Stack<>(); // 삭제된 행들을 넣어놓는 스택 (가장 최근에 삭제된 행을 원상복구)
        
//         for(String c: cmd){
//             // "U X" 현재 선택된 행에서 X칸 위에 있는 행을 선택
//             if(c.startsWith("U")){
//                 String[] s = c.split(" ");
//                 int x = Integer.parseInt(s[1]);
//                 while (x > 0 && k > 0) {
//                     k--;                // 위로 한 칸 이동
//                     if (!deleted[k])    // 삭제되지 않은 행이면
//                         x--;            // 이동해야 하는 칸 수 1 줄이기
//                 }
//             } 
            
//             // "D X" 현재 선택된 행에서 X칸 아래에 있는 행을 선택
//             else if (c.startsWith("D")) {
//                 int x = Integer.parseInt(c.split(" ")[1]);
//                 while (x > 0 && k < n - 1) {
//                     k++;
//                     if (!deleted[k]) 
//                         x--;
//                 }
//             } 
            
//             // "C" 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택
//             // 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택
//             else if (c.startsWith("C")){
//                 stack.push(k);
//                 deleted[k] = true; // 삭제 표시

//                 // 아래 행 찾기
//                 int nextK = k + 1;
//                 while (nextK < n && deleted[nextK]) 
//                     nextK++;

//                 if (nextK < n) {
//                     k = nextK;
//                 } else { // 아래가 없으면 위 행
//                     int prevK = k - 1;
//                     while (prevK >= 0 && deleted[prevK]) 
//                         prevK--;
//                     k = prevK;
//                 }
//             } 
            
//             // "Z" 가장 최근에 삭제된 행을 원래대로 복구
//             // 단, 현재 선택된 행은 바뀌지 않습니다.
//             else{
//                 int latedDeletedIndex = stack.pop();
//                 deleted[latedDeletedIndex] = false; 
//             }
//         }
        
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<deleted.length; i++){
//             // 삭제된 행인 경우
//             if(deleted[i])
//                 sb.append("X");
//             // 삭제된 행이 아닌 경우
//             else
//                 sb.append("O");
//         }
        
//         return sb.toString();
//     }
    
// }