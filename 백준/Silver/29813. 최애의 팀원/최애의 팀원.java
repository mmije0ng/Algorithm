import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        String name;
        int num;
        Student(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Student> queue = new LinkedList<>();
        
        // 학생 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            queue.add(new Student(name, num));
        }

        while (queue.size() > 1) {
            Student front = queue.poll(); // 맨 앞 학생

            // 맨 앞 학번-1명 패스 → 큐 뒤로 보내기
            for (int i = 0; i < front.num - 1; i++) {
                Student pass = queue.poll();
                queue.add(pass);
            }

            // X번째 학생 = 팀원, 둘 다 나감 → 그냥 poll() 해서 버림
            queue.poll();
        }

        bw.write(queue.peek().name);

        bw.flush();
        bw.close();
        br.close();
    }
}