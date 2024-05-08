import java.io.*;
import java.util.*;

// 이분탐색
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        while(testCase--!=0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int aSize = Integer.parseInt(st.nextToken()); //a크기
            int bSize = Integer.parseInt(st.nextToken()); //b 크기

            Integer[] aList = new Integer[aSize]; //a배열
            Integer[] bList = new Integer[bSize]; //b배열

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<aSize;i++) {
                aList[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<bSize;i++) {
                bList[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(bList);

            int cnt=0;

            for(int i=0;i<aSize;i++){
                // 이분 탐색
                int left=0;
                int right=bSize-1;
                int mid=0;
                boolean isFind=false;

                while(left<=right){
                    mid=(left+right)/2;
                    if(aList[i]>bList[mid])
                        left=mid+1;
                    // 탐색값이 bList[mid]값보다 작거나 같다면
                    else
                        right=mid-1;
                }

                cnt+=left;
            }

            bw.write(Integer.toString(cnt) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}