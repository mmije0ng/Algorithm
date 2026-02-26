class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            
            String binary1 = String.format("%" + n + "s",
                             Integer.toBinaryString(arr1[i]))
                             .replace(' ', '0');

            String binary2 = String.format("%" + n + "s",
                             Integer.toBinaryString(arr2[i]))
                             .replace(' ', '0');

            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1')
                    result.append("#");
                else
                    result.append(" ");
            }
            
            answer[i] = result.toString();
        }
        
        return answer;
    }
}