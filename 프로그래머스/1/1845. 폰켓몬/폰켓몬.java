import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        // 빈도수 계산 (원래 코드 형태 유지)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 처음이면 0을 기본으로 가져오고 +1 해서 저장
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 서로 다른 종류 수 vs 선택 가능한 수(n/2) 중 작은 값
        int uniqueTypes = map.size();
        int canChoose = nums.length / 2;
        return Math.min(uniqueTypes, canChoose);
    }
}
