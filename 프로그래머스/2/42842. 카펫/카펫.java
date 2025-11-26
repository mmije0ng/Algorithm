class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow; // 전체 칸 개수
        
        // 최소 세로 길이는 3 (테두리 각각 1줄 + 노란 칸 1줄)
        for(int rows = 3; rows < size/2; rows++){
            if(size%rows == 0){ // (rows × cols = 전체 크기)가 가능한 구조
                int cols = size/rows;
                
                if(rows<cols) // 가로 길이는 세로 길이와 같거나, 세로 길이보다 길어야 함
                    continue;
                
                // 내부 노란 영역은 테두리를 제외한 부분
                if ((rows - 2) * (cols - 2) == yellow) {
                    answer[0] = rows;
                    answer[1] = cols;
                    break;
              }
            }
        }
        
        return answer;
    }
}