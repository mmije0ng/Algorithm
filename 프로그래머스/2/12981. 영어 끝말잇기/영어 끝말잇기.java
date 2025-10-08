import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        // 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>(); // set에 단어를 넣음
        boolean isExist = false; // 끝말잇기에 실패한 단어가 존재하는지 여부

        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                String s1 = words[i - 1];
                String s2 = words[i];

                char last = s1.charAt(s1.length() - 1); // 이전 단어의 마지막 철자
                char first = s2.charAt(0); // 현재 단어의 처음 철자

                // 앞의 단어와 끝말잇기 실패
                if (last != first) {
                    System.out.println("탈락한 사람 번호: " + ((i % n) + 1));
                    System.out.println("탈락한 사람 순서: " + ((i / n) + 1));
                    isExist = true;
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
                
                if (!set.contains(words[i])) {
                    set.add(words[i]);
                } 
                
                // 이미 말한 단어를 중복
                else {
                    System.out.println("탈락한 사람 번호: " + ((i % n) + 1));
                    System.out.println("탈락한 사람 순서: " + ((i / n) + 1));
                    isExist = true;
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
            } 
            
            else {
                if (!set.contains(words[i])) {
                    set.add(words[i]);
                } 
                
                // 이미 말한 단어를 중복
                else {
                    System.out.println("탈락한 사람 번호: " + ((i % n) + 1));
                    System.out.println("탈락한 사람 순서: " + ((i / n) + 1));
                    isExist = true;
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
            }
        }

        // 탈락한 사람이 없는 경우
        if (!isExist) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}
