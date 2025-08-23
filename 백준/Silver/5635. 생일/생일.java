import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // [0]=이름, [1]=일, [2]=월, [3]=연
        Person[] arr = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            arr[i] = new Person(name, day, month, year);
        }

        // Comparator 체이닝으로 정렬
        Arrays.sort(arr, Comparator
                .comparingInt((Person p) -> p.year)
                .thenComparingInt(p -> p.month)
                .thenComparingInt(p -> p.day));

        // 가장 나이가 적은 사람 (최근 출생) → 마지막
        // 가장 나이가 많은 사람 (먼저 출생) → 처음
        System.out.println(arr[n - 1].name);
        System.out.println(arr[0].name);
    }

    static class Person {
        String name;
        int day, month, year;

        Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}
