import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = Arrays.stream(citations)
                                   .boxed()
                                   .collect(Collectors.toList());

        // 필요한 로직 추가…

        return 0; // 일단 반환값 맞춰둠
    }
}
