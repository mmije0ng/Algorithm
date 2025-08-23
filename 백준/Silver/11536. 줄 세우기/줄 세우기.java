import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        // 첫 비교 방향 설정
        int direction = names[0].compareTo(names[1]);
        String result = (direction < 0) ? "INCREASING" : "DECREASING";

        for (int i = 1; i < N - 1; i++) {
            int cmp = names[i].compareTo(names[i + 1]);
            if ((direction < 0 && cmp > 0) || (direction > 0 && cmp < 0)) {
                result = "NEITHER";
                break;
            }
        }

        System.out.println(result);
    }
}
