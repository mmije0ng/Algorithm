class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) { // arr1의 행
            for (int j = 0; j < arr2[0].length; j++) { // arr2의 열
                for (int k = 0; k < arr2.length; k++) { // arr2의 행
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}
