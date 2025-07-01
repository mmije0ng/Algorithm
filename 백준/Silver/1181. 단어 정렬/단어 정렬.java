import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine()); // 중복 제거됨
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // 길이가 같으면 사전순
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } 
                // 길이 짧은 순
                else {
                    return s1.length() - s2.length();
                }
            }
        });

        for (String word : list) {
            bw.write(word);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
