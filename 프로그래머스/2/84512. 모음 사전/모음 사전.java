class Solution {
    String[] strings = {"A", "E", "I", "O", "U"};
    int answer = 0;
    boolean found = false;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String currentWord, String targetWord) {
        if(currentWord.equals(targetWord)){
            found = true;
            return;
        } 
        
        int len = strings.length;
        if(currentWord.length() == len) // word길이가 5이상인 경우 더 추가하지 못함
            return;
        
        for(int i=0; i<len; i++){
            if(found) // 이미 찾은 경우는 넘어감
                return;
            
            answer++;
            dfs(currentWord+strings[i], targetWord);
        }
    }
}
