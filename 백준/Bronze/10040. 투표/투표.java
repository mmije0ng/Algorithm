import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        int[] b = new int[M];
        int[] cntArr = new int[N];

        for (int i=0; i<N;i++)
            a[i] = Integer.parseInt(br.readLine());
        for (int i=0; i<M;i++)
            b[i] = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                // b[i]가 a[j]보다 크거나 같은 경우는 a[j]가 b[i]보다 작은 값중 가장 큰 값
                if(b[i]>=a[j]){
                    cntArr[j]++;
                    break;
                }

            }
        }

        int max=0;
        int maxIdx=0;
        for (int i=0;i<N;i++){
            if(cntArr[i]>max){
                max=cntArr[i];
                maxIdx=i;
            }
        }
        bw.write(Integer.toString(maxIdx+1));

        bw.flush();
        bw.close();
        br.close();
    }
}