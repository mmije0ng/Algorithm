import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < skill.length(); i++)
            map.put(skill.charAt(i), i);

        for (String skillTree : skill_trees) {
            int index = 0;
            boolean valid = true;

            for (int i = 0; i < skillTree.length(); i++) {
                char c = skillTree.charAt(i);

                if (!map.containsKey(c))
                    continue;

                if (map.get(c) == index)
                    index++;
                else {
                    valid = false;
                    break;
                }
            }

            if (valid)
                answer++;
        }

        return answer;
    }
}