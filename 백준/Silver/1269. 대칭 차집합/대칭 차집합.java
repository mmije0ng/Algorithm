import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A, B 집합 원소 개수
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 집합 A와 B를 각각 HashSet으로 선언
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        // 집합 A 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        // 집합 B 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        // A-B 계산 - setA에서 setB를 뺀 결과.
        Set<Integer> diffA = new HashSet<>(setA);
        diffA.removeAll(setB);

        // B-A 계산 - setB에서 setA를 뺀 결과.
        Set<Integer> diffB = new HashSet<>(setB);
        diffB.removeAll(setA);

        // 대칭 차집합 크기 출력
        System.out.println(diffA.size() + diffB.size());
    }
}
