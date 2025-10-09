import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> countMap = new HashMap<>(); //<수, 빈도>
        HashMap<Integer, Integer> indexMap = new HashMap<>(); //<수, 인덱스>

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            if(!countMap.containsKey(number)){
                indexMap.put(number, i);
            }

            countMap.put(number, countMap.getOrDefault(number,0)+1);   
        }

        List<Integer> list = new ArrayList<>(countMap.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer number1, Integer number2) {
                if (countMap.get(number1).equals(countMap.get(number2))) {
                    // 등장 횟수가 같다면, 먼저 나온 것이 앞
                    return indexMap.get(number1) - indexMap.get(number2);
                }
                // 등장 횟수가 다르다면, 많이 등장한 순서대로 정렬
                return countMap.get(number2) - countMap.get(number1);
            }
        });

        for(Integer num: list){
            int count = countMap.get(num); // 빈도

            for(int i=0; i<count; i++){ // 빈도동안 출력
                bw.write(num +" ");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
  }
}
