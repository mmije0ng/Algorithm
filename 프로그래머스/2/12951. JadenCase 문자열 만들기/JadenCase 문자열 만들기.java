class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true; // 단어의 첫 글자인지 여부

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
                isFirst = true; // 공백 뒤는 새로운 단어의 시작
            } 
            
            else {
                if (isFirst) {
                    sb.append(Character.toUpperCase(c));
                    isFirst = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }
}
