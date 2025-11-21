import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++)
            list.add(br.readLine());

        Collections.sort(list, (a, b) -> {
            // 1. 길이가 짧은 것 우선
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            // 2. 숫자 합 비교
            int aSum = 0, bSum = 0;
            for (int i = 0; i < a.length(); i++) {
                if (Character.isDigit(a.charAt(i))) {
                    aSum += a.charAt(i) - '0';
                }
                if (Character.isDigit(b.charAt(i))) {
                    bSum += b.charAt(i) - '0';
                }
            }

            if (aSum != bSum) {
                return aSum - bSum;
            }

            // 3. 사전순 비교
            return a.compareTo(b);
        });

        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
