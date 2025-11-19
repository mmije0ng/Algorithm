import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        for(String phone: phone_book)
            set.add(phone);
                
        for(int i=0; i<phone_book.length; i++){
            String phone = phone_book[i];
            for(int j=0; j<phone.length(); j++){
                String str = phone.substring(0, j);
                
                if(set.contains(str)){
                    // System.out.println("phone: " + phone);
                    // System.out.println("str: " + str);
                    
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
