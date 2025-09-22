import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>(); // <참가자 이름, 등장횟수>
        for (String com : completion) {
            hashMap.put(com, hashMap.getOrDefault(com, 0) + 1);
        }
        
        for(int i=0; i<participant.length; i++){
            if(!hashMap.containsKey(participant[i]) || hashMap.get(participant[i])==0)
                return participant[i];
            else
                hashMap.put(participant[i], hashMap.get(participant[i])-1);
                
        }
        
        return null;
    }
}