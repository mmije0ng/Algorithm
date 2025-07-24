import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Problem> problems = new ArrayList<>();

        // 입력: 8개 문제의 점수 입력받기
        for (int i = 1; i <= 8; i++) {
            int score = Integer.parseInt(br.readLine());
            problems.add(new Problem(i, score));
        }

        // 점수 기준 내림차순 정렬
        problems.sort((p1, p2) -> Integer.compare(p2.score, p1.score));

        // 상위 5개 점수 합산 + 문제 번호 수집
        int totalScore = 0;
        List<Integer> includedProblems = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            totalScore += problems.get(i).score;
            includedProblems.add(problems.get(i).index);
        }

        // 문제 번호 오름차순 정렬
        Collections.sort(includedProblems);

        // 출력
        System.out.println(totalScore);
        for (int index : includedProblems) {
            System.out.print(index + " ");
        }
    }

    // 문제 클래스 (문제 번호 + 점수)
    static class Problem {
        int index;
        int score;

        Problem(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}
