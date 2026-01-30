class Solution {    
    public int solution(String[] babbling) {
        int answer = 0;
        String[] list = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            // 연속 중복 발음 차단
            boolean invalid = false;
            for (int j = 0; j < list.length; j++) {
                if (babbling[i].contains(list[j] + list[j])) {
                    invalid = true;
                    break;
                }
            }
            
            if (invalid) continue;

            // 발음 제거
            for (int j = 0; j < list.length; j++)
                babbling[i] = babbling[i].replace(list[j], " ");

            // 전부 제거된경우 = 가능한경우
            if (babbling[i].trim().length() == 0)
                answer++;
        }

        return answer;
    }
}
