import java.util.HashMap;
import java.util.HashSet;

class Solution {
    // 좌표 범위를 벗어나는지 체크하는 메서드
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    // 다음 좌표 결정을 위한 해시맵 생성
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>(); // 경로는 겹치는 것을 고려하지 않기 위해 Set 사용

        for (int i = 0; i < dirs.length(); i++) { // 문자열을 순회하면서 경로를 이동시킴
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            if (!isValidMove(nx, ny)) // 벗어난 좌표는 인정하지 않음
                continue;

            // A에서 B로 간 경우와 B에서 A로 간 경우는 동일한 경로이기 때문에 중복 처리 방지
            answer.add(x + "" + y + nx + "" + ny);
            answer.add(nx + "" + ny + x + "" + y);

            // 실제 좌표 이동으로 업데이트
            x = nx;
            y = ny;
        }

        return answer.size() / 2; // 양방향으로 저장했으므로 절반으로 나눔
    }
}
