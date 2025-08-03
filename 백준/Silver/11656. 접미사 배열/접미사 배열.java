import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        String[] suffixes = new String[word.length()];

        // baekjoon, aekjoon, ekjoon, kjoon.. 이런식으로 저장
        for (int i = 0; i < word.length(); i++) {
            suffixes[i] = word.substring(i);
        }

        Arrays.sort(suffixes);

        for (String suffix : suffixes) {
            sb.append(suffix).append("\n");
        }

        System.out.println(sb);
    }
}
