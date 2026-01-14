import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>(); // <약관, 유효기간>
        for (String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }

        int todayDays = toDays(today);
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String date = privacy[0];
            String type = privacy[1];

            int startDays = toDays(date);
            int expireDays = startDays + map.get(type) * 28;

            // 파기 기준: 만료일 <= 오늘
            if (expireDays <= todayDays)
                list.add(i + 1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int toDays(String date) {
        String[] d = date.split("\\.");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);

        return year * 12 * 28 + month * 28 + day;
    }
}
