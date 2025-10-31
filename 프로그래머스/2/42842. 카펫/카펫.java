class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        
        for(int rows = 3; rows < size/2; rows++){
            if(size%rows == 0){
                int cols = size/rows;
                
                if(rows<cols) // 가로 길이는 세로 길이와 같거나, 세로 길이보다 길어야 함
                    continue;
                
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