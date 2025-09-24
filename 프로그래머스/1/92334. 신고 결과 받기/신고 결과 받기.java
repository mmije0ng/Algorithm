import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 메일 받는 횟수
        HashMap<String, HashSet<String>> complaintMap = new HashMap<>(); // <신고 당한 사람, 신고한 사람들 집합>

        // 신고 관계 처리 (중복 제거 위해 Set 사용)
        for (String rep : report) {
            StringTokenizer st = new StringTokenizer(rep, " ");
            String complaint = st.nextToken();     // 신고자
            String complainted = st.nextToken();  // 신고당한 사람

            complaintMap.putIfAbsent(complainted, new HashSet<>());
            complaintMap.get(complainted).add(complaint);
        }

        // 정지된 유저를 신고한 사람들에게 메일 카운트
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            for (String reported : complaintMap.keySet()) {
                // reported가 k번 이상 신고당한 사람일 때
                if(complaintMap.get(reported).size() >=k){
                    // user가 reported를 신고한 사람이면 count 
                    if(complaintMap.get(reported).contains(user)){
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
