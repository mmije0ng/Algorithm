import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        while(testCase--!=0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int aSize = Integer.parseInt(st.nextToken()); //A크기
            int bSize = Integer.parseInt(st.nextToken()); //B 크기

            Integer[] aList = new Integer[aSize];
            Integer[] bList = new Integer[bSize];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<aSize;i++) {
                aList[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<bSize;i++) {
                bList[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(aList,Collections.reverseOrder());
            Arrays.sort(bList, Collections.reverseOrder());

            int cnt=0;
            int bMin= bList[bSize-1];

            for(int i=0;i<aSize;i++){
                if(aList[i]<=bMin)
                    break;
                for(int j=0;j<bSize;j++){
                    if(aList[i]> bList[j]){
                        cnt+=bSize-j;
                        break;
                    }
                }
            }

            bw.write(Integer.toString(cnt) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}