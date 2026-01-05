class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int index = 0; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직임 수를 체크

        for(int i = 0; i < name.length(); i++){
            // 최소를 더해서, i번째 문자를 만드는 최소 상/하 조작 횟수를 누적
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            index = i + 1;
            // 현재 위치 i의 다음 칸부터 연속된 'A'가 몇 개 이어지는지 확인
            while(index < length && name.charAt(index) == 'A')
                index++;

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            // 오른쪽으로 i까지 갔다가 다시 왼쪽으로 돌아서(되돌아) 뒤쪽 처리
            move = Math.min(move, i * 2 + length - index);
            // 반대로, 뒤쪽부터 먼저 처리하고 다시 앞으로 오는 형태
            move = Math.min(move, (length - index) * 2 + i);
        }
        
        // answer: 모든 문자에 대한 상/하 조작 최소 합
        // move: 커서 좌/우 이동 최소값
        return answer + move;
    }
}