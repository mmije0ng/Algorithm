import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int powerA = Integer.parseInt(st.nextToken());
        int costA = Integer.parseInt(st.nextToken());
        int powerB = Integer.parseInt(st.nextToken());
        int costB = Integer.parseInt(st.nextToken());

        long maxPower=0;
        int x=0; int y=0;
        for (int i=N/costA; i>=0; i--){
            // 고용할 수 있는 명수 x=i, y=((N-(costA*i))/costB)
            long costSum= (long) costA *i + ((N-((long) costA *i))/costB)*costB; // 전체 비용
            long powerSum= (long) i *powerA+((N-((long) costA *i))/costB)*powerB; // 전체 전투력
            // 전체 비용이 N보다 작고
            if( costSum <=N &&  powerSum >maxPower  ) {
                maxPower=powerSum;
                x=i;
                y=((N-(costA*i))/costB);
            }
        }

        bw.write(Integer.toString(x)+" "+Integer.toString(y));
        bw.flush(); bw.close(); br.close();
    }
}