import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");

        int cnt=0;
        for(int i=1;i<=N;i++){
            if(Integer.parseInt(st.nextToken())!=i)
                cnt++;
        }

        bw.write(Integer.toString(cnt));


        bw.flush();
        bw.close();
        br.close();
    }
}