import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine(); // 문자 "102"
        char[] arr = input.toCharArray();
        
        Character[] charArr = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            charArr[i] = arr[i]; // '1', '0', '2'
        }
        
        // 내림차순 정렬 '2', '1', '0'
        Arrays.sort(charArr, Comparator.reverseOrder());
        
        // 다시 char[]로 복사
        for (int i = 0; i < arr.length; i++) {
            arr[i] = charArr[i];
        }

        String sortedStr = new String(arr); 
        BigInteger number = new BigInteger(sortedStr);
        
        // 30의 배수이면
        if (number.mod(BigInteger.valueOf(30)).equals(BigInteger.ZERO))
            bw.write(number.toString());
        else
            bw.write("-1");

        bw.flush();
        bw.close();
        br.close();
    }
}
