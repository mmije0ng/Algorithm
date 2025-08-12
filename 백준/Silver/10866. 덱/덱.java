import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            String[] s = br.readLine().split(" ");

            switch (s[0]) {

                case "push_front": {
                    dq.addFirst(Integer.parseInt(s[1]));
                    break;
                }

                case "push_back": {
                    dq.addLast(Integer.parseInt(s[1]));
                    break;
                }

                case "pop_front": {
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
                    break;
                }

                case "pop_back": {
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
                    break;
                }

                case "size": {
                    sb.append(dq.size()).append('\n');
                    break;
                }

                case "empty": {
                    sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;
                }

                case "front": {
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
                    break;
                }

                case "back": {
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
