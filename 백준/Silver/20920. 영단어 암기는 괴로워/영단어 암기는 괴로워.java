import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length() < len)
                continue;
            hashMap.put(word, hashMap.getOrDefault(word, 0)+1);
        }
        
        // map에서 단어들을 가져와서 ArrayList에 저장
        List<String> words = new ArrayList<>(hashMap.keySet());
        Collections.sort(words, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                // 자주 나오는 단어일수록 앞에 배치
                if(!hashMap.get(o1).equals(hashMap.get(o2)))
                    return hashMap.get(o2)-hashMap.get(o1);

                // 단어의 길이가 길수록 앞에 배치
                else if(o1.length() != o2.length())
                    return o2.length()-o1.length();

                // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
                else
                    return o1.compareTo(o2);
            }
        });

        for(String word: words){
            bw.write(word);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
  }
}
