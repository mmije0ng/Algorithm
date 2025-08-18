import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {
            String s;
            while (true) {
                s = br.readLine();
                if (s != null && !s.isEmpty()) break;
            }

            Deque<Character> stack = new ArrayDeque<>();
            boolean invalid = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        invalid = true;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty() || invalid) {
                bw.write("NO");
            } else {
                bw.write("YES");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
