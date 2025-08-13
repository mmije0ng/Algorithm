import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {
                inTag = true;
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
            } else if (ch == '>') {
                inTag = false;
                sb.append(ch);
            } else if (inTag) {
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                } else {
                    stack.push(ch);
                }
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }
}
