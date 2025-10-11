import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>(); // <그리운 이름, 추억점수>
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                String photoName = photo[i][j];
                if(map.containsKey(photoName)){
                    sum += map.get(photoName);
                }
            }
            
            answer[i] = sum;
        }
        
        
        return answer;
    }
}