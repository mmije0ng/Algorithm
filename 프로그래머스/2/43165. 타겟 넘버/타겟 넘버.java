class Solution {
    int answer = 0; // 전역 변수로 선언
    
    public int solution(int[] numbers, int target) {
        bfs(numbers, target, 0, 0);
        return answer;
    }
    
    // depth: 현재까지 몇 번째 숫자까지 사용했는지
    void bfs(int[] numbers, int target, int depth, int calc){
        // 모든 숫자를 다 사용한 경우
        if(depth == numbers.length){
            if(calc == target){
                answer++; // 정답 카운트 증가
            }
            return;
        }
        
        // 현재 숫자 더하기
        bfs(numbers, target, depth+1, calc + numbers[depth]);
        // 현재 숫자 빼기
        bfs(numbers, target, depth+1, calc - numbers[depth]);
    }
}
