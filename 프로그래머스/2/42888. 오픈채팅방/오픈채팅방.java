import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>(); // uid -> 최신 닉네임
        ArrayList<String[]> logs = new ArrayList<>();      // [uid, action]

        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r, " ");
            String action = st.nextToken();
            String uid = st.nextToken();
            String name = st.hasMoreTokens() ? st.nextToken() : null;

            if (action.equals("Enter")) {
                nameMap.put(uid, name); // 닉네임 최신화
                logs.add(new String[]{uid, "Enter"});
            } else if (action.equals("Leave")) {
                logs.add(new String[]{uid, "Leave"});
            } else if (action.equals("Change")) {
                nameMap.put(uid, name); // 닉네임 최신화
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            String uid = logs.get(i)[0];
            String action = logs.get(i)[1];
            String name = nameMap.get(uid);

            if (action.equals("Enter")) {
                answer[i] = name + "님이 들어왔습니다.";
            } else {
                answer[i] = name + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
